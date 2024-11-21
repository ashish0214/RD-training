package Collection.List_task.Task1;

/*Write a Java program to replace all occurrences of a specified
element in an array list with another element.*/

import java.util.ArrayList;
import java.util.List;

public class ReplaceingElements {
    public static <T extends Object> List<T> replaceAllElements(List<T> list, T elementToBeReplaced, T byValue) {
        int count = 0;
        for (T element : list) {
            if (element.equals(elementToBeReplaced)) {
                list.set(count, byValue);
            }
            count++;
        }
        return list;

    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(25);
        list.add(39);
        list.add(45);
        list.add(78);
        list.add(39);
        list.add(5);
        list.add(39);
        System.out.println("List before replace:" + list);
        System.out.println("List after replace:" + replaceAllElements(list, 39, 99));


    }
}
