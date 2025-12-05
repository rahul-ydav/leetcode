public class First {
    public boolean checkEqualPartitions(int[] nums, long target) {

        return finder(nums, target, 0, 1, 1);

    }

    boolean finder(int[] nums, long target, int idx, long prod1, long prod2){

        if(idx==nums.length){
            if(prod1 == target && prod2==target)    return true;
            return false;
        }

        return finder(nums, target, idx+1, prod1*nums[idx], prod2) ||  finder(nums, target, idx+1, prod1, prod2*nums[idx]);

    }
}