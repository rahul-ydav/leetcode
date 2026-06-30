import java.util.HashMap;

class Third {

    HashMap<Integer, Long>[][] hm;
    int[] tar;
    int[] nums;
    int mod = 1_000_000_007;
    public int alternatingXOR(int[] nums, int target1, int target2) {

        this.nums = nums;
        tar = new int[2];
        tar[0] = target1;
        tar[1] = target2;

        hm = new HashMap[nums.length][2];

        int res = (int)finder(0, 0, 0);
        return res;
    }


    long finder(int i, int t, int xor){


        if(i==nums.length-1){
            xor = xor^nums[i];
            if(xor==tar[t]) return 1;
            return 0;
        }

        if(hm[i][t].containsKey(xor))   return hm[i][t].get(xor);

        long res = 0;

        if(xor==tar[t]){
            res = finder(i+1, (t+1)%2, 0) + finder(i+1, t, (xor^nums[i]));
        }
        else{
            res = finder(i+1, t, (xor^nums[i]));
        }

        res = res%mod;

        hm[i][t].put(xor, res);

        return res;
    }
}