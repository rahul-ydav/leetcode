import java.util.Arrays;

public class Second {
    public long minEnergy(int n, int brightness, int[][] intervals) {

        long reqBulbs = brightness/3L;
        if(brightness%3!=0){
            reqBulbs++;
        }

        // System.out.println("reqBulbs: "+reqBulbs);

        Arrays.sort(intervals, (int[] a, int[] b)->{
            if(a[0]==b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        long reqTime = (long)intervals[0][1] - intervals[0][0] + 1;
        int mx = intervals[0][0];
        for(int i=1; i<intervals.length; i++){
            // System.out.println(Arrays.toString(intervals[i]));
            if(intervals[i][0]<=mx){
                if(intervals[i][1]>mx) reqTime += intervals[i][1] - mx;
            }
            else{
                reqTime += intervals[i][1] - intervals[i][0] + 1;
            }
            mx = Math.max(mx, intervals[i][1]);

        }

        return (long)(reqTime*reqBulbs);
    }
}