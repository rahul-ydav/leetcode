import java.util.*;

public class Third {
    int m;
    int n;
    int k;
    public String[] createGrid(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int[][] grid = new int[m][n];


    }

    int finder(int i, int j, int[][] dp, int[][] grid) {
        if (i >= m || j >= n)
            return 0;
//
//        if (grid[i][j] == 1)
//            return 0;

        if (i == m - 1 && j == n - 1)
            return 1;

        if (dp[i][j] != -1)
            return dp[i][j];

        int down = finder(i + 1, j, dp, grid);
        int right = finder(i, j + 1, dp, grid);


        dp[i][j] = down + right;
    }
}
