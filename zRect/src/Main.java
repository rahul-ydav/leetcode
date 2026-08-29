import java.util.*;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {



//        for (int[][] grid : gridList) {
//            boolean res = validateSudoku(grid);
//            System.out.println("res: " + res);
//        }

//        char[][] matrix1 = {
//                {'W', 'W', 'W', 'W'},
//                {'B', 'W', 'W', 'W'},
//                {'B', 'W', 'B', 'B'},
//                {'W', 'W', 'B', 'W'},
//                {'B', 'B', 'W', 'W'}
//        };
//
//        // Array containing all row instructions (rows1_1 through rows1_8)
//        int[][][] rows1 = {
//                {{}, {1}, {1, 2}, {1}, {2}},     // rows1_1
//                {{}, {}, {1}, {1}, {1, 1}},     // rows1_2
//                {{}, {1}, {3}, {1}, {2}},        // rows1_3
//                {{}, {1, 1}, {1, 2}, {1}, {2}},  // rows1_4
//                {{}, {1}, {1}, {1}, {2}},        // rows1_5
//                {{}, {1}, {2, 1}, {1}, {2}},     // rows1_6
//                {{}, {1}, {1, 2}, {1}, {2, 1}},  // rows1_7
//                {{1}, {1}, {1, 2}, {1}, {2}}     // rows1_8
//        };
//
//// Array containing all column instructions (columns1_1 through columns1_8)
//        int[][][] columns1 = {
//                {{2, 1}, {1}, {2}, {1}},         // columns1_1
//                {{2}, {1}, {2}, {1}},            // columns1_2
//                {{3}, {1}, {2}, {1}},            // columns1_3
//                {{2, 1}, {1}, {2}, {1}},         // columns1_4
//                {{2, 1}, {1}, {2}, {1}},         // columns1_5
//                {{2, 1}, {1}, {2}, {1}},         // columns1_6
//                {{2, 1}, {1}, {2}, {1}},         // columns1_7
//                {{2, 1}, {1}, {2}, {1}}          // columns1_8
//        };
////        int[][][] rows2 = {
////                {{}, {2}, {2}, {1}},        // rows2_1
////                {{}, {2}, {2}, {1}},        // rows2_2
////                {{}, {}, {}, {}},           // rows2_3
////                {{}, {2}, {2}, {1}},        // rows2_4
////                {{}, {2}, {2}, {1}},        // rows2_5
////                {{}, {2}, {2}, {1}}         // rows2_6
////        };
////
////        int[][][] columns2 = {
////                {{1, 1}, {3}},              // columns2_1
////                {{3}, {3}},                 // columns2_2
////                {{}, {}},                   // columns2_3
////                {{2, 1}, {3}},              // columns2_4
////                {{2}, {3}},                 // columns2_5
////                {{2}, {1, 1}}               // columns2_6
////        };
//
//        for (int i = 0; i < rows1.length; i++) {
//            boolean res = validateNonogram(matrix1, rows1[i], columns1[i]);
//            System.out.println("res: " + res);
//        }




    }

    public static boolean validateSudoku(int[][] grid) {
        int n = grid.length;
        if(n==0)    return true;
        for (int i = 0; i < n; i++) {
            boolean[] present = new boolean[n+1];
            for (int j = 0; j < n; j++) {
                if(grid[i][j]<1 || grid[i][j]>n || present[grid[i][j]]) {
                    return false;
                }
                present[grid[i][j]] = true;
            }
        }

        for (int j = 0; j < n; j++) {
            boolean[] present = new boolean[n+1];
            for (int i = 0; i < n; i++) {
                if(grid[i][j]<1 || grid[i][j]>n || present[grid[i][j]]) {
                    return false;
                }
                present[grid[i][j]] = true;
            }
        }

        return true;
    }

    public static boolean validateNonogram(char[][] matrix, int[][] rows, int[][] cols) {
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i=0;i<n;i++) {
            int j = 0;
            for(int rl: rows[i]) {
                int cnt = 0;
                boolean found = false;
                if(j>=m)    return false;
                while(j<m && matrix[i][j]=='W') {j++;}
                while(j<m && matrix[i][j]== 'B') {
                    cnt++;
                    j++;
                    if (cnt == rl) {
                        found = (j == m || matrix[i][j] == 'W');
                        break;
                    }
                }
                if(!found){
                    return false;
                }
            }

            while(j<m) {
                if(matrix[i][j]=='B') {
                    return false;
                }
                j++;
            }
        }

        for(int i=0;i<m;i++) {
            int j = 0;
            for(int cl: cols[i]) {
                int cnt = 0;
                boolean found = false;
                if(j>=n)    return false;
                while(j<n && matrix[j][i]=='W') {j++;}
                while(j<n && matrix[j][i]== 'B') {
                    cnt++;
                    j++;
                    if (cnt == cl) {
                        found = (j == n || matrix[j][i] == 'W');
                        break;
                    }
                }
                if(!found){
                    return false;
                }
            }

            while(j<n) {
                if(matrix[j][i]=='B') {
                    return false;
                }
                j++;
            }
        }
        return true;
    }

    public static String[][] validateMoves(String[] start, String[] end){

        int n = start.length;
        int st = -1;
        int en = -1;
        for(int i=0;i<n;i++) {
            if(!start[i].equals(end[i])) {
                st =  i;
                break;
            }
        }
//        if(st==-1){ }

        for(int i=n-1;i>st;i--) {
            if(!end[i].equals(start[i])) {
                en =  i;
                break;
            }
        }

        if(st==-1 || en==-1){
            return new String[0][0];
        }

//        for(int i=st; i<=en; i++){
//            if(start[i])
//            if(start[i]=='R' && start)
//        }

        return new String[0][0];

    }
}