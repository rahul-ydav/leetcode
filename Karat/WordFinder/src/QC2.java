public class QC2 {
    public static void main(String[] args) {
        char[][] grid1 = {
                {'b', 'b', 'b', 'a', 'l', 'l', 'o', 'o'},
                {'b', 'a', 'c', 'c', 'e', 's', 'c', 'n'},
                {'a', 'l', 't', 'e', 'w', 'c', 'e', 'w'},
                {'a', 'l', 'o', 's', 's', 'e', 'c', 'c'},
                {'w', 'o', 'o', 'w', 'a', 'c', 'a', 'w'},
                {'i', 'b', 'w', 'o', 'w', 'w', 'o', 'w'},
        };
        String word1_1 = "access";
        String word1_2 = "balloon";
        String word1_3 = "wow";
        String word1_4 = "sec";
        String word1_5 = "bbaal";

        char[][] grid2 = {
                {'a'},
        };
        String word2_1 = "a";

        char[][] grid3 = {
                {'c', 'a'},
                {'t', 't'},
                {'h', 'a'},
                {'a', 'c'},
                {'t', 'g'},
        };
        String word3_1 = "cat";
        String word3_2 = "hat";

        char[][] grid4 = {
                {'c', 'c', 'x', 't', 'i', 'b'},
                {'c', 'a', 't', 'n', 'i', 'i'},
                {'a', 'x', 'n', 'x', 'p', 't'},
                {'t', 'x', 'i', 'x', 't', 't'},
        };
        String word4_1 = "catnip";

        int[][] res1 = gridSearch(grid1, word1_1);
        for (int[] ints : res1) {
            System.out.print("("+ints[0] + " " + ints[1]+"), ");
        }
        System.out.println();
        int[][] res2 = gridSearch(grid1, word1_2);
        for (int[] ints : res2) {
            System.out.print("("+ints[0] + " " + ints[1]+"), ");
        }
        System.out.println();
        int[][] res3 = gridSearch(grid1, word1_3);
        for (int[] ints : res3) {
            System.out.print("("+ints[0] + " " + ints[1]+"), ");
        }
        System.out.println();
        int[][] res4 = gridSearch(grid1, word1_4);
        for (int[] ints : res4) {
            System.out.print("("+ints[0] + " " + ints[1]+"), ");
        }
        System.out.println();
        int[][] res5 = gridSearch(grid1, word1_5);
        for (int[] ints : res5) {
            System.out.print("("+ints[0] + " " + ints[1]+"), ");
        }
        System.out.println();
        int[][] res6 = gridSearch(grid2, word2_1);
        for (int[] ints : res6) {
            System.out.print("("+ints[0] + " " + ints[1]+"), ");
        }
        System.out.println();
        int[][] res7 = gridSearch(grid3, word3_1);
        for (int[] ints : res7) {
            System.out.print("("+ints[0] + " " + ints[1]+"), ");
        }
        System.out.println();
        int[][] res8 = gridSearch(grid3, word3_2);
        for (int[] ints : res8) {
            System.out.print("("+ints[0] + " " + ints[1]+"), ");
        }
        System.out.println();
        int[][] res9 = gridSearch(grid4, word4_1);
        for (int[] ints : res9) {
            System.out.print("("+ints[0] + " " + ints[1]+"), ");
        }
        System.out.println();
    }

    public static int[][] gridSearch(char[][] grid, String word){
        int w = word.length();
        int[][] res = new int[w][2];
        Boolean[][][] visited = new Boolean[grid.length][grid[0].length][w];

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==word.charAt(0)){
                    if(dfs(grid, word, visited, i, j, 0, res)){
                        return res;
                    }
                }
            }
        }
        return res;
    }

    static boolean dfs(char[][] grid, String word, Boolean[][][] visited, int x, int y, int idx, int[][] path){

        if (visited[x][y][idx] != null) {
            return visited[x][y][idx];
        }
        path[idx][0] = x;
        path[idx][1] = y;

        if(idx==word.length()-1){
            return visited[x][y][idx] = true;
        }
        if(x+1<grid.length && grid[x+1][y]==word.charAt(idx+1)){
            if(dfs(grid, word, visited, x+1, y, idx+1, path)){
                return visited[x][y][idx] = true;
            }
        }
        if(y+1<grid[0].length && grid[x][y+1]==word.charAt(idx+1)){
            if(dfs(grid, word, visited, x, y+1, idx+1, path)){
                return visited[x][y][idx] = true;
            }
        }

        return visited[x][y][idx] = false;
    }
}