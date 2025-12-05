public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


//        int[][] data = {
//                {0, 1, 5},
//                {1, 2, 5},
//                {2, 3, 5}
//        };
//
//
//        Second s = new Second();
//        int res = s.minCost(4, data, 4);
//        System.out.println("res: "+res);
//

//        Third th = new Third();
//        char ch = th.processStr("a#b%*", 1);
//        System.out.println("result: "+ch);


        int[][] edges = {
                {2, 1},
                {0, 1},
                {2, 0}
        };
        Forth f = new Forth();
        int res = f.maxLen(3, edges, "fjj");
        System.out.println("result: "+res);
    }
}