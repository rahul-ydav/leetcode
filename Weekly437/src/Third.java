import java.util.Arrays;

public class Third {
    public boolean maxSubstringLength(String s, int k) {
        int[][] mp = new int[26][2];

        for(int i=0; i<26; i++){
            mp[i][0] = -1;
            mp[i][1] = -1;
        }

        for(int i=0; i<s.length(); i++){
            int x = s.charAt(i)- 'a';

            if(mp[x][0]==-1) mp[x][0] = i;
            mp[x][1] = i;
        }
        int len = 0;
        int nuclie = 0;
        for(int i=0; i<26; i++){
            if(mp[i][0]!=-1) len++;
            if(mp[i][0]!=-1 && mp[i][0]==mp[i][1]) nuclie++;
        }

        if(nuclie>=k) return true;

        int[][] pairs = new int[len][2];
        int x=0;
        for(int i=0; i<26; i++){
            if(mp[i][0]!=-1){
                pairs[x][0] = mp[i][0];
                pairs[x][1] = mp[i][1];
                x++;
            }
        }

        Arrays.sort(pairs, (a, b)->{
            if(a[0]==b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });

        int li = 0;

//        for(int i=0; i<len; i++){
//            System.out.println("vals: ["+pairs[i][0]+", "+pairs[i][1]+"]");
//            li = -1;
//            int count = 0;
//
//            for(int j=i; j<len; j++){
//                if(li<pairs[j][0]){
//                    count++;
//                    li = pairs[j][1];
//                }
//                if(count>=k) return true;
//            }
//        }

        return false;
    }

    boolean kPairs(int[][] pairs, int len, int k, int count, int i, int li){
        if(i==len)  return false;
        if(count>=k)    return true;

        if(li<pairs[i][0]){
            count++;
            li = pairs[i][1];
//            return kPairs(pairs, len, count+1, i+1, li+pairs[i][1])
        }
        return false;
    }
}
