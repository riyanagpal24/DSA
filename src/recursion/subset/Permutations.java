package recursion.subset;

import java.util.ArrayList;

public class Permutations {


    public static void main(String args[]){
        //allPermutations("","abc");
        ArrayList<String> arr = permInList("","abcd");
        System.out.println(arr);
        System.out.print(permCount("","abcd"));
    }

    public static void allPermutations(String p, String up){
        if(up.isEmpty()) {
            System.out.println(p);
            return;
        }

        for(int i=0; i<=p.length(); i++){
            Character ch = up.charAt(0);
            String first = p.substring(0, i);
            String second = p.substring(i,p.length());
            allPermutations(first+ch+second,up.substring(1));
        }


    }

    public static ArrayList<String> permInList(String p, String up){
        if(up.isEmpty()) {
            ArrayList<String> arr = new ArrayList<>();
            arr.add(p);
            return arr;
        }

        ArrayList<String> arr = new ArrayList<>();
        for(int i=0; i<=p.length(); i++){
            Character ch = up.charAt(0);
            String first = p.substring(0, i);
            String second = p.substring(i,p.length());
            arr.addAll(permInList(first+ch+second,up.substring(1)));
        }

        return arr;
    }

    public static int permCount(String p, String up){
        if(up.isEmpty()) {
            return 1;
        }

        int count = 0;
        for(int i=0; i<=p.length(); i++){
            Character ch = up.charAt(0);
            String first = p.substring(0, i);
            String second = p.substring(i,p.length());
            count = count + permCount(first+ch+second,up.substring(1));
        }

        return count;
    }
}
