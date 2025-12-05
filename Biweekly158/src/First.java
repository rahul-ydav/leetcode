import java.util.ArrayList;
import java.util.Arrays;

public class First {
    public int maxSumDistinctTriplet(int[] x, int[] y) {

        int n = x.length;
        int[][] d = new int[n][2];

        for(int i=0; i<n; i++){
            d[i][0] = x[i];
            d[i][1] = y[i];
        }



        Arrays.sort(d, (a, b) ->{
            return Integer.compare(b[1], a[1]);
        });
        int a=0;
        int b=-1;
        int c = -1;
        for(int i=1; i<n; i++){
            if(d[a][0]!=d[i][0]){
                b = i;
                break;
            }
        }

        for(int i=b+1; i<n; i++){
            if(d[a][0]!=d[i][0] && d[b][0]!=d[i][0]){
                c= i;
                break;
            }
        }

        if(a!=-1 && b!=-1 && c!=-1){
            return d[a][1] + d[b][1] + d[c][1];
        }

//        System.out.println(Arrays.toString(d));

        return -1;
    }
}
