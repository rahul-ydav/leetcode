//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Forth f = new Forth();
        long res = f.countBalanced(1, 100);
        System.out.println("res: "+res);
    }
}