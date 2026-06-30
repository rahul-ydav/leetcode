import java.util.HashMap;

class Third {
    public int longestBalanced(String s) {

        int n = s.length();

        int[] pf0 = new int[n+1];
        int[] pf1 = new int[n+1];
        int[] ctr = new int[n+1];


        for(int i=0; i<n; i++){
            if(s.charAt(i)=='0'){
                pf0[i+1] = 1+pf0[i];
                pf1[i+1] = pf1[i];
                ctr[i+1] = ctr[i]-1;
            }
            else{
                pf1[i+1] = 1+pf1[i];
                pf0[i+1] = pf0[i];
                ctr[i+1] = ctr[i]+1;
            }
        }

        if(ctr[n]==2 || ctr[n]==-2){
            return n-2;
        }

        HashMap<Integer, Integer> hm = new HashMap<>();

        int ans = 0;
        for(int i=0; i<n+1; i++){
            if(hm.containsKey(ctr[i])){
                int res = i-hm.get(ctr[i]);
                ans = Math.max(ans, res);
            }
            else hm.put(ctr[i], i);

            if(hm.containsKey(ctr[i]-2)){
                int pos = hm.get(ctr[i]-2);
                int res = i-hm.get(ctr[i]-2);
                if(pf0[pos]>0 || pf0[n]-pf0[i]>0){
                    ans = Math.max(ans, res);
                }
            }

            if(hm.containsKey(ctr[i]+2)){
                int pos = hm.get(ctr[i]+2);
                int res = i-hm.get(ctr[i]+2);
                if(pf1[pos]>0 || pf1[n]-pf1[i]>0){
                    ans = Math.max(ans, res);
                }
            }
        }



        return ans;


    }
}