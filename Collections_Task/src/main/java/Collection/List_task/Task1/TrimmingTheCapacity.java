package Collection.List_task.Task1;

//Write a Java program to trim the capacity of an array list to the current list size.
import java.util.ArrayList;

public class TrimmingTheCapacity {
    public static <T> void trimList(ArrayList<T> list){
        list.trimToSize();

    }
}
