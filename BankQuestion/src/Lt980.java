class Lt980 {

    int[][] grid;
    public int uniquePathsIII(int[][] grid) {

        this.grid = grid;
        int x = 0;
        int y = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1){
                    x = i;
                    y = j;
                    break;
                }
            }
        }


        int res = finder(x, y);
        return res;
    }

    int finder(int x, int y){
        //base condition;
        if(grid[x][y]==2){
            return 1;
        }
        grid[x][y] = -1;

        int ans = 0;
        if(x-1>=0 && grid[x-1][y]==0){
            ans += finder(x-1, y);
        }
        if(x+1<grid.length && grid[x+1][y]==0){
            ans += finder(x+1, y);
        }
        if(y-1>=0 && grid[x][y-1]==0){
            ans += finder(x, y-1);
        }
        if(y+1<grid[0].length && grid[x][y+1]==0){
            ans += finder(x, y+1);
        }

        grid[x][y] = 0;
        return ans;
    }
}