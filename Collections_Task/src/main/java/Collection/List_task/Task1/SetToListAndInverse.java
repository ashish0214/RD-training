package Collection.List_task.Task1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetToListAndInverse {
    public static <T> Set<T> conversionToSet(List<T> list){
        return new HashSet<>(list);
    }
    public static <T> List<T> conversionToSet(Set<T> list){
        return new ArrayList<>(list);
    }

}
