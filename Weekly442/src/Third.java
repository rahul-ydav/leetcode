public class Third {
    public long minTime(int[] skill, int[] mana) {
        int n = mana.length;
        int m = skill.length;

        long[][] time = new long[n][m];

        long start = 0;
        for(int j=0; j<m; j++){
            time[0][j] = start + (long) mana[0]*skill[j];
        }

        for(int i=1; i<n; i++){

            long currStart = 0;

            for(int j=m-2; j>=0; j--){
                if(currStart<time[i-1][j+1]){
                    currStart = time[i-1][j+1];
                }
                currStart -= (long) mana[i]*skill[j];
            }

            for(int j=0; j<m; j++){
                time[i][j] = currStart + (long) mana[i]*skill[j];
            }

        }
        return time[n-1][m-1];
    }
}
