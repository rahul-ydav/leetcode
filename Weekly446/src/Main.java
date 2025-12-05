public class Main {
    public static void main(String[] args) {
        First f = new First();

        String[] instructions= {"jump","add","add"};
        int[] values = {3, 1, 1};
        long res = f.calculateScore(instructions, values);
        System.out.println("res : "+res);
        System.out.println("Hello world!");
    }
}