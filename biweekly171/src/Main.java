import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        First f = new First();
//        boolean res = f.completePrime(23);
//        System.out.println("res:"+res);

        int[] nums = {1624};
        Second s = new Second();
        int[] res = s.minOperations(nums);
        System.out.println("res:"+ Arrays.toString(res));
    }
}