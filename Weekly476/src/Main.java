import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Third th = new Third();
        int[] res = th.lexSmallestNegatedPerm(3, 0);
        System.out.println("res:"+Arrays.toString(res));

//        int[] arr = {2, 10, 3, -5, -8, -10, 5};
//        int[] arr2 = {22, 10, 3, -5, -8, -10, 5};
//
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(arr2));
//        System.out.println(Arrays.toString(arr).compareTo(Arrays.toString(arr2)));
//        arr2 = arr;
//        System.out.println(Arrays.toString(arr));
//        arr[0]++;
//        System.out.println(Arrays.toString(arr2));

    }
}