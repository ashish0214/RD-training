package Collection.List_task.Task2;

import java.util.*;

/*1. adding membersb.   2.deleting membersc.  3.listing all registered membersd.
 4.search memberse.   5.update members 6.sort member names alphabetically*/

public class ClubManaging {
    List<Member> list;
    int id;

    public ClubManaging() {
        this.list = new ArrayList<>();
        id = 1;
    }

    public void addingMember(String name) {
        list.add(new Member(id++, name));
    }

    public void removingMember(String name) {
        list.removeIf(member -> member.getMemberName().equalsIgnoreCase(name));
    }

    public void registeredUsers() {
        for (Member m : list) {
            System.out.println(m);
        }
    }

    public void searchMember(String name) {
        for (Member m : list) {
            if (m.getMemberName().equalsIgnoreCase(name)) {
                System.out.println(m);
            }
        }
    }

    public void updateMember(String oldName, String newName) {
        for (Member m : list) {
            if (m.getMemberName().equalsIgnoreCase(oldName)) {
                m.setMemberName(newName);
            }
        }
    }

    public void alphabeticallySortNames() {
        Collections.sort(list);
    }

}
