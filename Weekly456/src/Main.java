import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

//        String[] words = {"f","cfe","feab","fcc","cdfda","fcec","afae","cdeb","dc","bffd","edabe"};
//        Second sec = new Second();
//
//        int[] res = sec.longestCommonPrefix(words);
//
//        System.out.println("res: "+ Arrays.toString(res));


        int[] nums = {2, 3, 3, 2};
        Third2 th = new Third2();

        int ans = th.minXor(nums, 3);
        System.out.println("result: "+ans);

    }

}