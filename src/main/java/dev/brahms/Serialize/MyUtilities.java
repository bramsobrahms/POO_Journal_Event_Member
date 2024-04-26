package dev.brahms.Serialize;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import dev.brahms.Member;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class MyUtilities {

    public static String readFile(String fileName) {

        StringBuilder strBuild = new StringBuilder();
        Path path = Paths.get(fileName);
        List<String> lines = null;

        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert lines != null;
        for(String line : lines) {
            strBuild.append(line);
            strBuild.append("\n");
        }

        return strBuild.toString();
    }


    public static void writeToFile(String formattedString, String fileName) {

        Path path = Paths.get(fileName);
        List<String> lines = new ArrayList<>();

        lines.add(formattedString);

        try{
            Files.write(path, lines);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String convertSiteToJSONString(Site site) {

        String jsonString = null;

        XStream xstream = new XStream(new JettisonMappedXmlDriver());

        configJsonXStream(xstream);

        jsonString = xstream.toXML(site);

        return jsonString;
    }

    public static Site convertJSONStringToSite(String jsonString) {

        Site site = null;

        XStream xstream = new XStream(new JettisonMappedXmlDriver());

        configJsonXStream(xstream);

        site = (Site) xstream.fromXML(jsonString);

        return site;
    }

    private static void configJsonXStream(XStream xstream) {

        xstream.addPermission(AnyTypePermission.ANY);
        xstream.alias("member", Member.class);
        xstream.alias("firstname", Member.class);
        xstream.aliasField("firstname", Member.class, "prenom");
        xstream.alias("lastname", Member.class);
        xstream.aliasField("lastname", Member.class, "nom");
        xstream.alias("status", Member.class);
        xstream.aliasField("status", Member.class, "statut");

    }
}
