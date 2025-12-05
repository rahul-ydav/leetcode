public class Second {
    public int[][] specialGrid(int N) {

        int  n = (1<<N);
        int maxInt = (1<<2*N);

        int[][] mt = new int[n][n];

        filler(mt, n, 0, 0, 1, maxInt);
        return mt;
    }

    void filler(int[][] mt, int n, int x, int y, int start, int end){

//        System.out.println("n: "+n+ ", x: "+x+ ", y: "+y+", start: "+start+", end: "+end);
        if(n==1){
            mt[x][y] = start-1;
            return;
        }
        int vals = (end - start+1)/4;

        //top right
        filler(mt, n/2, x, y+n/2, start, start+vals);

        //bottom left
        filler(mt, n/2, x+n/2, y+n/2, start + vals, start + 2*vals);

        //bottom right
        filler(mt,  n/2, x+n/2, y, start + 2*vals, start + 3*vals);

        //top left
        filler(mt, n/2, x, y, start + 3*vals, start + 4*vals);
    }
}
