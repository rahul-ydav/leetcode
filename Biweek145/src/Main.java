import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> A = Arrays.asList(3, 4, 1);

        int B = 1;

//        Q2 q2 = new Q2();
//        int res = q2.findMinimumTime(A, B);

        Q2permute2 q2p = new Q2permute2();
        int res = q2p.findMinimumTime(A, B);
        System.out.println("res::: "+ res);
    }
}