public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        int[][] B = {{1,0,7615},{2,1,39},{0,2,8481},{1,3,2724},{3,2,9810},{3,0,9236}};

        Third2 th = new Third2();

        int res = th.minTime(4, B, 1);
        System.out.println("result: "+res);
    }
}