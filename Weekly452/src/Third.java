import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Third {


    public int minMoves(String[] classroom, int energy) {
        Grid4Dir g = new Grid4Dir(classroom, energy);

        g.dfs(g.start[0], g.start[1], energy, -1);
        return g.minMoves;
    }
    public class Grid4Dir {

        char[][] grid;
        int n;
        int m;
        int lcount = 0;
        int[] dir = {-1, 1};
        int[] start = new int[2];
        int startE;
        int minMoves = Integer.MAX_VALUE;
        int[][] visited;

        Grid4Dir(String[] grid, int e){
            n = grid.length;
            m = grid[0].length();
            this.grid = new char[n][m];
            startE = e;

            visited = new int[n+1][m+1];

            for(int i=0; i<n; i++) {
                for (int j = 0; j < m; j++) {
                    this.grid[i][j] = grid[i].charAt(j);
                    if(grid[i].charAt(j) == 'S'){
                        start[0] = i;
                        start[1] = j;
                    }
                    else if(grid[i].charAt(j)== 'L'){
                        lcount++;
                    }
                }
            }
        }


        void dfs(int x, int y, int e, int moves){
            moves++;
            visited[x][y] = 1;

            Predicate<Character> isR = (ch) -> ch.equals('R');
            if(isR.test(grid[x][y])){
                e = startE;
                visited[x][y] = 0;
            }
            else if(grid[x][y] == 'L'){
                lcount--;
                grid[x][y] = 'l';
            }

            if(lcount==0){
                minMoves = Math.min(minMoves, moves);
                return;
            }

            if(e==0){
                visited[x][y] = 0;
                return;
            }

            BiPredicate<Integer, Integer> validNode = (x1, y1) -> (x1>=0 && x1<grid.length && y1>=0 && y1<grid[0].length && grid[x1][y1]!='X' && visited[x1][y1] == 0);


            for(int i=0; i<dir.length; i++){
                if(validNode.test(x, y+dir[i])){
                    dfs(x, y+dir[i], e-1, moves);
                }
                if(validNode.test(x+dir[i], y)){
                    dfs(x+dir[i], y, e-1, moves);
                }
            }
            visited[x][y] = 0;
            if(grid[x][y]=='l'){
                grid[x][y] = 'L';
            }
        }

//        boolean validNode(int x, int y){
//            return x>=0 && x<grid.length && y>=0 && y<grid[0].length && grid[x][y]!='X' && visited[x][y] == 0;
//        }

    }
}
