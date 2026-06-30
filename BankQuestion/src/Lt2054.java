import java.util.Arrays;

//This problem is based on line sweep algorithm if you feel difficult go through these quesiton.
//Maximum Population Year -> 1854
//Points That Intersect With Cars -> 2848
//Car Pooling -> 1094
//My Calendar II -> 731
//Shifting Letters II -> 2381
//Perfect Rectangle -> 391
//Rectangle Area II -> 850
//Number of Flowers in Full Bloom -> 2251

public class Lt2054 {
    int[][] events;
    int[][] memo;
    int n;
    public int maxTwoEvents(int[][] events) {
        n = events.length;
        this.events = events;
        this.memo = new int[2][n];
        Arrays.fill(memo[0], -1);
        Arrays.fill(memo[1], -1);
        Arrays.sort(events, (a, b) -> a[0] -b[0]);

        return finder(0, 0);
    }

    int finder(int idx, int count){

        if(count==2 || idx==n){
            return 0;
        }

        if(memo[count][idx]!=-1){
            return memo[count][idx];
        }
        int nextStartTime = events[idx][1]+1;

        int start = idx+1;
        int end = n-1;
        while(start<end){
            int mid = start + (end-start)/2;
            if(events[mid][0]>=nextStartTime){
                end = mid;
            }
            else{
                start = mid+1;
            }
        }

        int ans1 = events[idx][2];
        if(start<n && events[start][0]>=nextStartTime){
            ans1 += finder(start, count+1);
        }

        int ans2 = finder(idx+1, count);

        return memo[count][idx] = Math.max(ans1, ans2);

    }
}