package Collection.List_task.Task3;

import java.util.ArrayList;
import java.util.List;

public class ListOperation {
    public List<Integer> joinList(List<Integer> list1, List<Integer> list2) {
        list1.addAll(list2);
        return list1;
    }

    public List<Integer> cloneOfList(List<Integer> list) {
        return new ArrayList<Integer>(list);
    }

    public boolean comparisionOfList(List<Integer> list1, List<Integer> list2) {
        return list1.equals(list2);
    }
}
