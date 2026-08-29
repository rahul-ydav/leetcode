import java.util.*;

public class QC3 {
    public static void main(String[] args) {
        char[][] grid1 = {
                {'b', 'a', 'b'},
                {'y', 't', 'a'},
                {'x', 'x', 't'},
        };
        String[] words1_1 = {"bat", "by"};

        char[][] grid2 = {
                {'A', 'B', 'A', 'B'},
                {'B', 'A', 'B', 'A'},
                {'A', 'B', 'Y', 'B'},
                {'B', 'Y', 'A', 'A'},
                {'A', 'B', 'B', 'A'},
        };
        String[] words2_1 = {"ABABY", "ABY", "AAA", "ABAB", "BABB"};
        String[] words2_2 = {"ABABA", "ABA", "BAB", "BABA", "ABYB"};

        char[][] grid3 = {
                {'X', 'A', 'B', 'C'},
                {'A', 'B', 'X', 'X'},
                {'X', 'C', 'X', 'X'},
        };
        String[] words3_1 = {"AB", "ABC"};

        char[][] grid4 = {
                {'B', 'A', 'B', 'A'},
                {'X', 'B', 'X', 'X'},
        };
        String[] words4_1 = {"AB", "BA"};

        int[][][] res1 = gridSearch(grid1, words1_1);
        for (int[][] ints : res1) {
            for(int[] ints2 : ints) {
                System.out.print("("+ints2[0] + " " + ints2[1]+"), ");
            }
            System.out.println();
        }
        System.out.println();

        int[][][] res2 = gridSearch(grid2, words2_1);
        for (int[][] ints : res2) {
            for(int[] ints2 : ints) {
                System.out.print("("+ints2[0] + " " + ints2[1]+"), ");
            }
            System.out.println();
        }
        System.out.println();

        int[][][] res3 = gridSearch(grid2, words2_2);
        for (int[][] ints : res3) {
            for(int[] ints2 : ints) {
                System.out.print("("+ints2[0] + " " + ints2[1]+"), ");
            }
            System.out.println();
        }
        System.out.println();

        int[][][] res4 = gridSearch(grid3, words3_1);
        for (int[][] ints : res4) {
            for(int[] ints2 : ints) {
                System.out.print("("+ints2[0] + " " + ints2[1]+"), ");
            }
            System.out.println();
        }
        System.out.println();

        int[][][] res5 = gridSearch(grid4, words4_1);
        for (int[][] ints : res5) {
            for(int[] ints2 : ints) {
                System.out.print("("+ints2[0] + " " + ints2[1]+"), ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int[][][] gridSearch(char[][] grid, String[] words){
        int r = grid.length;
        int c = grid[0].length;
        int[][][] res = new int[words.length][][];
        boolean[] found = new boolean[words.length];

        boolean[][]  allVis = new boolean[r][c];
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                for(int k=0; k<words.length; k++){
                    if(found[k])    continue;
                    String word = words[k];
                    int w = word.length();
                    int[][] curr = new int[w][2];
                    Boolean[][][] visited = new Boolean[r][c][w];
                    if(!allVis[i][j] && grid[i][j]==word.charAt(0)){
                        if(dfs(grid, word, allVis, visited, i, j, 0, curr)){
                            allVis[i][j] = true;
                            found[k] = true;
                            res[k] =  curr;
                        }
                    }
                }
            }
        }
        return res;
    }

    static boolean dfs(char[][] grid, String word, boolean[][] allVis, Boolean[][][] visited, int x, int y, int idx, int[][] path){

        if (visited[x][y][idx] != null) {
            allVis[x][y] = true;
            return visited[x][y][idx];
        }
        path[idx][0] = x;
        path[idx][1] = y;

        if(idx==word.length()-1){
            return visited[x][y][idx] = true;
        }
        if(x+1<grid.length && !allVis[x+1][y] &&  grid[x+1][y]==word.charAt(idx+1)){
            if(dfs(grid, word, allVis, visited, x+1, y, idx+1, path)){
                allVis[x][y] = true;
                return visited[x][y][idx] = true;
            }
        }
        if(y+1<grid[0].length && !allVis[x][y+1] && grid[x][y+1]==word.charAt(idx+1)){
            if(dfs(grid, word, allVis, visited, x, y+1, idx+1, path)){
                allVis[x][y] = true;
                return visited[x][y][idx] = true;
            }
        }

        return visited[x][y][idx] = false;
    }
}