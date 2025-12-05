import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        int[] nums1 = {4,2,1,5,3};
        int[] nums2 = {10,20,30,40,50};
        Second sc = new Second();
        long[] res = sc.findMaxSum(nums1, nums2, 2);
        System.out.println("res:: "+ Arrays.toString(res));
    }
}