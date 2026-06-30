import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int[][] edges = {{1,0},{1,2},{1,3},{3,4}};
        int[] good = {0, 1, 0, 1, 1};
        Forth f = new Forth();
        int[] res = f.maxSubgraphScore(5, edges, good);
        System.out.println("res: "+ Arrays.toString(res));
    }
}