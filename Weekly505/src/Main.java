//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int[] nums = {1, 0, 3, 4};
        Third th = new Third();
        long res = th.maximumSum(nums, 2, 1, 2);

        System.out.println("res: "+res);
    }
}