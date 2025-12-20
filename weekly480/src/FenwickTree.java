public class FenwickTree {

    int nodes;
    int[] fn;

    FenwickTree(int[] nums){
        nodes = nums.length;
        fn = new int[nodes];

        for(int i=0; i<nums.length; i++){
            diffAdder(i+1, nums[i]);

        }
    }

    private int lsbFinder(int idx){
        int lsb = 1;
        while(lsb<idx){
            if((lsb&idx)==lsb){
                break;
            }
            lsb = lsb<<1;
        }
        return lsb;
    }

    private int lsbFinder2(int idx){
        return idx & -idx;
//        return Integer.lowestOneBit(idx);
    }

    void diffAdder(int idx, int val){

        int lsb = lsbFinder(idx);

        while(idx<nodes){
            fn[idx] +=val;
            idx = idx+lsb;
            lsb = lsb<<1;
        }
    }

    void update(int idx, int val){
        int diff = val - fn[idx];
        diffAdder(idx, diff);
    }

    int finder(int idx){
        int x = 1;
        int res = 0;
        while(idx>0){
            if((idx & x)==x){
                res += fn[idx];
                idx = idx ^ x;
            }
            x = x<<1;
        }

        return res;
    }
}
