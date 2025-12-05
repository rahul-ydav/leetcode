import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class First {
    public int minimumPairRemoval(int[] nums) {

        List<Integer> ar =  new ArrayList<>(Arrays.stream(nums)
                .boxed()
                .toList());


        if(nums.length==1) return 0;

        int res = 0;

        int itr = nums.length-1;
        while(itr>0){
            itr--;
            //checkOrder
            boolean order = true;
            for(int i=1; i<ar.size(); i++){
                if(ar.get(i)<ar.get(i-1)){
                    order = false;
                    break;
                }
            }
            if(order)   break;

            if(ar.size()==1)    break;

            int minIdx=  0;

            for(int i=1; i<ar.size()-1; i++){
                if(ar.get(i)+ar.get(i+1)<ar.get(minIdx)+ar.get(minIdx+1)){
                    minIdx = i;
                }
            }

            int sum = ar.get(minIdx) + ar.get(minIdx+1);
            ar.remove(minIdx+1);
            ar.set(minIdx, sum);
            res++;

        }
        return res;
    }
}
