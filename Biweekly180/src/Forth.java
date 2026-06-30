import java.util.Arrays;

public class Forth {
    final long mod = 1000_000_007;
    public int maxValue(int[] nums1, int[] nums0) {

        int n = nums1.length;

        int[][] arr = new int[n][2];

        for(int i=0; i<n; i++){
            arr[i][0] = nums0[i];
            arr[i][1] = nums1[i];
        }

        Arrays.sort(arr, (a, b)->{
            if(a[1]==b[1]){
                return a[0] - b[0];
            }
            return b[1] - a[1];
        });

        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<n; i++){
            sb.append("1".repeat(arr[i][1]));
            sb.append("0".repeat(arr[i][0]));
        }

        String str = sb.toString();
        long result = 0;
        for(int i=0; i<str.length(); i++){
            result = (result*2 + (str.charAt(i) - '0')%mod);
        }


        return (int)result;
    }
}