package Collection.Map_task.task3;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class MapCollection<K extends Comparable<K>, V> {

    private Map<K, V> map;

    public MapCollection() {
        this.map = new HashMap<>();
    }

    public void putValues( K key, V value) {
        map.put(key, value);
    }

    public void searchKeyAndItsValue( K key) {
        if(map.containsKey(key)) {
            System.out.println(String.format("Value for key: %s is %s ", key, map.get(key)));
        } else {
            System.out.println(String.format("%s key is not present in the teamMap", key));
        }
    }

    public void getKeyAndValue() {
        for ( Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println(String.format("Key: %s, Value: %s", entry.getKey(), entry.getValue()));
        }
    }

    public void sortKeys() {
         SortedSet<K> sortedKeys = new TreeSet<>(Comparable::compareTo);
        sortedKeys.addAll(map.keySet());
        System.out.println("Sorted Keys: " + sortedKeys);
    }

    public void deleteAll() {
        map.clear();
    }
}


