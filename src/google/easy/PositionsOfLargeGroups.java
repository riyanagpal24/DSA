package google.easy;

import java.util.ArrayList;
import java.util.List;

public class PositionsOfLargeGroups {


    public static void main(String[] args) {

        String test = "aaa";
        System.out.println(largeGroupPositions(test));
    }
    public static List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();

        int st=0;
        int e=st;
        int i;


        while(e<=s.length()-2){
            i = e+1;
            if(s.charAt(e)==s.charAt(i)){
                e++;
            }else{
                if(e-st+1>=3){
                    List<Integer> group = new ArrayList<>();
                    group.add(st);
                    group.add(e);
                    res.add(group);
                }
                st=e+1;
                e=st;
            }
        }

        if(e==s.length()-1 && e-st+1>=3){
            List<Integer> group = new ArrayList<>();
            group.add(st);
            group.add(e);
            res.add(group);
        }
        return res;
    }
}
