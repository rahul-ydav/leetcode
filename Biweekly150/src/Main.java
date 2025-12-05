public class Main {
    public static void main(String[] args) {

        int[][] sq = {
                {0,1,1},
                {2,3,1},
                {2,2,1}
        };

        Sec sec = new Sec();
        double res = sec.separateSquares(sq);

        System.out.println("mainRes:: "+res);

    }
}