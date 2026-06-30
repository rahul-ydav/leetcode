import java.util.*;

class Forth {

    Map<String, Integer> memo = new HashMap<>();

    public int countSequences(int[] nums, long k) {
        return dfs(nums, k, 0, 1L, 1L);
    }

    int dfs(int[] nums, long k, int i, long num, long den) {

        long g = gcd(Math.abs(num), Math.abs(den));
        num /= g;
        den /= g;

        String key = i + "|" + num + "|" + den;
        if (memo.containsKey(key)) return memo.get(key);

        if (i == nums.length) {
            return (den == 1 && num == k) ? 1 : 0;
        }

        int count = 0;
        count += dfs(nums, k, i + 1, num, den);
        count += dfs(nums, k, i + 1, num * nums[i], den);
        count += dfs(nums, k, i + 1, num, den * nums[i]);

        memo.put(key, count);
        return count;
    }

    long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}