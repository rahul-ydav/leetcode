import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        First f = new First();

        List<List<String>> list = Arrays.asList(
                Arrays.asList("good", "ok", "good"),
                Arrays.asList("ok", "bad"),
                Arrays.asList("bad", "notsure"),
                Arrays.asList("great", "good")
        );

//        String res = f.findCommonResponse(list);



        int[][] in = {{0,1,1000000000},{1,2,1000000000}};
        Second s = new Second();
        int[] res = s.baseUnitConversions(in);
        System.out.println("res: "+Arrays.toString(res));
    }
}