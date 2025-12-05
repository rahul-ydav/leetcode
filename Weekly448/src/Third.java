public class Third {
    public int minTravelTime(int l, int n, int k, int[] pos, int[] time) {

        if(k==0){
            int sum = 0;
            for(int i=0; i<n-1; i++){
                sum+=(pos[i+1]-pos[i])*time[i];
            }
            return sum;
        }

        int minTime = Integer.MAX_VALUE;

        for(int i=1; i<n-1; i++){

            //remove sign
            // add times

            int[] posN = new int[n-1];
            int[] timeN = new int[n-1];

            for(int j=0; j<n-1; j++){
                if(j<i){
                    posN[j] = pos[j];
                    timeN[j] = time[j];
                }
                else if(j==i){
                    posN[j] = pos[j+1];
                    timeN[j] = time[j]+ time[j+1];
                }
                else{
                    posN[j] = pos[j+1];
                    timeN[j] = time[j+1];
                }
            }

            //call inner iteration( next merge)
            int currMin = minTravelTime(l, n-1, k-1, posN, timeN);
            minTime = Math.min(minTime, currMin);

        }

        return minTime;
    }
}
