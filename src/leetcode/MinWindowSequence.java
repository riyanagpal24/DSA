package leetcode;

public class MinWindowSequence {

    public static void main(String[] args) {
        String s1 = "abcdebdde";
        String s2 = "bde";
        System.out.println(findMinSeq("",s1,s2));
    }

    static String res ="";

    private static String findMinSeq(String p,String up,  String s2){
        if(s2.isEmpty()){
            return p;
        }
        int i =0;
        int j =0;
        int min = Integer.MAX_VALUE;

        if(p.isEmpty() && up.charAt(i)!=s2.charAt(j)){
            i++;
        }

            if(up.charAt(i)==s2.charAt(j)){
               p=  findMinSeq(p+up.charAt(i++),up.substring(i),s2.substring(j+1));
            }else if(!p.isEmpty()){
               p=   findMinSeq(p+up.charAt(i++),up.substring(i),s2.substring(j));
            }

            if(!up.isEmpty()){
                if(min>p.length()){
                    min = p.length();
                    res = p;

                }
            }



        return res;
    }
}
