import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

//        int[] nums = {3,1,6,8,4};
//        First f = new First();
//        boolean res = f.checkEqualPartitions(nums, 24);


//        int[][] grid = {{1,-2,3},{2,3,5}};
//        Second s = new Second();
//        int[][] res = s.minAbsDiff(grid, 2);
//        System.out.println("res:: "+ Arrays.deepToString(res));


        String[] classroom = {"L.S", "RXL"};
        Third2 t = new Third2();
        int res = t.minMoves(classroom, 4);
        System.out.println("res:: "+ res);



    }
}