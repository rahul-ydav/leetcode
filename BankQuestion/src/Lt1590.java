import java.util.HashMap;

public class Lt1590 {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int[] pfm = new int[n+1];
        HashMap<Integer, Integer> hm = new HashMap<>();

        int sum = nums[0];
        pfm[0] = nums[0]%p;
        for(int i=1; i<n; i++){
            pfm[i] = (pfm[i-1] + nums[i]%p)%p;
            sum +=nums[i];
        }
        System.out.println("sum: "+sum);
        if(pfm[n-1]==0){
            return 0;
        }

        hm.put(p-pfm[n-1], -1);

        int res = n;

        for(int i=0; i<n-1; i++){
            int remainingpfm = (pfm[n-1] - pfm[i] +p)%p;

            if(hm.containsKey(p-remainingpfm)){
                res = Math.min(res, i-hm.get(p-remainingpfm));
            }
            hm.put(pfm[i], i);
        }

        if(res==n)  res = -1;
        return res;
    }
}
