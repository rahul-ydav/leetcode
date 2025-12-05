public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

//        String[] sr = {"ae", "be"};
//        int[][] waitCost = {{6,1,4},{3,2,5}};
//
//        Second s = new Second();
//        long ans = s.minCost(2, 3, waitCost);
//        System.out.println("result: "+ans);

        int[][] edges = {
                {1, 3, 10, 16},
                {0, 2, 6, 7},
                {0, 2, 0, 10},
                {0, 3, 3, 15}
        };

        Third th = new Third();
        int ans = th.minTime(4, edges);
        System.out.println("result: "+ans);


    }


}