import java.util.*;
import java.util.stream.Collectors;

class Lt47 {

    List<List<Integer>> result;
    // HashSet<String> hs;
    public List<List<Integer>> permuteUnique(int[] nums) {
        result = new ArrayList<>();
        // hs = new HashSet<>();
        findPermutes(nums, 0);
        return result;
    }

    void findPermutes(int[] nums, int pos){

        if(pos==nums.length-1){
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));

            return;
        }

        HashSet<Integer> hs = new HashSet<>();

        for(int i=pos; i<nums.length; i++){
            if(!hs.contains(nums[pos])){
                findPermutes(nums, pos+1);
                hs.add(nums[pos]);
            }
            shifter(nums, pos, 1);
        }
    }

    void shifter(int[] nums, int pos, int shift){
        int first = nums[pos];
        for(int i=pos; i<nums.length-1; i++){
            nums[i] = nums[i+1];
        }
        nums[nums.length-1] = first;
    }


}