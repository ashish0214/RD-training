package CalssesAndObject.Task4;

import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;

public class UserNameValidator
{
    boolean validation(String username){
        int len=username.length();
        if(len<6){
            return false;
        }
        if(isLetter(username.charAt(0))){
        for(int i=0;i<len;i++){
            if(!(username.charAt(i)>=97 && username.charAt(i)<=122)){
                return false;
            }
        }
        }else
        {for(int i=0;i<len;i++){
            if(!isDigit(username.charAt(i))){
                return false;
            }
        }

        }
return true;
    }



    public static void main(String[] args) {
        UserNameValidator u=new UserNameValidator();
        if(u.validation("902877")){
            System.out.println("Valid user name");
        }else{
            System.out.println("Its not a valid username");
        }

    }
}
