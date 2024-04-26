package dev.brahms.Serialize;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import dev.brahms.Event;
import dev.brahms.Member;
import dev.brahms.Status;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MyUtilities {

   public static Member loadMemberFromFile(String filename) {

       File file = new File(filename);

       XStream xstream = new XStream(new JsonHierarchicalStreamDriver());

       configureXS(xstream);

       return (Member) xstream.fromXML(file);
   }

   public static void saveMemberToJsonFile(Member member, String filename) {

       File file = new File(filename);
       FileWriter fw = null;

       XStream xstream = new XStream(new JsonHierarchicalStreamDriver());

       configureXS(xstream);

       try {
           fw = new FileWriter(file);
           xstream.toXML(member, fw);
       } catch (IOException e) {
           e.printStackTrace();
       } finally {
           if(fw != null) {
               try {
                   fw.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
       }
   }

    private static void configureXS(XStream xstream) {
       xstream.addPermission(AnyTypePermission.ANY);
       xstream.alias("member", Member.class);
       xstream.alias("event", Event.class);
       xstream.aliasField("firstname", Member.class, "prenom");
       xstream.aliasField("lastname", Member.class, "nom");
       xstream.aliasField("status", Status.class, "statut");
       xstream.aliasField("events", Member.class, "évenements");
    }
}
