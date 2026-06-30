import java.util.ArrayDeque;
import java.util.Deque;

public class Lt1696 {
//    public int maxResult(int[] nums, int k) {
//
//        int n = nums.length;
//
//        int res = 0;
//
//        int i=0;
//        while(i<n){
//            res+=nums[i];
//            System.out.println("i: "+i);
//            int j=i+1;
//            int smNeg = -1;
//            int nextItr = -1;
//            while(j<=i+k && j<n){
//                if(nums[j]>0){
//                    nextItr = j;
//                    break;
//                }
//                if(smNeg==-1 || nums[j]>nums[smNeg]){
//                    smNeg = j;
//                }
//                j++;
//            }
//
//            if(nextItr==-1){
//                i=smNeg;
//            }
//            else    i = nextItr;
//        }
//
//        return res;
//    }
        public int maxResult(int[] nums, int k) {
            int n = nums.length;
            int[] dp = new int[n];
            dp[0] = nums[0];

            Deque<Integer> deque = new ArrayDeque<>();
            deque.offer(0); // store indices

            for (int i = 1; i < n; i++) {

                // 1. Remove indices out of the window
                while (!deque.isEmpty() && deque.peekFirst() < i - k) {
                    deque.pollFirst();
                }

                // 2. Best previous score is at front
                dp[i] = dp[deque.peekFirst()] + nums[i];

                // 3. Maintain decreasing order of dp values
                while (!deque.isEmpty() && dp[deque.peekLast()] <= dp[i]) {
                    deque.pollLast();
                }

                // 4. Add current index
                deque.offerLast(i);
            }

            return dp[n - 1];
        }
    }
