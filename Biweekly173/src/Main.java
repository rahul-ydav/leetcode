//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        int[] nums = {2, 2, 3, 1};
//        Second s = new Second();
//        int res = s.minLength(nums, 2);
//        System.out.println("res: "+res);

        String[] grid = {"..","#."};
        Forth f = new Forth();
        int res = f.numberOfRoutes(grid, 2);
        System.out.println("res: "+res);
    }
}