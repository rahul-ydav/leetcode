import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Feb13 {
    public int minOperations(int[] nums, int k) {

        PriorityQueue<Long> q = new PriorityQueue<>(Arrays.stream(nums)
                .mapToLong(i -> (long) i)
                .boxed()
                .collect(Collectors.toList())
        );

        int ops = 0;
        while(q.peek()<k){
            long x = q.poll();
            long y = q.poll();
            q.add(2*x+y);
            ops++;
        }
        return ops;
    }
}
