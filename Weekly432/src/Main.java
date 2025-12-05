public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        int[][] coins = {
                {0, 1, -1},
                {1, -2, 3},
                {2, -3, 4}
        };

        Second sec = new Second();

        int res = sec.maximumAmount(coins);

        System.out.println("res::: "+ res);

    }
}