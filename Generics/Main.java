package Generics;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Task1

        List<Integer> list= Arrays.asList(2,3,57,17,7,11,101);
        int count=CountItemsOfList.CountElemnts(list);
        System.out.println("The Count for prime number:"+count);

        //Task2

        List<Integer> newList=PositionSwapOfToElements.swapPosition(list,-1,5);
        System.out.println("List after position swap:"+newList);

        //Task3
        List<Integer> sumList=new ArrayList<>();
        sumList.add(1);
        sumList.add(3);
        sumList.add(7);
        sumList.add(10);
        List<Integer> resultOfSum=SumOfEvenAndOdd.sum(sumList);
        System.out.println("the sum of Even Elements: "+resultOfSum.get(0));
        System.out.println("the sum of Odd Elements: "+resultOfSum.get(1));

        //Task4
        List<String > strList=new ArrayList<>();
        strList.add("hello");
        strList.add("Morning");
        strList.add("bye");
        strList.add("Good");
        System.out.println(FindPositionOfSpecificElement.findPosition(strList,"bye"));


        //Task5
        System.out.println(GenericsBoundedType.sum(70,80));
        System.out.println(GenericsBoundedType.sum("hello","zoo"));
    }
}
