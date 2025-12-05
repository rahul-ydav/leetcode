public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
//        First f = new First();
//
//        int[] a = {1,2,1,3,2};
//        int[] b = {5,3,4,6,2};
//
//        int res  =f.maxSumDistinctTriplet(a, b);


        int[] a = {1,7,9,8,2};
        Second s = new Second();
        long res = s.maximumProfit(a, 2);
        System.out.println("res: "+res);
    }
}