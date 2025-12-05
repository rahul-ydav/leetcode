public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

//        String st = "";

//        Second s = new Second();
//
//        long res = s.numOfSubsequences("TCTT");
//
//        System.out.println("res"+res);


        int[] nums = {5,7,9,5,1};
        Third th = new Third();
        int res = th.minJumps(nums);
        System.out.println("res:: "+res);

    }
}