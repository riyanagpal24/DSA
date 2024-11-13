package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public static void main(String[] args) {
        System.out.println(isIsomorphic("abab","baba"));
    }
    public static boolean isIsomorphic(String s, String t) {
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i=0; i<t.length(); i++){
            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i),0)+1);
        }

        if(map1.size()!=map2.size()) return false;
        int st =0;
        while(st<s.length()){
            if(s.charAt(st)!=t.charAt(st)){
                s=s.replace(s.charAt(st),t.charAt(st));
            }
            st++;
        }

        return s.equals(t);
    }
}
