class Third {
    public int minCost(int[][] grid) {


        int n = grid.length;
        int m = grid[0].length;

        int[][] xr = new int[n][m];
        xr[n-1][m-1] = grid[n-1][m-1];

        for(int i=n-1; i>=0; i--){
            for(int j=m-1; j>=0; j--){
                if(i+1==n && j+1==m){}
                else if(i+1==n){
                    xr[i][j] = grid[i][j]^xr[i][j+1];
                }
                else if(j+1==m){
                    xr[i][j] = grid[i][j]^xr[i+1][j];
                }
                else if(i+1<n && j+1<m){
                    int xor1 = grid[i][j]^xr[i+1][j];
                    int xor2 = grid[i][j]^xr[i][j+1];
                    xr[i][j] = Math.min(xor1, xor2);
                }
            }
        }

        return xr[0][0];
    }
}