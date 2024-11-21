package Collection.Map_task.task5;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class PortionMapApp {
    private static <K extends Comparable<K>, V> Map<K, V> getPortionMap( Map<K, V> map,K startKey, K endKey) {
        Map<K, V> portionMap = new LinkedHashMap<>();

        SortedSet<K> portionKeySet = new TreeSet<>(map.keySet()).subSet(startKey, endKey);
        for (K key : portionKeySet) {
            portionMap.put(key, map.get(key));
        }
        return portionMap;
    }

}
