package dev.brahms.Serialize;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import dev.brahms.Event;
import dev.brahms.Member;
import dev.brahms.Status;

import java.io.*;

public class MyUtilities {

    public static Member loadMemberFromFile(String filename) {

        // Crée un objet File pour le fichier JSON
        File file = new File(filename);
        try {
            // Crée un objet FileReader pour lire à partir du fichier
            FileReader reader = new FileReader(file);
            // Crée un objet XStream avec le pilote JSON
            XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
            // Configure XStream pour la désérialisation
            configureXS(xstream);
            // Désérialise le membre à partir du fichier et le renvoie
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