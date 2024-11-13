package leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class DesignALeaderBoard {
    // https://leetcode.ca/all/1244.html

    Map<Integer,Integer> players = new HashMap<>();
    TreeMap<Integer,Integer> rank = new TreeMap<>((a,b)->b-a);

    public void addScore(int playerId, int score){
          players.put(playerId, players.getOrDefault(playerId,0)+ score);
          rank.merge(playerId,players.get(playerId),Integer::sum);

    }

   public void reset(int playerId){
        players.put(playerId,0);
   }


   public Integer findTopPlayer(int k){
        int cnt = 1;
        int score = 0;
      for(Map.Entry<Integer,Integer> r: rank.entrySet()){
           if(cnt<=k){
               score += r.getValue();
               cnt++;
           }
      }
      System.out.println("score: "+score);
      return score;
   }
}
