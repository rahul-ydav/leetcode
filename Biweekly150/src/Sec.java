import java.math.BigInteger;
import java.util.Arrays;

public class Sec {
    public double separateSquares(int[][] squares) {
        double res = 0;

        Arrays.sort(squares, (a, b) -> {
            if(a[1]==b[1])  return a[2]-b[2];
            return a[1] - b[1];
        });

        System.out.println("a: "+squares);

        int prodlen = 0;
        for(int i=0; i<squares.length; i++){
            prodlen+=squares[i][2];
        }

        prodlen = prodlen/2;
        long prod = prodlen*prodlen;


        long halfProd = 0;
        for(int i=0; i<squares.length; i++){
            if(halfProd+squares[i][2]*squares[i][2]>prod){
                int j = i-1;
                for(j=i-1; j>=0; j--){
                    if(((squares[j][1]+squares[j][2])-squares[i][1])<=0){
                        break;
                    }
                    else halfProd-= ((squares[j][1]+squares[j][2])-squares[i][1])*squares[j][2];
                }
                if(j<0) j = 0;
                int scope = j-i+1;

                for(int x=j; x<=i; x++){
                    halfProd += scope*squares[j][1]*squares[x][1];
                    if(halfProd+scope*squares[j][1]*squares[x][1]>prod){
                        res = prod-halfProd/(i-x+1)*squares[x][2];
                        break;
                    }
                }
            }
            else{
                halfProd += squares[i][2]*squares[i][2];
            }
        }

        return res;
    }
}
