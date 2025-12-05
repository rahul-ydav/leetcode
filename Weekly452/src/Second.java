import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.function.Function;

public class Second {
    public int[][] minAbsDiff(int[][] grid, int k) {

        TreeSet<Integer> t = new TreeSet<>();

        int n = grid.length;
        int m = grid[0].length;

        int[][] res = new int[n-k+1][m-k+1];

        for(int a=0; a<=n-k; a++){
            for(int b=0; b<=m-k; b++){
                t = new TreeSet<>();
                for(int i=a; i<a+k; i++){
                    for(int j=b; j<b+k; j++){
                        t.add(grid[i][j]);
                    }
                }
                int minDiff = Integer.MAX_VALUE;

                Integer previous = null;
                Iterator<Integer> iterator = t.iterator();
                while (iterator.hasNext()) {
                    Integer current = iterator.next();
                    if (previous != null) {
                        minDiff = Math.min(minDiff, Math.abs(current-previous));
                    }
                    previous = current;
                }
                res[a][b] = minDiff;
            }
        }

        return res;
    }
}
