public class Third {
    public long maxTotal(int[] nums, String s) {

        int n = nums.length;
        long res = 0L;


        int i = 0;

        while (i < n) {
            if (s.charAt(i) == '1') {
                res += nums[i];
                i++;
            } else {
                long sum = 0L;
                int first = nums[i];
                i++;
                while (i < n && s.charAt(i) == '1') {
                    sum += nums[i];
                    i++;
                }
//                int idx = (i != n) ? i : i - 1;


                if (first > nums[i-1]) {
                    sum -= nums[i-1];
                    sum += first;
                }
                // i--;

                res += sum;
                System.out.println("res: " + res + ", i: " + i);
            }
        }
        return res;
    }
}
