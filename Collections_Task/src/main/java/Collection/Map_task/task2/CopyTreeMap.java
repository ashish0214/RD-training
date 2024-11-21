package Collection.Map_task.task2;

import java.util.TreeMap;

public class CopyTreeMap {
    public <K, V> void copyTreeMap(TreeMap<K, V> original, TreeMap<K, V> copy) {
        copy.putAll(original);
    }

}
