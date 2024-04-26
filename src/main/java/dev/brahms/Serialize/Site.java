package dev.brahms.Serialize;

import dev.brahms.Member;

import java.util.ArrayList;

public class Site {

    private ArrayList<Member> members = new ArrayList<>();

    public Site() {}


    public ArrayList<Member> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<Member> members) {
        this.members = members;
    }

    public void addMember(Member member) {
        this.members.add(member);
    }

    @Override
    public String toString() {
        return "Site{" +
                "members=" + members +
                '}';
    }
}
