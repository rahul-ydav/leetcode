import java.util.HashSet;

public class Lt2261 {
    public int countDistinct(int[] nums, int k, int p) {

        int n = nums.length;
        int res = 0;
        long base = 5;
        long mod1 = 1000_000_007;
        long val1 = 0;
        long mod2 = 1000_000_009;
        long val2 = 1;

        for(int len=1; len<=n; len++){
            HashSet<Long> hs = new HashSet<>();
            long pow = 1;
            int count = 0;
            for(int i=0; i<len; i++){
                val1=(val1*base + nums[i])%mod1;
                if(i!=0)    pow=(pow*base)%mod1;
                if(nums[i]%p==0){
                    ++count;
                }

            }

            hs.add(val1);
            if(count<=k){
                System.out.println("len: "+len+", end: "+(len-1));
                res++;
            }


            for(int i=len; i<n; i++){
                val1 = (val1-pow*nums[i-len] + mod1)%mod1;
                val1 = (val1*base + nums[i])%mod1;
                if(!hs.contains(val1)){
                    hs.add(val1);
                    if(nums[i]%p==0){
                        ++count;
                    }
                    if(nums[i-len]%p==0)     --count;
                    if(count<=k){
                        System.out.println("len: "+len+", end: "+i);
                        res++;
                    }
                }
            }

        }

        return res;
    }
}