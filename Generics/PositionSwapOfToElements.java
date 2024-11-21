/*Write a generic method to exchange the positions of two different
 elements in an array */

package Generics;

import java.util.List;

public class PositionSwapOfToElements {
    public static <T> List<T> swapPosition(List<T> list, int position1, int position2) {
        if (!checkPositionArevalid(position1, position2, list.size())) {
            return list;
        }
        T temp = list.get(position1);
        list.set(position1, list.get(position2));
        list.set(position2, temp);
        return list;
    }

    static boolean checkPositionArevalid(int pos1, int pos2, int length) {
        if (pos1 < length || pos1 >= 0 || pos2 < length || pos2 >= 0 || pos1 == pos2)
            return false;

        return true;
    }

}
