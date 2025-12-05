class Third {
    public int maxPathScore(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] memo = new int[n][m][k+1];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i==0 && j==0){
                    if(grid[i][j]!=0){
                        memo[i][j][1] = grid[i][j];
                        // vals[0] = grid[i][j];
                    }
                }
                else if(i==0){
                    if(grid[i][j]==0){
                        for(int x=0; x<=k; x++){
                            memo[i][j][x] = memo[i][j-1][x];
                        }
                    }
                    else{
                        for(int x=1; x<=k; x++){
                            if(memo[i][j-1][x-1]!=0){
                                memo[i][j][x] = memo[i][j-1][x-1]+grid[i][j];
                                System.out.println("first");
                                System.out.println("i: "+i+", j: "+j+", x: "+x+", memo: "+memo[i][j][x]);
                            }
                        }
                    }
                }
                else if(j==0){
                    if(grid[i][j]==0){
                        for(int x=0; x<=k; x++){
                            memo[i][j][x] = memo[i-1][j][x];
                        }
                    }
                    else{
                        for(int x=1; x<=k; x++){
                            if(memo[i-1][j][x-1]!=0){
                                memo[i][j][x] = memo[i-1][j][x-1]+grid[i][j];
                                System.out.println("second");
                                System.out.println("i: "+i+", j: "+j+", x: "+x+", memo: "+memo[i][j][x]);
                            }
                        }
                    }
                }
                else{
                    if(grid[i][j]==0){
                        for(int x=0; x<k; x++){
                            memo[i][j][x] = Math.max(memo[i-1][j][x], memo[i][j-1][x]);
                        }
                    }
                    else{
                        for(int x=1; x<k; x++){
                            if(memo[i-1][j][x-1]!=0 || memo[i][j-1][x-1]!=0){
                                memo[i][j][x] = Math.max(memo[i-1][j][x], memo[i][j-1][x]) + grid[i][j];
                                System.out.println("third");
                                System.out.println("i: "+i+", j: "+j+", x: "+x+", memo: "+memo[i][j][x]);
                            }
                        }
                    }
                }
            }
        }

        int ans = 0;
        for(int x=0; x<=k; x++){
            ans = Math.max(ans, memo[n-1][m-1][x]);
        }
        if(ans==0){
            return -1;
        }
        return ans;
    }
}