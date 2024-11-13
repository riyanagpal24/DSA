package leetcode;

import java.util.HashMap;
import java.util.Map;

public class XofAKindInADeckOfCards {

    public static void main(String[] args) {
        int[] deck = {1,1,1,1,2,2,2,2,2,2};
        System.out.print(hasGroupsSizeX(deck));
    }

    public static boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : deck) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int gcd = 0;
        for (int val : map.values()) {
            gcd = gcd(gcd, val);
        }

        return gcd > 1;
    }

    public static int gcd(int a, int b) {
        return (b == 0)? a : gcd(b, a % b);
    }


}
