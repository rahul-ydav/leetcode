public class Main {
    public static void main(String[] args) {


        int[][] array = {
//                {0, 1, 2},
//                {1, 2, 3},
//                {1, 3, 5},
//                {1, 4, 4},
//                {2, 5, 6}
//                {1, 0, 7},
//                {1, 2, 4}
                {3,0,5},
                {3,1,6},
                {2,3,5}
        };
        int[] nums = {2, 2, 2,1};
//        int[] nums = {1, 1, 3};
//        Second sec = new Second();
        Third2 sec = new Third2();
        int[] res = sec.longestSpecialPath(array, nums);

        System.out.println("res: [" + res[0]+", "+res[1]+"]");
    }
}