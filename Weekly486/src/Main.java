import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        int[] nums = {1, -2, 3, -4};
//        Second s = new Second();
//
//        int[] res = s.rotateElements(nums, 3);
//        System.out.println("res: "+ Arrays.toString(res));

        int[][] edges = {{0,1},{0,2},{0,3}};

        Third th = new Third();
        int res = th.specialNodes(4, edges, 1, 2, 3);
        System.out.println("res: "+res);
    }
}