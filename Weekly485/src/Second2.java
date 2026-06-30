import java.util.Arrays;

class Second2 {
    public int maxCapacity(int[] ct, int[] cp, int budget) {
        int n = ct.length;
        int[][] cm = new int[n][2];

        for (int i = 0; i < n; i++) {
            cm[i][0] = ct[i];
            cm[i][1] = cp[i];
        }

        Arrays.sort(cm, (a, b) -> a[0] - b[0]);

        int l = 0, r = n - 1;
        int bestLeft = 0;
        int res = 0;

        while (l < r) {
            if (cm[l][0] + cm[r][0] < budget) {
                bestLeft = Math.max(bestLeft, cm[l][1]);
                res = Math.max(res, bestLeft + cm[r][1]);
                l++;
            } else {
                r--;
            }
        }


        return res;
    }
}
