import java.util.TreeMap;

public class Forth2 {
    public int[] minDeletions(String str, int[][] queries) {

        StringBuilder s = new StringBuilder(str);
        int n = s.length();
        int[] pfd = new int[n+1];
        int[] changes = new int[n+1];
        for(int i=1; i<n; i++){
            pfd[i] = pfd[i-1];
            if(s.charAt(i)==s.charAt(i-1)){
                pfd[i]++;
            }
        }


        SegmentTree sg = new SegmentTree(changes);

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

                if(val!=0)  sg.updateSegmentTree(q[1], val);
                if(next!=0) sg.updateSegmentTree(q[1]+1, next);
            }
            else{
                if(q[1]==q[2]){
                    ans[x] = 0;
                }
                else{
                    int res = sg.segmentSum(0, 0, sg.n-1, q[1]+1, q[2]);
                    ans[x] = pfd[q[2]] - pfd[q[1]] + res;
                }
                x++;
            }
        }
        return ans;
    }

    class SegmentTree{
        int n;
        int sgLen;
        int[] sg;
        int[] nums;

        SegmentTree(int[] nums){
            n = nums.length;
            this.nums = nums;

            int justGreaterPow = Integer.highestOneBit(n-1) << 1;

            sgLen = justGreaterPow<<1;
            if(sgLen==0)    sgLen = 1;
            sg = new int[sgLen];
        }

        void updateSegmentTree(int idx, int val){
            updateSg(idx, val, 0, 0, n-1);
            nums[idx] += val;
        }

        void updateSg(int idx, int diff, int si, int l, int r){
            sg[si]+=diff;
            if(l==r)    return;
            int mid = l + (r-l)/2;
            if(idx<=mid){
                updateSg(idx, diff, 2*si+1, l, mid);
            }
            else updateSg(idx, diff, 2*si+2, mid+1, r);
        }

        int segmentSum(int si, int sl, int sr, int l, int r){
            if(r<sl || l>sr)    return 0;

            if(sl>=l && sr<=r){
                int res = sg[si];
                return res;
            }

            int sum = 0;
            int mid = sl + (sr-sl)/2;
            sum += segmentSum(2*si+1, sl, mid, l, r);
            sum += segmentSum(2*si+2, mid+1, sr, l, r);

            return sum;
        }
    }
}
