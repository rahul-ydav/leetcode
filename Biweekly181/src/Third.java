import java.util.ArrayList;
import java.util.List;

public class Third {
    public List<List<Integer>> generateSubsets(int[] nums, int n) {


        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        List<Integer> sum = new ArrayList<>();
        sum.add(0);
        List<List<Integer>> res = new ArrayList<>();

        for (int num =0; num<n; num++) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                List<Integer> subset = new ArrayList<>(result.get(i));
                subset.add(num);
                result.add(subset);
                int s = sum.get(i) +nums[num];
                sum.add(s);
                if(s%2==0){
                    res.add(subset);
                }
            }
        }
        return res;
    }

    public int evenSumSubgraphs(int[] nums, int[][] edges) {

//        int n = nums.length;

        List<List<Integer>> subs = generateSubsets(nums, nums.length);

        for(List<Integer> sub : subs){
            System.out.println(sub.toString());
        }
        return 0;

    }
}