class Forth {
    public long numGoodSubarrays(int[] nums, int k) {

        int[] rems = new int[k];
        int sum = 0;
        long res = 0;

        for(int num : nums){
            sum = sum + num;
            int rem = sum%k;

            if(rem==0){
                res += (long)rems[rem]+1;
            }
            else{
                res += (long)rems[rem];
            }
            rems[rem]++;
        }

        return res;
    }
}