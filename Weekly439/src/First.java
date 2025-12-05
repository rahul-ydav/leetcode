public class First {
    public int largestInteger(int[] nums, int k) {
        int len = nums.length;
        if(k==len){
            int maxEle = nums[0];
            for(int i=0; i<len; i++){
                maxEle = Math.max(maxEle, nums[i]);
            }
            return maxEle;
        }
        if(k==1){
            int maxEle = -1;
            for(int i=0; i<len; i++){
                if(nums[i]>maxEle){
                    boolean isLarg = true;
                    for(int j=0; j<len; j++){
                        if(nums[i]==nums[j]){
                            isLarg = false;
                            break;
                        }
                    }
                    if(isLarg) maxEle = nums[i];
                }
            }
            return maxEle;
        }
        boolean lastFound = false;
        boolean firstFound = false;
        for(int i=0; i<len; i++){
            if(nums[i]==nums[len-1]){
                lastFound = true;
            }
            if(nums[i]==nums[0]){
                firstFound = true;
            }
        }

        if(lastFound && firstFound) return -1;
        else if(firstFound) return nums[len-1];
        else if(lastFound) return nums[0];
        return Math.max(nums[0], nums[nums.length-1]);
    }
}
