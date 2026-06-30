//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int[] nums = {5,6,4,6,10,3,2,2,6};
        Third th = new Third();
        long res = th.maximumScore(nums, "010010111");
        System.out.println("res: "+res);
    }
}