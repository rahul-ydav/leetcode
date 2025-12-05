//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Third2 th = new Third2();
        int[][] grid = {{0, 1}, {2, 0}};

        int ans = th.maxPathScore(grid, 1);
        System.out.println("ans: "+ans);
    }
}