package leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;

public class TwoCityScheduling {

    public static void main(String[] args) {
        int[][] costs = {{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}};
        System.out.print(twoCitySchedCost(costs));
    }

    public static int twoCitySchedCost(int[][] costs) {
        Comparator<int[]> comparator = Comparator.comparingInt(a -> a[0] - a[1]);

        Arrays.sort(costs,comparator);

        int cost = 0;

        for(int i=0; i<costs.length/2; i++){
            cost += costs[i][0];
        }

        for(int i=costs.length/2; i<costs.length; i++){
            cost += costs[i][1];
        }

        return cost;
    }
}
