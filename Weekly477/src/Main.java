import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        int[] nums = {3,3,0,3,1,4,0,4,3,0,2,3,2};
//        Ques q = new Ques();
//        int res = q.maxBalancedSubarray(nums);
//        System.out.println("res: "+res);

        int[][] queries = {{0, 7}, {1, 3}, {4, 6}};
        Third th = new Third();
        int[] res = th.sumAndMultiply("10203004", queries);
        System.out.println("res: "+ Arrays.toString(res));
    }
}