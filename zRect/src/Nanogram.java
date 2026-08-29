/*
A nonogram is a logic puzzle, similar to a crossword, in which the player is given a blank grid and an instruction for each row and each column. The player has to color each row and column using the corresponding instruction. Each cell can be either black or white, which we will represent as 'B' for black and 'W' for white.

+------------+
| W  W  W  W |
| B  W  W  W |
| B  W  B  B |
| W  W  B  W |
| B  B  W  W |
+------------+

For each row and column, the corresponding instruction gives the lengths of contiguous runs of black ('B') cells. For example, the instruction [ 2, 1 ] for a specific row indicates that there must be a run of two black cells, followed later by another run of one black cell, and the rest of the row is filled with white cells.

These are valid solutions: [ W, B, B, W, B ] and [ B, B, W, W, B ] and also [ B, B, W, B, W ]
This is not valid: [ W, B, W, B, B ] since the runs are not in the correct order.
This is not valid: [ W, B, B, B, W ] since the two runs of Bs are not separated by Ws.

Your job is to write a function to validate a possible solution against a set of instructions. Given a 2D matrix representing a player's solution; and instructions for each row along with additional instructions for each column; return True or False according to whether both sets of instructions match.

Example solution matrix:

validateNonogram(matrix1, rows1_1, columns1_1) => True

matrix1 ->
                                 rows1_1
                +------------+
                | W  W  W  W | <-- []
                | B  W  W  W | <-- [1]
                | B  W  B  B | <-- [1,2]
                | W  W  B  W | <-- [1]
                | B  B  W  W | <-- [2]
                +------------+
                  ^  ^  ^  ^
                  |  |  |  |
               [2,1] | [2] |
  columns1_1        [1]   [1]


Example instructions #2

(same matrix as above)
rows1_2    =  [], [], [1], [1], [1,1]
columns1_2 =  [2], [1], [2], [1]
validateNonogram(matrix1, rows1_2, columns1_2) => False

The second, third and last rows and the first column do not match their respective instructions.

rows1_3    =  [], [1], [3], [1], [2]
columns1_3 =  [3], [1], [2], [1]
validateNonogram(matrix1, rows1_3, columns1_3) => False

rows1_4    =  [],[1,1],[1,2],[1],[2]
columns1_4 =  [2,1],[1],[2],[1]
validateNonogram(matrix1, rows1_4, columns1_4) => False

rows1_5    =  [],[1],[1],[1],[2]
columns1_5 =  [2,1],[1],[2],[1]
validateNonogram(matrix1, rows1_5, columns1_5) => False

rows1_6    =  [], [1], [2,1], [1], [2]
columns1_6 =  [2,1], [1], [2], [1]
validateNonogram(matrix1, rows1_6, columns1_6) => False

rows1_7    =  [], [1], [1,2], [1], [2,1]
columns1_7 =  [2,1], [1], [2], [1]
validateNonogram(matrix1, rows1_7, columns1_7) => False

rows1_8    =  [1], [1], [1,2], [1], [2]
columns1_8 =  [2,1], [1], [2], [1]
validateNonogram(matrix1, rows1_8, columns1_8) => False


validateNonogram(matrix2, rows2_1, columns2_1) => False
matrix2 ->
                                 rows2_1
                +------+
                | W  W | <-- []
                | B  B | <-- [2]
                | B  B | <-- [2]
                | W  B | <-- [1]
                +------+
                  ^  ^
                  |  |
               [1,1] |
  columns2_1        [3]


Example instructions #2

(same matrix as above)
rows2_2    = [], [2], [2], [1]
columns2_2 =  [3], [3]
validateNonogram(matrix2, rows2_2, columns2_2) => False

rows2_3    =  [], [], [], []
columns2_3 =  [], []
validateNonogram(matrix2, rows2_3, columns2_3) => False

rows2_4    =  [], [2], [2], [1]
columns2_4 =  [2,1], [3]
validateNonogram(matrix2, rows2_4, columns2_4) => False

rows2_5    = [], [2], [2], [1]
columns2_5 =  [2], [3]
validateNonogram(matrix2, rows2_5, columns2_5) => True

rows2_6   =  [], [2], [2], [1]
columns2_6 =  [2], [1,1]
validateNonogram(matrix2, rows2_6, columns2_6) => False


validateNonogram(matrix3, rows3_1, columns3_1) => True
matrix3 ->
                                 rows3_1
                +------------------+
                | B  W  B  B  W  B | <-- [1,2,1]
                +------------------+
                  ^  ^  ^  ^  ^  ^
                  |  |  |  |  |  |
                 [1] | [1] | []  |
  columns3_1        []    [1]   [1]


Example instructions #2

(same matrix as above)
rows3_2    =  [1, 2, 2]
columns3_2 =  [1], [], [1], [1], [], [1]
validateNonogram(matrix3, rows3_2, columns3_2) => False

All Test Cases:
validateNonogram(matrix1, rows1_1, columns1_1) => True
validateNonogram(matrix1, rows1_2, columns1_2) => False
validateNonogram(matrix1, rows1_3, columns1_3) => False
validateNonogram(matrix1, rows1_4, columns1_4) => False
validateNonogram(matrix1, rows1_5, columns1_5) => False
validateNonogram(matrix1, rows1_6, columns1_6) => False
validateNonogram(matrix1, rows1_7, columns1_7) => False
validateNonogram(matrix1, rows1_8, columns1_8) => False
validateNonogram(matrix2, rows2_1, columns2_1) => False
validateNonogram(matrix2, rows2_2, columns2_2) => False
validateNonogram(matrix2, rows2_3, columns2_3) => False
validateNonogram(matrix2, rows2_4, columns2_4) => False
validateNonogram(matrix2, rows2_5, columns2_5) => True
validateNonogram(matrix2, rows2_6, columns2_6) => False
validateNonogram(matrix3, rows3_1, columns3_1) => True
validateNonogram(matrix3, rows3_2, columns3_2) => False

r: number of rows in the matrix
c: number of columns in the matrix
* */
public class Nanogram {

    public static boolean validateNonogram(char[][] matrix, int[][] rows, int[][] cols) {
        int n = matrix.length;
        int m = matrix[0].length;

        // 1. Validate rows
        for (int i = 0; i < n; i++) {
            int j = 0;
            for (int rl : rows[i]) {
                int cnt = 0;
                boolean found = false;
                if (j >= m) return false;
                while (j < m && matrix[i][j] == 'W') j++;
                while (j < m && matrix[i][j] == 'B') {
                    cnt++;
                    j++;
                    if (cnt == rl) {
                        found = (j == m || matrix[i][j] == 'W');
                        break;
                    }
                }
                if (!found) return false;
            }

            // Ensure no extra black cells in the rest of row i
            while (j < m) {
                if (matrix[i][j] == 'B') return false;
                j++;
            }
        }

        // 2. Validate columns
        for (int i = 0; i < m; i++) {
            int j = 0;
            for (int cl : cols[i]) {
                int cnt = 0;
                boolean found = false;
                if (j >= n) return false;
                while (j < n && matrix[j][i] == 'W') j++;
                while (j < n && matrix[j][i] == 'B') {
                    cnt++;
                    j++;
                    if (cnt == cl) {
                        found = (j == n || matrix[j][i] == 'W');
                        break;
                    }
                }
                if (!found) return false;
            }

            // Ensure no extra black cells in the rest of column i
            while (j < n) {
                if (matrix[j][i] == 'B') return false;
                j++;
            }
        }

        return true;
    }
}

