//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        int[] nums = {4,17,20,5};

//        Lt3886 lt3886 = new Lt3886();
//        int res = lt3886.sortableIntegers(nums);
//        System.out.println("res: "+res);

        int[][] edges = {{0,1,1},{1,2,1},{0,2,1}};
        Lt3887 lt3887 = new Lt3887();
        int res = lt3887.numberOfEdgesAdded(3, edges);
        System.out.println("res: "+res);

    }
}