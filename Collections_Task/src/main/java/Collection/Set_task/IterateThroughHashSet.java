package Collection.Set_task;

import java.util.*;

public class IterateThroughHashSet {
    public static boolean checkOrderIsPreserved(Set<String> monthSet, List<String> monthList){
        Iterator listIterate=monthList.iterator();
        Iterator setIterator=monthSet.iterator();
        while (listIterate.hasNext()&& setIterator.hasNext()){
            if(!listIterate.next().equals(setIterator.next())){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        List<String>list=new ArrayList<>();
        HashSet<String>set=new HashSet<>();
        list.add("monday");
        list.add("tuesday");
        list.add("wednesday");
        list.add("thurseday");
        list.add("friday");
        list.add("saturday");
        list.add("sunday");
        set.add("monday");
        set.add("tuesday");
        set.add("wednesday");
        set.add("thurseday");
        set.add("friday");
        set.add("saturday");
        set.add("sunday");
        System.out.println( checkOrderIsPreserved(set,list));

    }

    
}
