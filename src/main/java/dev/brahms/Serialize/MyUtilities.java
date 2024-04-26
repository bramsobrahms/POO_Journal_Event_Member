package dev.brahms.Serialize;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import dev.brahms.Member;
import dev.brahms.Status;

import java.io.*;

public class MyUtilities {

    public static Member loadMemberFromFile(String filename) {

        File file = new File(filename);
        try {
            // Create FileReader for read
            FileReader reader = new FileReader(file);
            // Create an object with Json pilot
            XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
            // Config XStream for deserialize
            configureXS(xstream);
            // deserialize member from file
            return (Member) xstream.fromXML(reader);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
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
        xstream.alias("Membre", Member.class);
        xstream.aliasField("prénom", Member.class, "firstname");
        xstream.aliasField("nom", Member.class, "lastname");
        xstream.aliasField("genre", Member.class, "gender");
        xstream.aliasField("login", Member.class, "login");
        xstream.aliasField("somme", Member.class, "money");
        xstream.aliasField("statut", Status.class, "status");
        xstream.aliasField("Évenements", Member.class, "events");
    }
}
