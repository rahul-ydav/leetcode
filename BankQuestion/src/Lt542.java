class Lt542 {
    int n;
    int m;
    public int[][] updateMatrix(int[][] mat) {

        n = mat.length;
        m = mat[0].length;

        int[][] res = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j]!=0 && res[i][j]==0){
                    dfs(mat, res, i, j);
                }
            }
        }

        return res;
    }

    void dfs(int[][] mat, int[][] res, int x, int y){

        if(mat[x][y]==0)    return;
        res[x][y] = -1;
        int ans = Integer.MAX_VALUE;
        if(x+1<n && res[x+1][y]>=0){
            if(mat[x+1][y]==1 && res[x+1][y]==0){
                dfs(mat, res, x+1, y);
            }
            ans = Math.min(ans, 1 + res[x+1][y]);
        }
        if(x-1>=0 && res[x-1][y]>=0){
            if(mat[x-1][y]==1 && res[x-1][y]==0){
                dfs(mat, res, x-1, y);
            }
            ans = Math.min(ans, 1 + res[x-1][y]);
        }
        if(y+1<m && res[x][y+1]>=0){
            if(mat[x][y+1]==1 && res[x][y+1]==0){
                dfs(mat, res, x, y+1);
            }
            ans = Math.min(ans, 1 + res[x][y+1]);
        }
        if(y-1>=0 && res[x][y-1]>=0){
            if(mat[x][y-1]==1 && res[x][y-1]==0){
                dfs(mat, res, x, y-1);
            }
            ans = Math.min(ans, 1 + res[x][y-1]);
        }

        res[x][y] = ans;

        // return ans;
    }
}