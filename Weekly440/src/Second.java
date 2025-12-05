import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Second {

    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {

        int n = nums1.length;

        Pair[] pairs = new Pair[n];
        for(int i=0; i<n; i++){
            pairs[i] = new Pair(nums1[i], nums2[i]);
        }

        Arrays.sort(pairs, (x, y)->{
            if(x.a==y.a)    return x.b-y.b;
            return x.a-y.a;
        });


        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long[] res = new long[n];
        res[0] = 0;
        int lastSum = 0;
        int currSum = 0;
        for(int i=1; i<n; i++){
            pq.add(pairs[i].b);

            if(pq.size()>k){
//                if(pairs[i].b>pq.peek()){
                    currSum-=pq.poll();
                    currSum+=pairs[i].b;
//                    pq.add(pairs[i].b);
//                pq.remove();
//                }
            }
            if(pairs[i].a != pairs[i-1].a){
                lastSum = currSum;
            }
            res[i] = lastSum;
        }
        return res;
    }

    class Pair{
        int a;
        int b;
        Pair(int a, int b){
            this.a = a;
            this.b = b;
        }
    }
}
