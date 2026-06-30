//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int[] nums = {1, 0, 0};
        int t1 = 1;
        int t2 = 0;

        Third th = new Third();
        int res = th.alternatingXOR(nums, t1, t2);
        System.out.println("res: "+res);
    }
}