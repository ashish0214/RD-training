package Collection.Set_task;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class CompareLinkedhashSetAndTreeSet {
    public static void compareBoth(LinkedHashSet list, TreeSet tree) {
        Iterator iterateLinkedset = list.iterator();
        Iterator iterateTreeset = tree.iterator();

        System.out.println("LinkedHashSet Response: ");
        while (iterateLinkedset.hasNext()) {
            System.out.print(iterateLinkedset.next() + " ");
        }

        System.out.println();

        System.out.println("TreeSet Response: ");
        while (iterateTreeset.hasNext()) {
            System.out.print(iterateTreeset.next() + " ");
        }
        System.out.println();
        System.out.println("From the above responses \n The LinkedHashSet maintains the order " +
                "\n The tree set does not maintain but sorts it");
    }

    public static void main(String[] args) {
        LinkedHashSet<Integer> linkedhashSet = new LinkedHashSet<>(Arrays.asList(45, 78, 90, 1, 8, 0, 23));
        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(45, 78, 90, 1, 8, 0, 23));
        compareBoth(linkedhashSet, treeSet);


    }
}
