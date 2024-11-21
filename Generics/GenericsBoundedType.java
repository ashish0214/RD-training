/*Create a class called GenericsBoundedType with a generic method max()
that takes in two objects of any type which implements Comparable and
 returns the maximum of the two objects.*/

package Generics;

public class GenericsBoundedType {
    public static <T extends Comparable> T sum(T object1, T object2) {
        if (object1.compareTo(object2) > 0) {
            return object1;
        }
        return object2;
    }

}
