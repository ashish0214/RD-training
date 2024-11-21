package Java8Features.lambda;

import java.util.function.BiFunction;

public class ValidateTwoStrings {

    BiFunction<String, String, Boolean> isTwoStringRotate = (element1, element2) -> {
        int last = element1.length() - 1;
        if (!(element2.length() == element1.length())) {
            return false;
        } else {
            for (int i = 0; i < element2.length(); i++) {
                if (!(element1.charAt(i) == element2.charAt(last))) {
                    return false;
                }
                last--;
            }
            return true;
        }

    };

    public static void main(String[] args) {
        ValidateTwoStrings validate = new ValidateTwoStrings();
        if (validate.isTwoStringRotate.apply("ashish", "hsihsa")) {
            System.out.println("Two Strings are rotated of each other");
        } else {
            System.out.println("Two Strings are not Rotated of each other");
        }
    }
}
