public class Third  {
    String[] grid;
    int n;
    int m;
    int steps = 0;
    int[] dir = {-1, 1};

    int[] charUsed = new int[26];

    int[][] visited;


    public int minMoves(String[] grid){
        this.grid = grid;
        n = grid.length;
        m = grid[0].length();
        visited = new int[n][m];

        return dfs(0, 0);
    }

    int dfs(int x, int y){
        if(x==n-1 && y==m-1)    return 0 ;

        int steps = 0;

        int jumpSteps = 0;

        if(grid[x].charAt(y)=='.')  steps++;
        else{
            for(int i=n-1; i>=0; i--){
                for(int j=m-1; j>=0; j--){
                    if(grid[i].charAt(j)==grid[x].charAt(y) && charUsed[grid[x].charAt(y)-'A']==0){
                        charUsed[grid[x].charAt(y)-'A'] = 1;
                        jumpSteps = dfs(i, j);
                    }
                }
            }
        }

        int remSteps = Integer.MAX_VALUE;
        for(int i=0; i<dir.length; i++){
            if(validNode(x, y+dir[i]) && visited[x][y+dir[i]]==0){
                visited[x][y+dir[i]] = 1;
                remSteps = Math.min(dfs(x, y+dir[i]), remSteps);
                visited[x][y+dir[i]] = 0;
            }
            if(validNode(x+dir[i], y) && visited[x+dir[i]][y]==0){
                visited[x+dir[i]][y] = 1;
                remSteps = Math.min(dfs(x+dir[i], y), remSteps);
                visited[x+dir[i]][y] = 0;
            }
        }
        return Math.min(remSteps+steps, jumpSteps);
    }

    boolean validNode(int x, int y){
        return x>=0 && x<n && y>=0 && y<m && grid[x].charAt(y)!='#';
    }
}
