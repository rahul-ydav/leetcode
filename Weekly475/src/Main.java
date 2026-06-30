//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[][] grid = {{0, 2, 2, 2, 2},{1, 1, 1, 1, 1},{0, 0, 0, 0, 0}};

//        Third2 th = new Third2();
//        int ans = th.maxPathScore(grid, 1);

        Lt3742 lt3742 = new Lt3742();
        int ans = lt3742.maxPathScore(grid, 3);
        System.out.println("ans: "+ans);
    }
}