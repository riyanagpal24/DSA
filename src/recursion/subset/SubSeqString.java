package recursion.subset;

import java.util.ArrayList;
import java.util.Arrays;

public class SubSeqString {

    public static void main(String args[]){
        //subSeq("","abc");
        ArrayList<String> subSets = subSeqInMethod("","abc", new ArrayList<>());
        System.out.print(subSets.toString());
    }

    public static void subSeq(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        Character ch = (Character) up.charAt(0);
        subSeq(p + ch, up.substring(1));
        subSeq(p, up.substring(1));
    }

    public static ArrayList<String> subSeqInArray(String p, String up, ArrayList<String> arr) {
        if (up.isEmpty()) {
            arr.add(p);
            return arr;
        } else {
            Character ch = (Character) up.charAt(0);
            // substring is creating a new variable - string is immutable
            // so this does not update the up string
            subSeqInArray(p + ch, up.substring(1), arr);
            subSeqInArray(p, up.substring(1), arr);
            return arr;
        }
    }

    public static ArrayList<String> subSeqInMethod(String p, String up, ArrayList<String> arr){
        if(up.isEmpty()){
            ArrayList<String> sub = new ArrayList<>();
            sub.add(p);
            return sub;
        }

        Character ch = (Character) up.charAt(0);
        // substring is creating a new variable - string is immutable
        // so this does not update the up string

        // retrieve the ans from the left tree
        ArrayList<String> left = subSeqInMethod(p + ch, up.substring(1),arr);

        // retrieve the ans from the right tree
        ArrayList<String> right = subSeqInMethod(p, up.substring(1),arr);

        // combine them in one - for one func call (where you take one and ignore the char in the right
        // send the list back
        left.addAll(right);
        return left;


    }



}
