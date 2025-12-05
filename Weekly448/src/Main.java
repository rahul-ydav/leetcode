import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

//        Second s = new Second();
//        int[][] res = s.specialGrid(2);
//
//        for(int[] i: res){
//            System.out.println(Arrays.toString(i));
//        }

        Third th = new Third();
        int[] pos = {0,3,8,10};
        int[] time = {5, 8, 3, 6};

        int res = th.minTravelTime(10, 4, 1, pos, time);
        System.out.println("res:: "+res);

    }
}