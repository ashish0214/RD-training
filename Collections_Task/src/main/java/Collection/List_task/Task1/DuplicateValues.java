package Collection.List_task.Task1;

//Create a Java program that finds the duplicate elements in a list.

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class DuplicateValues {
    public static <T> List<T> findduplicate(ArrayList<T> list){
        ArrayList<T> duplicateElemets=new ArrayList<>();
        for(int index=0;index<list.size();index++){
            T element=list.get(index);
            if( list.lastIndexOf(element)>index && !duplicateElemets.contains(element) ){
                duplicateElemets.add(element);

            }
        }

return duplicateElemets;
    }


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(25);
        list.add(39);
        list.add(45);
        list.add(78);
        list.add(78);
        list.add(39);
        list.add(5);
        list.add(39);
        System.out.println(findduplicate(list));

    }
}
