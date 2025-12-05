public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        String[] grid = {"A..",".A.","..."};
        Third th = new Third();
        int res = th.minMoves(grid);
        System.out.println("res:: "+res);
    }
}