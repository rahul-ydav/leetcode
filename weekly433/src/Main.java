public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        int[] arr = {1, 2, 3};

        Second s = new Second();
        int res = s.minMaxSums(arr, 2);

        System.out.println("res: "+res);
    }
}