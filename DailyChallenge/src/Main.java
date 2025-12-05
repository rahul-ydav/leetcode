import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        System.out.println("Hello world!");

//        Jan15 jan16 = new Jan15();
//        int num1 = 79;
//        int num2 = 74;
//
//        int res = jan16.minimizeXor(num1, num2);
//
//        System.out.println("res:: "+res);
//        System.out.println((1<<30)&1);
//        System.out.println((1<<5) ^ 32);

//        int[][] arr = {
//                {20,3,20,17,2,12,15,17,4,15},
//                {20,10,13,14,15,5,2,3,14,3}
//            };
//        Jan21 jan21 = new Jan21();
//        long res = jan21.gridGame(arr);
//        System.out.println("res:: "+res);

//        int n = 2;
//        int[][] pr = {{1, 0}};
//        int[][] queries = {{0, 1}, {1, 0}};
//
//        Jan27 j27 = new Jan27();
//        List<Boolean> res = j27.checkIfPrerequisite(n, pr, queries);
//
//        System.out.println(res.stream().toString());

//        int[][] grid = {{10,5},{8,0}};
//        Jan28 j28 = new Jan28();
//        int res = j28.findMaxFish(grid);
//        System.out.println("result:: "+res);

//        int[][] edges = {
//                {9,16},{8,3},{20,21},{12,16},{14,3},{7,21},{22,3},{22,18},{11,16},
//                {25,4},{2,4},{14,21},{23,3},{17,3},{2,16},{24,16},{13,4},{10,21},
//                {7,4},{9,18},{14,18},{14,4},{14,16},{1,3},{25,18},{17,4},{1,16},
//                {23,4},{2,21},{5,16},{24,18},{20,18},{19,16},{24,21},{9,3},{24,3},
//                {19,18},{25,16},{19,21},{6,3},{26,18},{5,21},{20,16},{2,3},{10,18},
//                {26,16},{8,4},{11,21},{23,16},{13,16},{25,3},{7,18},{19,3},{20,4},
//                {26,3},{23,18},{15,18},{17,18},{10,16},{26,21},{23,21},{7,16},
//                {8,18},{10,4},{24,4},{7,3},{11,18},{9,4},{26,4},{13,21},{22,16},
//                {22,21},{20,3},{6,18},{9,21},{10,3},{22,4},{1,18},{25,21},{11,4},
//                {1,21},{15,3},{1,4},{15,16},{2,18},{13,3},{8,21},{13,18},{11,3},
//                {15,21},{8,16},{17,16},{15,4},{12,3},{6,4},{17,21},{5,18},{6,16},
//                {6,21},{12,4},{19,4},{5,3},{12,21},{5,4}
//        };
//        Jan30 j30 = new Jan30();
//        int res = j30.magnificentSets(26, edges);
//        System.out.println("result:: "+res);

//        int[][] edges2 = {{1,0},{0,1}};
//        Jan31 j31 = new Jan31();
//        int res = j31.largestIsland(edges2);
//        System.out.println("result:: "+res);

        int[][] queries = {{1,4},{2,5},{1,3},{3,4}};
        Feb7 f7 = new Feb7();
        int[] res2 = f7.queryResults(4, queries);
        System.out.println("res2:: ");
        for(int i=0; i<res2.length; i++){
            System.out.print(res2[i]+", ");
        }
        System.out.println();
    }
}