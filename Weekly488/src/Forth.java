import java.util.Arrays;

class Forth {
    int[] nums1;
    int[] nums2;
    long[][][] dp = new long[101][101][101];
    public long maxScore(int[] nums1, int[] nums2, int k) {

        this.nums1 = nums1;
        this.nums2 = nums2;

        for(int i=0; i<101; i++){
            for(int j=0; j<101; j++){
                Arrays.fill(dp[i][j], Long.MIN_VALUE);
            }
        }
        return finder(k, nums1.length-1, nums2.length-1);
    }

    long finder(int k, int i1, int i2){
        if(k==0)    return 0L;
//        if(i1<0 || i2<0){
//            return Long.MIN_VALUE;
//        }
        if(dp[k][i1][i2]!=Long.MIN_VALUE) return dp[k][i1][i2];
        System.out.println("i1: "+i1+", i2: "+i2+", k: "+k);

        long res = Long.MIN_VALUE/4;
        if(i1>0 && i2>0) res = (long)nums1[i1]*nums2[i2] + finder(k-1, i1-1, i2-1);
//        if(res1!=Long.MIN_VALUE){
//            res = res1 + (long)nums1[i1]*nums2[i2];
//        }
        if(i1>0)    res = Math.max(res, finder(k, i1-1, i2));
        if(i2>0)    res = Math.max(res, finder(k, i1, i2-1));

        dp[k][i1][i2] = res;
        return res;
    }
}