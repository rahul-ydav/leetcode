/*
Your students are hiding multiple words in a 2D grid of letters. Return the location of each word as a list of coordinates. Each word may start anywhere in the grid, and consecutive letters can be either immediately below or immediately to the right of the previous letter. Letters cannot be reused across words.

grid1 = [
    ['b', 'a', 'b'],
    ['y', 't', 'a'],
    ['x', 'x', 't'],
]

words1_1 = ["bat", "by"]

find_word_locations(grid1, words1_1) =>
([(0, 0), (1, 0)],
 [(0, 2), (1, 2), (2, 2)])

grid2 =[
    ['A', 'B', 'A', 'B'],
    ['B', 'A', 'B', 'A'],
    ['A', 'B', 'Y', 'B'],
    ['B', 'Y', 'A', 'A'],
    ['A', 'B', 'B', 'A'],
]
words2_1 = ['ABABY', 'ABY', 'AAA', 'ABAB', 'BABB']

([(0, 0), (1, 0), (2, 0), (2, 1), (3, 1)],
 [(1, 1), (1, 2), (2, 2)],
 [(3, 2), (3, 3), (4, 3)],
 [(0, 2), (0, 3), (1, 3), (2, 3)],
 [(3, 0), (4, 0), (4, 1), (4, 2)])

or

([(0, 0), (1, 0), (1, 1), (1, 2), (2, 2)],
 [(2, 0), (2, 1), (3, 1)],
 [(3, 2), (3, 3), (4, 3)],
 [(0, 2), (0, 3), (1, 3), (2, 3)],
 [(3, 0), (4, 0), (4, 1), (4, 2)])

or

([(0, 0), (0, 1), (1, 1), (1, 2), (2, 2)],
 [(2, 0), (2, 1), (3, 1)],
 [(3, 2), (3, 3), (4, 3)],
 [(0, 2), (0, 3), (1, 3), (2, 3)],
 [(3, 0), (4, 0), (4, 1), (4, 2)])

words2_2 = ['ABABA', 'ABA', 'BAB', 'BABA', 'ABYB']

([(0, 0), (1, 0), (2, 0), (3, 0), (4, 0)],
 [(3, 2), (4, 2), (4, 3)],
 [(0, 1), (0, 2), (1, 2)],
 [(0, 3), (1, 3), (2, 3), (3, 3)],
 [(1, 1), (2, 1), (3, 1), (4, 1)])

or

([(0, 0), (1, 0), (2, 0), (3, 0), (4, 0)],
 [(3, 2), (4, 2), (4, 3)],
 [(0, 1), (0, 2), (0, 3)],
 [(1, 2), (1, 3), (2, 3), (3, 3)],
 [(1, 1), (2, 1), (3, 1), (4, 1)])

grid3 = [
    ['X', 'A', 'B', 'C'],
    ['A', 'B', 'X', 'X'],
    ['X', 'C', 'X', 'X']
]

words3_1 = ["AB","ABC"]

([(0, 1), (0, 2)],
 [(1, 0), (1, 1), (2, 1)])

or

([(1,0), (1,1)],
 [(0, 1), (0, 2), (0, 3)])

grid4 = [
    ['B', 'A', 'B', 'A'],
    ['X', 'B', 'X', 'X']
]

words4_1 = ["AB","BA"]

([(0, 1), (1, 1)],
 [(0, 2), (0, 3)])

All Test Cases:
find_word_locations(grid1, words1_1)
find_word_locations(grid2, words2_1)
find_word_locations(grid2, words2_2)
find_word_locations(grid3, words3_1)
find_word_locations(grid4, words4_1)

Complexity analysis variables:

r = number of rows
c = number of columns
w = length of the word
* */

public class QC302 {
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

        int[][][] res1 = multiWordSearch(grid1, words1_1);
        for (int[][] ints : res1) {
            for(int[] ints2 : ints) {
                System.out.print("("+ints2[0] + " " + ints2[1]+"), ");
            }
            System.out.println();
        }
        System.out.println();

        int[][][] res2 = multiWordSearch(grid2, words2_1);
        for (int[][] ints : res2) {
            for(int[] ints2 : ints) {
                System.out.print("("+ints2[0] + " " + ints2[1]+"), ");
            }
            System.out.println();
        }
        System.out.println();

        int[][][] res3 = multiWordSearch(grid2, words2_2);
        for (int[][] ints : res3) {
            for(int[] ints2 : ints) {
                System.out.print("("+ints2[0] + " " + ints2[1]+"), ");
            }
            System.out.println();
        }
        System.out.println();

        int[][][] res4 = multiWordSearch(grid3, words3_1);
        for (int[][] ints : res4) {
            for(int[] ints2 : ints) {
                System.out.print("("+ints2[0] + " " + ints2[1]+"), ");
            }
            System.out.println();
        }
        System.out.println();

        int[][][] res5 = multiWordSearch(grid4, words4_1);
        for (int[][] ints : res5) {
            for(int[] ints2 : ints) {
                System.out.print("("+ints2[0] + " " + ints2[1]+"), ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int[][][] multiWordSearch(char[][] grid, String[] words) {
        int[][][] res = new int[words.length][][];
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        if (solveWord(grid, words, 0, visited, res)) {
            return res;
        }
        return new int[0][][];
    }

    private static boolean solveWord(char[][] grid, String[] words, int wordIdx, boolean[][] visited, int[][][] res) {
        if (wordIdx == words.length) {
            return true;
        }

        String word = words[wordIdx];
        int len = word.length();
        int[][] path = new int[len][2];

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (!visited[r][c] && grid[r][c] == word.charAt(0)) {
                    if (findPath(grid, word, 0, r, c, visited, path, words, wordIdx, res)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean findPath(char[][] grid, String word, int charIdx, int r, int c, boolean[][] visited, int[][] path, String[] words, int wordIdx, int[][][] res) {
        path[charIdx][0] = r;
        path[charIdx][1] = c;
        visited[r][c] = true;

        if (charIdx == word.length() - 1) {
            res[wordIdx] = copyPath(path);
            if (solveWord(grid, words, wordIdx + 1, visited, res)) {
                return true;
            }
            visited[r][c] = false;
            return false;
        }
        if (r + 1 < grid.length && !visited[r + 1][c] && grid[r + 1][c] == word.charAt(charIdx + 1)) {
            if (findPath(grid, word, charIdx + 1, r + 1, c, visited, path, words, wordIdx, res)) {
                return true;
            }
        }

        if (c + 1 < grid[0].length && !visited[r][c + 1] && grid[r][c + 1] == word.charAt(charIdx + 1)) {
            if (findPath(grid, word, charIdx + 1, r, c + 1, visited, path, words, wordIdx, res)) {
                return true;
            }
        }
        visited[r][c] = false;
        return false;
    }

    private static int[][] copyPath(int[][] path) {
        int[][] copy = new int[path.length][2];
        for (int i = 0; i < path.length; i++) {
            copy[i][0] = path[i][0];
            copy[i][1] = path[i][1];
        }
        return copy;
    }
}