package CalssesAndObject.Task3;

public class CallClass {
    public static void main(String[] args) {
        Movie m=new Movie("tiger2","Ashish",2000,"action",3.5f);
        System.out.println("Updated Average Rating: "+m.add_Review(4.3f));
        System.out.println("Updated Average Rating: "+m.add_Review(3.2f));

        System.out.println("Updated Average Rating: "+m.add_Review("not So good"));

        System.out.println(m.get_Movie_Details());
    }
}
