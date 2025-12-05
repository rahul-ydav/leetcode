import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Jan4UniqueLen {
    public static void main(String[] args){
        String s = "aabca";
        int res = countPalindromicSubsequence(s);
        System.out.println("res: "+res);
    }
    public static int countPalindromicSubsequence(String s) {

        int res = 0;
        int[][] map = new int[26][2];

        for (int[] ints : map) Arrays.fill(ints, -1);

        for(int i=0; i<s.length(); i++){
            int pos = s.charAt(i)-97;
            if(map[pos][0]==-1) map[pos][0] = i;
        }
        for(int i=s.length()-1; i>=0; i--){
            int pos = s.charAt(i)-97;
            if(map[pos][1]==-1) map[pos][1] = i;
        }

        for(int[] ints : map){
            if(ints[0]==-1 || ints[1]==-1)  continue;
            HashSet<Character> hs = new HashSet<>();
            for(int i=ints[0]+1 ;i<ints[1]; i++){
                hs.add(s.charAt(i));
            }

            res += hs.size();
        }
        return res;
    }
}
