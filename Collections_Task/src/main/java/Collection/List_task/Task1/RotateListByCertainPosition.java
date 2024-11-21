package Collection.List_task.Task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateListByCertainPosition {
    public static <T> List<T> shiftElemetsPosition(List<T> list, int position) {
        rotate(list, 0, position - 1);
        rotate(list, position, list.size()-1);
        rotate(list, 0, list.size()-1);
        return list;
    }

    public static <T> void rotate(List<T> list, int start, int end) {
        while (start < end) {
            T temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, temp);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(29, 56, 87, 34, 90, 78, 56);
        System.out.println( shiftElemetsPosition(list, 3));
    }
}
