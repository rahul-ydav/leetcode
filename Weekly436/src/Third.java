import java.math.BigInteger;

public class Third {

    public long countSubstrings(String s) {
//        for(int i=1; i<=9; i++)
        for(int i=0; i<s.length(); i++){
            for(int j=i+1; j<s.length(); j++){
                BigInteger largeNum = new BigInteger(s.substring(i, j));
                for(int d=1; d<=9; d++){
                    BigInteger di =  BigInteger.valueOf(d);

                    if()
                }
            }
        }
    }
}
