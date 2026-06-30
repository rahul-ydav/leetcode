//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        Second s = new Second();
//        int res = s.minimumK(nums);
//        System.out.println("res: "+res);


//        int[] nums = {5,4,7};
//        Third th = new Third();
//        int res = th.longestSubsequence(nums);
//        System.out.println("res: "+res);


        int[] nums = {5, 1, 2, 1};
        Forth f = new Forth();
        long res = f.minPartitionScore(nums, 2);
        System.out.println("res: "+res);
    }
}