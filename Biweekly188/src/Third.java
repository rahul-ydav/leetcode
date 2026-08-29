import java.util.*;
class Third {
    public long minimumInitialStrength(int[] monsters, int[][] boosts) {

        int n = monsters.length;
        long[] diff = new long[n + 1];

        for (int[] b : boosts) {
            diff[b[0]] += b[2];
            if (b[1] + 1 < n)
                diff[b[1] + 1] -= b[2];
        }

        long[] bonus = new long[n];
        long x = 0;
        for (int i = 0; i < n; i++) {
            x += diff[i];
            bonus[i] = x;
        }

        long lo = 0;
        long hi = 0;

        for(int v : monsters) {
            hi += v;
        }

        while(lo < hi) {
            long mid = lo + (hi - lo) / 2;

            if(can(mid, monsters, bonus)) hi = mid;
            else lo = mid + 1;
        }

        return lo;
    }

    private boolean can(long strength, int[] monsters, long[] bonus) {
        for(int i = 0; i < monsters.length; i++) {
            if(strength + bonus[i] < monsters[i]){
                return false;
            }
            strength -= monsters[i];

            if(strength < 0) strength = 0;
        }

        return true;
    }

}