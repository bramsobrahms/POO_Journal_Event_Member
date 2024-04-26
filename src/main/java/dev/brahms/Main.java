package dev.brahms;


import dev.brahms.Serialize.MyUtilities;

public class Main {
    public static void main(String[] args) {

        Member member = new Member("Bob", "Sully", 'h', "bob");
        Status status_vip = Status.VIP;

        Event event1 = new Event("Concert", "2023-04-24T18:30", 30d);
        Event event2 = new Event("Party", "2022-04-24T18:30");

        member.getEvents().add(event1);
        member.getEvents().add(event2);
        member.setStatus(status_vip);
        System.out.println(member);

        // Saves the details of the Member to JSON file.
        MyUtilities.saveMemberToJsonFile(member, "dataFileJson.json");

        // Restores the details of the Member from the JSON file.
        // #TODO look why isn't working
        // Member restore = MyUtilities.loadMemberFromFile("dataFileJson.json");
        //System.out.println(restore);

    }
}