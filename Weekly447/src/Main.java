import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

//        int[][] buildings = {
//            {1, 2},
//            {2, 2},
//            {3, 2},
//            {2, 1},
//            {2, 3}
//        };

        int[][] buildings = {{1,3},{3,2},{3,3},{3,5},{5,3}};

//        First  f = new First();
//        int res = f.countCoveredBuildings(5, buildings);
//        System.out.println("res: "+res);

        Forth fo = new Forth();

        int[] nums = {1,8,3,4,2};
        int[][] queries = {{0,3},{2,4}};
        int[] res = fo.pathExistenceQueries(5,nums, 3, queries);
        System.out.println("res: "+ Arrays.toString(res));
    }
}