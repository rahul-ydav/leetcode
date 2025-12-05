import java.util.Arrays;

class Third {
    public long maxTotal(int[] value, int[] limit) {
        int n = limit.length;
        int[][] vals = new int[n][2];

        for(int i=0; i<n; i++){
            vals[i][0] = value[i];
            vals[i][1] = limit[i];
        }

        Arrays.sort(vals, (a, b) -> {
            if(a[1]!=b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(b[0], a[0]);
        });




        long sum = 0;
        int l = vals[0][1];
        int count = 0;
        int i=0;
        while(i<n){
            if(count>=l){
                while(i<n && vals[i][1]==l){
                    i++;
                }
                if(i==n) break;
            }
            if(vals[i][1]>l){
                l = vals[i][1];
                count = 0;
            }
            sum= sum+(long)vals[i][0];
            ++count;
            i++;
        }

        return sum;
    }
}