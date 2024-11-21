package CalssesAndObject.Task5;

import java.util.Scanner;

public class Count {
    static int countWords(String sentence,String newWord ,String replaceWord){
       String []words=sentence.split(" ");
       StringBuilder newSentance=new StringBuilder(words.length);
       for(int i=0;i<words.length;i++){
           if(words[i].equalsIgnoreCase(replaceWord)){
               words[i]=newWord;
           }
       }
       for(int i=0;i<words.length;i++){
           newSentance.append(words[i]+" ");
       }
        System.out.println(newSentance.toString());
       return words.length;
    }



    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("enter the sentance ");
        String sentence=sc.nextLine();
        System.out.println("enter the  word to be replaced");
        String replaceWord=sc.next();
        System.out.println("enter the replace word");
        String replace=sc.next();


        System.out.println(countWords(sentence,replace,replaceWord));
    }
}
