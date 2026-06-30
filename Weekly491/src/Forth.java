import java.util.HashMap;

class Forth {
    public long countSubarrays(int[] nums, int k, int m) {

        int n = nums.length;
        long result = 0;

        HashMap<Integer, Integer> freq = new HashMap<>();

        int left = 0;
        int distinct = 0;
        int valid = 0;

        for (int right = 0; right < n; right++) {

            int val = nums[right];
            freq.put(val, freq.getOrDefault(val, 0) + 1);

            if (freq.get(val) == 1) distinct++;
            if (freq.get(val) == m) valid++;

            while (distinct > k) {
                int remove = nums[left++];
                if (freq.get(remove) == m) valid--;
                freq.put(remove, freq.get(remove) - 1);
                if (freq.get(remove) == 0) {
                    freq.remove(remove);
                    distinct--;
                }
            }

            if (distinct == k && valid == k) {
                int tempLeft = left;
                HashMap<Integer, Integer> tempFreq = new HashMap<>(freq);
                int tempValid = valid;

                while (tempValid == k) {
                    result++;

                    int remove = nums[tempLeft++];
                    if (tempFreq.get(remove) == m) tempValid--;
                    tempFreq.put(remove, tempFreq.get(remove) - 1);
                }
            }
        }

        return result;
    }
}