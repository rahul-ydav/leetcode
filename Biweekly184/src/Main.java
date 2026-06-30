//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        First f = new First();
//        boolean res = f.consecutiveSetBits(6);
//        System.out.println("res: "+res);

        int[][] intervals = {{1, 3}, {2, 4}};
//        int[][] intervals = {{2,8},{20,20},{4,6}};

//        Second s = new Second();
//        long res = s.minEnergy(4, 2, intervals);
//        System.out.println("res: "+res);

//        int[] nums = {11, 11, 14, 10};
        int[] nums = {9, 2, 6, 1};
        Third th = new Third();
        long res = th.maxTotal(nums, "0101");
        System.out.println("res: "+res);
    }
}