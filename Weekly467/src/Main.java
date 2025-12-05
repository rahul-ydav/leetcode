import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        Third th = new Third();
        int[] nums = {4, 2, 3, 4};
        int k = 5;
        boolean[] res = th.subsequenceSumAfterCapping(nums, k);

        System.out.println("res: "+ Arrays.toString(res));;

    }
}