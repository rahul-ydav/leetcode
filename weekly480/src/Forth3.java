public class Forth3 {
    public int[] minDeletions(String str, int[][] queries) {

        StringBuilder s = new StringBuilder(str);
        int n = s.length();
        int[] pfd = new int[n];
        for(int i=1; i<n; i++){
            pfd[i] = pfd[i-1];
            if(s.charAt(i)==s.charAt(i-1)){
                pfd[i]++;
            }
        }


        FenwickTree fw = new FenwickTree(n);

        int len = 0;
        for(int[] q : queries){
            if(q.length==3) len++;
        }

        int[] ans = new int[len];

        if(n==1) return ans;

        int x = 0;
        for(int[] q : queries) {
            if (q.length == 2) {
                int next = 0;
                int val = 0;
                if(q[1]==0){
                    if(s.charAt(q[1])==s.charAt(q[1]+1)){
                        next = -1;
                    }
                    else next = 1;
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
                            val = -1;
                            next = -1;
                        }
                        else{
                            val = 1;
                            next = 1;
                        }
                    }
                    else{
                        if(s.charAt(q[1]-1)==s.charAt(q[1])){
                            val = -1;
                            next = 1;
                        }
                        else{
                            val = 1;
                            next = -1;
                        }
                    }
                }

                if(s.charAt(q[1])=='A') s.setCharAt(q[1], 'B');
                else s.setCharAt(q[1], 'A');

                if(val!=0)  fw.diffAdder(q[1], val);
                if(next!=0) fw.diffAdder(q[1]+1, next);
            }
            else{
                if(q[1]==q[2]){
                    ans[x] = 0;
                }
                else{
                    int res2 = fw.finder(q[2]);
                    int res1 = fw.finder(q[1]);
                    ans[x] = pfd[q[2]] - pfd[q[1]] + res2 - res1;
                }
                x++;
            }
        }
        return ans;
    }

    public class FenwickTree {

        int nodes;
        int[] fn;

        FenwickTree(int n){
            nodes = n;
            fn = new int[nodes];
        }

        int lsbFinder(int idx){
            return idx & -idx;
        }

        void diffAdder(int idx, int val){
            while(idx<nodes){
                fn[idx] +=val;
                idx = idx+lsbFinder(idx);
            }
        }

        void update(int idx, int val){
            int diff = val - fn[idx];
            diffAdder(idx, diff);
        }

        int finder(int idx){
            int x = 1;
            int res = 0;
            while(idx>0){
                if((idx & x)==x){
                    res += fn[idx];
                    idx = idx ^ x;
                }
                x = x<<1;
            }

            return res;
        }
    }
}
