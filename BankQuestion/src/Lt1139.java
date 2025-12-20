public class Lt1139 {
    public int largest1BorderedSquare(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[][] hr = new int[n][m];
        int[][] vr = new int[n][m];

        int res = 0;
        int consec = 0;
        for(int i=0; i<n; i++){
            consec = 0;
            for(int j=0; j<m; j++){
                if(grid[i][j]==1){
                    consec++;
                    hr[i][j] = consec;
                }
                else consec = 0;
            }
        }


        for(int j=0; j<m; j++){
            consec = 0;
            for(int i=0; i<n; i++){
                if(grid[i][j]==1){
                    consec++;
                    vr[i][j] = consec;
                }
                else consec = 0;
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int val = hr[i][j];
                while(val>res){
                    if(i+val-1<n && j-val+1>=0){
                        int side = val-1;
                        if(hr[i+side][j]>=val && vr[i+side][j]>=val && vr[i+side][j-side]>=val){
                            res = val;
                            break;
                        }
                    }
                    val--;
                }
            }
        }

        return res*res;

    }
}
