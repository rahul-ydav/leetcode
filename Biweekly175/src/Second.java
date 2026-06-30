class Second {
    public int minimumK(int[] nums) {

        int n = nums.length;

        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int start = 1;
        int end = (int) Math.ceil(Math.sqrt((long) max * n));

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nonPositive(nums, mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    boolean nonPositive(int[] nums, int k) {

        long count = 0;
        for (int num : nums) {
            count += (num + k - 1L) / k;
            if (count > (long) k * k) {
                return false;
            }
        }

        return count <= (long) k * k;
    }
}
