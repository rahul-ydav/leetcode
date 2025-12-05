import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        //    {{4, 3}, {3, 5}, {7, 2}, {5, 2}}
//
//    {{2, 30}

//        First2 f = new First2();
//        long result = f.sumOfLargestPrimes("6735992919");
//        System.out.println("result:: "+result);


//        Integer[] al = {1, 2, 4};
//        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(al));
//        int result = s.upperBound(arr, 3);
//        Second s = new Second();
//        int result  = s.maxSubstrings("abcdeafdef");


        int[][] edges = {{1,2},{1,3},{3,4},{3,5}};  // {5, 6}, {6, 7}, {7, 8}
        Third third = new Third();
        int result = third.assignEdgeWeights(edges);
        System.out.println("result:: "+result);

    }



}