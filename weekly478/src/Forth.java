import java.util.HashMap;
import java.util.Map;

public class Forth {
    public long[] minOperations(int[] nums, int k, int[][] queries) {

        int n = nums.length;
        long[] res = new long[queries.length];
        int x=0;
        for(int[] q : queries){
            int l = q[0];
            int r = q[1];

            // HashMap<Integer, Integer> hm = new HashMap<>();
            // for(int i=l; i<=r; i++){
            //     hm.put(nums[i], hm.getOrDefault(nums[i], 0)+1);
            // }
            // int maxrep = nums[l];
            // int maxrepCnt = 0;
            // for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            //     if(entry.getValue()>maxrepCnt){
            //         maxrep = entry.getKey();
            //         maxrepCnt = entry.getValue();
            //     }
            //     System.out.println(entry.getKey() + " = " + entry.getValue());
            // }


            double mean =0;
            for(int i=l; i<=r; i++){
                mean+=nums[i];
            }
            mean = mean/(r-l+1);
            int maxrep = 0;
            double diff = n;
            for(int i=l; i<=r; i++){
                if(Math.abs((double)nums[i] - mean)<diff){
                    diff = Math.abs(nums[i] - mean);
                    maxrep = nums[i];
                }
            }
            System.out.println("maxrep: "+maxrep);

            int cnt =0;
            for(int i=l; i<=r; i++){
                int val = Math.abs(maxrep - nums[l]);

                if(val%k!=0){
                    res[x] = -1;
                    break;
                }
                cnt+=val/k;

            }
            if(res[x]==0){
                res[x] = cnt;
            }
            x++;
        }
        return res;
    }

}