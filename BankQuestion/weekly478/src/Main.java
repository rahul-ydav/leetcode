import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int[] nums = {1, 4, 7};
        int[][] queries = {{0, 1}, {0, 2}};
        Forth f = new Forth();
        long[] res = f.minOperations(nums, 3, queries);
        System.out.println("res: "+ Arrays.toString(res));
    }
}