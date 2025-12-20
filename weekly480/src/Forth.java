import java.util.TreeMap;

class Forth {
    public int[] minDeletions(String s, int[][] queries) {


        int n = s.length();
        int[] pfd = new int[n+1];
        for(int i=1; i<n; i++){
            pfd[i+1] = pfd[i];
            if(s.charAt(i)==s.charAt(i-1)){
                pfd[i+1]++;
            }
        }

        int len = 0;
        for(int[] q : queries){
            if(q.length==3) len++;
        }

        int[] ans = new int[len];

        TreeMap<Integer, Integer> inc = new TreeMap<>();
        int x = 0;
        for(int[] q : queries){
            if(q.length==2){
                int val = 0;
                if(q[1]==0){
                    if(s.charAt(q[1])==s.charAt(q[1]+1)){
                        val = -1;
                    }
                    else val = 1;
                }
                else if(q[1]==n-1){
                    if(s.charAt(q[1])==s.charAt(q[1]-1)){
                        val = -1;
                    }
                    else val = 1;
                }
                else{
                    if(s.charAt(q[1]-1)==s.charAt(q[1]+1)){
                        if(s.charAt(q[1]-1)==s.charAt(q[1])){
                            val = -2;
                        }
                        else val = 2;
                    }
                }
                inc.put(q[1], val);
            }
            else{
                // int l = inc.ceilingKey(q[1]);
                // int r = inc.higherKey(q[2]) || n;

                int sum = 0;
                for (var e : inc.subMap(q[1], true, q[2], true).entrySet()) {
                    sum += e.getValue();
                }
                ans[x] = (pfd[q[2]+1] - pfd[q[1]+1]) + sum;
                x++;

            }

        }

        return ans;
    }
}