import java.util.Arrays;

public class Third {
    final int mod = 1000000007;
    long[] factorials;

    long factorial(int n) {
        if(factorials[n]>0)  return factorials[n];
        if (n <= 1) {
            return 1;
        }
        factorials[n] = (n * (factorial(n - 1)%mod))%mod;
        return factorials[n];
    }
    public int minMaxSums(int[] nums, int k) {
        long res = 0;
        factorials = new long[nums.length+1];
        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++){
            res = res + (2*nums[i]);

            // when a[i] is max;
            int maxLenPossible = Math.min(k-1, i);
            int minEles = i;
            for(int j=1; j<=maxLenPossible; j++){
                long f1 = factorial(minEles)%mod;
                long f2 = factorial(minEles-j)%mod;
                long f3 = factorial(j)%mod;
                long ans = (f1/(f2*f3)%mod)%mod;
                res = res + (ans*nums[i])%mod;
            }

            // when a[i] is min;
            int maxLenPossible2 = Math.min(k-1, nums.length-i-1);
            int maxEles = nums.length-i-1;
            for(int j=1; j<=maxLenPossible2; j++){
                long f1 = factorial(maxEles)%mod;
                long f2 = factorial(maxEles-j)%mod;
                long f3 = factorial(j)%mod;
                long ans = (f1/(f2*f3)%mod)%mod;
                res = res + (ans*nums[i])%mod;
            }

        }
        return (int) res;
    }
}
