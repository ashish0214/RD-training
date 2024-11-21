package Collection.Map_task.task4;

import java.util.Map;
import java.util.TreeMap;

public class PersonHeight {

    private final Map<String, Double> personHeightMap;

    public PersonHeight() {
        this.personHeightMap = new TreeMap<>();
    }

    public void addPersonHeight(final String name, final double height) {
        personHeightMap.put(name, height);
    }

    public void removePerson(final String name) {
        personHeightMap.remove(name);
    }

    public void printMap() {
        System.out.println(personHeightMap);
    }

    public static void main(String[] args) {
         PersonHeight personHeightApp = new PersonHeight();
        personHeightApp.addPersonHeight("Bob", 6.0);
        personHeightApp.addPersonHeight("Alice", 5.6);
        personHeightApp.addPersonHeight("Charlie", 5.9);

        personHeightApp.removePerson("Charlie");
        personHeightApp.printMap();
    }

}
