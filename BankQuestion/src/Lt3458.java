import java.util.Arrays;

class Lt3458 {
    public boolean maxSubstringLength(String s, int k) {

        int n = s.length();
        int[][] period = new int[26][2];

        for(int i=0; i<26; i++){
            Arrays.fill(period[i], -1);
        }

        for(int i=0; i<n; i++){
            int idx = s.charAt(i) - 'a';
            if(period[idx][0]==-1){
                period[idx][0] = i;
                period[idx][1] = i;
            }
            else{
                period[idx][1] = i;
            }

        }

//        Arrays.sort(period, (a, b) -> a[1]-b[1]);

        int count = 0;

        for(int i=0; i<26; i++){
            if(period[i][0]==-1)    continue;

            int start = period[i][0];
            int end = period[i][1];
            boolean valid = true;
            for(int x=start+1; x<end; x++){
                int idx = s.charAt(x)-'a';

                if(period[idx][0]<start){
                    valid = false;
                    break;
                }

                end = Math.max(end, period[idx][1]);
            }
            if(valid && !(start==0 && end==n-1))    count++;
        }

        System.out.println("count: "+count);

        return k<=count;

    }
}