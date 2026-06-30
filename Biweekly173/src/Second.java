import java.util.HashMap;

class Second {
    int[] nums;
    int n;
    int k;
    // HashMap<Integer, Integer> hm = new HashMap<>();
    public int minLength(int[] nums, int k) {
        this.nums = nums;
        this.k = k;
        n = nums.length;
        // int sum = 0;
        // for(int i=0; i<n; i++){
        //     sum += nums[i];
        //     hm.put(nums[i], hm.getOrDefault(nums[i], 0)+1);
        // }

        int lo = 1;
        int hi = n-1;

        while(lo<hi){
            int mid = (lo + hi)/2;

            if(isValid(mid)){
                hi = mid;
            }
            else{
                lo = mid+1;
            }
        }

        return hi;
    }

    boolean isValid(int len){
        int sum = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<len; i++){
            if(!hm.containsKey(nums[i])){
                sum += nums[i];
                hm.put(nums[i], 1);
            }
            else{
                hm.put(nums[i], hm.get(nums[i])+1);
            }
            if(sum>=k) return true;
        }

        for(int i=len; i<n; i++){
            if(hm.get(nums[i-len])==1){
                hm.remove(nums[i-len]);
                sum-=nums[i-len];
            }
            else{
                hm.put(nums[i-len], hm.get(nums[i-len])-1);
            }

            if(!hm.containsKey(nums[i])){
                sum+=nums[i];
                hm.put(nums[i], 1);
            }
            else{
                hm.put(nums[i], hm.get(nums[i])+1);
            }

            if(sum>=k) return true;
        }

        return false;
    }
}