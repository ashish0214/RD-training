/* Write a Java program to create a generic method that takes a list of any type and
a target element. It returns the index of the first occurrence of the target
element in the list. Return -1 if the target element cannot be found.*/

package Generics;
import java.util.List;

public class FindPositionOfSpecificElement {
    public static <T> int findPosition(List<T> list, T target) {
        int index = 0;
        for (T element : list) {
            if (target.equals(element)) {
                return index;
            }
            index++;
        }
        return -1;
    }
}
