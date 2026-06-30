import java.util.ArrayList;
import java.util.List;

class Lt3886 {
    public int sortableIntegers(int[] nums) {

        int n = nums.length;

        List<Integer> divs= new ArrayList<>();
        for(int i=1; i<=n; i++){
            if(n%i==0){
                divs.add(i);
            }
        }

        int res = 0;

        for(int len : divs){

            int start = 0;
            int prev = -1;
            boolean goodM = true;
            while(start<n){
                int mx = 0;
                boolean reset=false;
                boolean good = true;
                for(int i=start; i<start+len; i++){
                    mx = Math.max(mx, nums[i]);
                    if(i!=start){
                        if(!reset){
                            if(nums[i]<nums[i-1]){
                                if(nums[i]>nums[start]){
                                    good = false;
                                    break;
                                }
                                reset = true;
                            }
                        }
                        else{
                            if(nums[i]>=nums[i-1] && nums[i]<=nums[start]){
                            }
                            else{
                                good = false;
                                break;
                            }
                        }
                    }
                    if(nums[i]<prev){
                        good = false;
                        break;
                    }
                }
                if(!good){
                    goodM = false;
                    break;
                }
                prev = mx;
                start = start+len;
            }
            if(goodM){
                res+=len;
            }
        }

        return res;
    }
}