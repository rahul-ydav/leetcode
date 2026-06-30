//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int[][] edges = {{0,1},{1,2}};
        int[] groups = {1, 1, 1};

        Forth f = new Forth();
        long res = f.interactionCosts(3, edges, groups);
        System.out.println("res: "+res);

    }
}