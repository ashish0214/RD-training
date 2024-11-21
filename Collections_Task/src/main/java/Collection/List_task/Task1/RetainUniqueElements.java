package Collection.List_task.Task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RetainUniqueElements {
    public static <T> List<T> returnUniqueElement(List<T> list, List<T> list2) {
        List<T> unique = new ArrayList<>();
        for (T elements : list) {
            if (list2.contains(elements)) {
                unique.add(elements);
            }
        }
        return unique;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 96, 100);
        List<Integer> list1 = Arrays.asList(100, 5, 8);
        System.out.println(returnUniqueElement(list, list1));
    }
}
