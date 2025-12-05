import java.util.HashSet;

public class Third {

    HashSet<Integer> primes = new HashSet<>();
    int[][] memo;

    int range = 100000;

    void sieve(){
        boolean[] isPrime = new boolean[range];
        for (int i = 0; i < range; i++) {
            isPrime[i] = true;
        }

        isPrime[0] = false;
        isPrime[1] = false;

        for (int p = 2; p * p < range; p++) {
            if (isPrime[p]) {
                for (int multiple = p * p; multiple < range; multiple += p) {
                    isPrime[multiple] = false;
                }
            }
        }


        for (int i = 2; i < range; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
    }
    public int minJumps(int[] nums) {
        memo = new int[nums.length][nums.length];
        sieve();

        return finder(nums, 0, 0, new boolean[nums.length]);
    }

    private int finder(int[] nums, int idx, int steps, boolean[] visited){
        if(idx==nums.length-1){
            return steps;
        }

        if(memo[idx][steps]>0){
            return memo[idx][steps];
        }
        visited[idx] = true;
        int res3 = Integer.MAX_VALUE;
        if(idx>0 && !visited[idx-1])  res3 = Math.min(res3, finder(nums, idx-1, steps+1, visited));
        if(idx<nums.length-1 && !visited[idx+1])  res3 = Math.min(res3, finder(nums, idx+1, steps+1, visited));
        if(primes.contains(nums[idx])){
            for(int i=idx+1; i<nums.length; i++){
                if(nums[i]%nums[idx]==0 && !visited[i]){
                    res3 = Math.min(res3, finder(nums, i, steps+1, visited));
                }
            }
        }

        visited[idx] = false;
        memo[idx][steps] = res3;
        return res3;
    }
}