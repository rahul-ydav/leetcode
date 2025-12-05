public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        int k = 1;
        int evt = 5;

        int[] st = {1, 3};
        int[] et = {2, 5};

        Second s = new Second();

        int res = s.maxFreeTime(evt, k, st, et);
        System.out.println("result:: "+res);
    }
}