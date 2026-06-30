import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Third {
    public int longestSubsequence(int[] nums) {
        int ans = 0;

        for (int bit = 0; bit < 31; bit++) {
            List<Integer> filtered = new ArrayList<>();

            for (int num : nums) {
                if ((num & (1 << bit)) != 0) {
                    filtered.add(num);
                }
            }

            if (!filtered.isEmpty()) {
                ans = Math.max(ans, lis(filtered));
            }
        }

        return ans;
    }

    private int lis(List<Integer> arr) {
        List<Integer> dp = new ArrayList<>();

        for (int x : arr) {
            int idx = Collections.binarySearch(dp, x);
            if (idx < 0) idx = -(idx + 1);

            if (idx == dp.size()) dp.add(x);
            else dp.set(idx, x);
        }

        return dp.size();
    }
}