import java.util.ArrayList;
import java.util.List;

class Second {
    public int[] rotateElements(int[] nums, int k) {
        int n = nums.length;

        List<Integer> idx = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) idx.add(i);
        }

        int m = idx.size();
        if (m <= 1 || k == 0) return nums;

        k %= m;

        int[] res = nums.clone();

        for (int i = 0; i < m; i++) {
            int from = idx.get(i);
            int to = idx.get((i - k + m) % m);
            res[to] = nums[from];
        }

        return res;
    }
}
