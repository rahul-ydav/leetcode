public class Main {
    public static void main(String[] args) {

//        First first = new First();
//        int res = first.countSubarrays(new int[]{1, 2, 1, 4, 1});
//        System.out.println("result: "+res);

        Q2 q2 = new Q2();
        int[][] arr = {
                {2, 1, 5},
                {7, 10, 0},
                {12, 6, 4}
        };
        int res2 = q2.countPathsWithXorValue(arr,11);
        System.out.println("result: "+res2);


//        Q3 q3 = new Q3();
//        int n = 4;
//        int[][] rectangles = {
//                {0,2,2,4},
//                {1,0,3,2},
//                {2,2,3,4},
//                {3,0,4,2}
//        };
//
//        boolean res3 = q3.checkValidCuts(n, rectangles);
//        System.out.println("result: "+res3);
    }
}