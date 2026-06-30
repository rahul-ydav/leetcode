//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        int[] nums = {1, 0, 1};
//        int[][] edges = {{0,1},{1,2}};
//        Third th = new Third();
//        int res = th.evenSumSubgraphs(nums, edges);
//        System.out.println("res: "+res);

        int[] nums = {5, 4, 2};
        Forth f = new Forth();
        long res = f.maxAlternatingSum(nums, 2);
        System.out.println("res: "+res);
    }
}