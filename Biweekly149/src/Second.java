public class Second {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {

        int n = startTime.length;
        int maxSum=0;
        int sum = 0;
        int[] diff = new int[n+1];

        for(int i=0; i<=n;i++){
            if(i==0) diff[i] = startTime[i];
            else if(i==n){
                diff[i] = eventTime - endTime[i-1];
            }
            else{
                diff[i] = startTime[i] - endTime[i-1];
            }
        }
        k++;
        for(int i=0; i<k; i++){
            sum+=diff[i];
        }
        maxSum = Math.max(maxSum, sum);
        for(int i=k; i<=n; i++){
            sum -= diff[i-k];
            sum+=diff[i];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
