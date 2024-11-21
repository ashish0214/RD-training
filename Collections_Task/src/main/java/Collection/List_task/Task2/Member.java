package Collection.List_task.Task2;

public class Member implements Comparable {
    private String memberName;
    private int id;

    public Member(int id, String memberName) {
        this.id = id;
        this.memberName = memberName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", memberName='" + memberName + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        String name=(String)o;
        return this.memberName.compareTo(name);
    }
}
