import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Third2 {


    public int minMoves(String[] classroom, int energy) {
        Grid4Dir g = new Grid4Dir(classroom, energy);

        g.bfs();
        int res = g.minMoves;
        if(res == Integer.MAX_VALUE)    res = -1;
        return res;
    }
    public class Grid4Dir {

        char[][] grid;
        int n;
        int m;
        int totalL = 0;
        int[] dir = {-1, 1};
        int[] start = new int[2];
        int startE;
        int minMoves = Integer.MAX_VALUE;
        int[][][] visited;

        HashMap<String, Integer> rowCol2BitIdx = new HashMap<>();



        Grid4Dir(String[] grid, int e){
            n = grid.length;
            m = grid[0].length();
            this.grid = new char[n][m];
            startE = e;

            visited = new int[n+1][m+1][51];

            for(int i=0; i<n; i++) {
                for (int j = 0; j < m; j++) {
                    this.grid[i][j] = grid[i].charAt(j);
                    if(grid[i].charAt(j) == 'S'){
                        start[0] = i;
                        start[1] = j;
                    }
                    else if(grid[i].charAt(j)== 'L'){
                        rowCol2BitIdx.put(i+"_"+j, totalL);
                        totalL++;
                    }
                }
            }
        }

        void bfs(){

            Queue<Pair> q = new LinkedList<>();

            q.add(new Pair(start[0], start[1], startE+1, -1, 0));

            int allCollected = (1<<totalL)-1;

            while(!q.isEmpty()){
                Pair currNode = q.remove();
                int x = currNode.a;
                int y = currNode.b;
                int e = currNode.parentE-1;
                int moves = currNode.parentMoves+1;
                int mask = currNode.parentMask;

                visited[x][y][e] = 1;

                Predicate<Character> isR = (ch) -> ch.equals('R');
                if(isR.test(grid[x][y])){
                    e = startE;
                    visited[x][y][e] = 0;
                }
                else if(grid[x][y] == 'L'){
                    int idx = rowCol2BitIdx.get(x+"_"+y);
                    if((mask & (1<<idx))==0){
                        mask = (mask | (1<<idx));
                    }
                }

                if(mask==allCollected){
                    minMoves = Math.min(minMoves, moves);
                }

                if(e>0) {
                    for (int i = 0; i < dir.length; i++) {
                        if (validNode(x, y + dir[i], e)) {
                            q.add(new Pair(x, y + dir[i], e, moves, mask));
                        }
                        if (validNode(x + dir[i], y, e)) {
                            q.add(new Pair(x + dir[i], y, e, moves, mask));
                        }
                    }
                }
            }

        }
        boolean validNode(int x1, int y1, int e) {
            return (x1 >= 0 && x1 < grid.length && y1 >= 0 && y1 < grid[0].length && grid[x1][y1] != 'X' && visited[x1][y1][e-1] == 0);
        }

    }

    class Pair{
        int a;
        int b;
        int parentE;
        int parentMoves;
        int parentMask;
        Pair(int a, int b, int e, int m, int mask){
            this.a = a;
            this.b = b;
            parentE = e;
            parentMoves = m;
            parentMask = mask;
        }
    }
}
