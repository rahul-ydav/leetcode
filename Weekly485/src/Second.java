import java.util.Arrays;

class Second {
    public int maxCapacity(int[] ct, int[] cp, int budget) {

        int n = ct.length;

        int[][] cm = new int[n][2];

        for(int i=0; i<n; i++){
            cm[i][0] = ct[i];
            cm[i][1] = cp[i];
        }

        Arrays.sort(cm, (a, b)-> (a[0]==b[0]) ? b[1] - a[1] : a[0] - b[0]);

        int[] pfm = new int[n+1];

        for(int i=0; i<n; i++){
            pfm[i+1] = Math.max(pfm[i], cm[i][1]);
        }

        Arrays.sort(ct);

        int res = 0;
        for(int i=0; i<n; i++){
            int rem = budget - cm[i][0] - 1;

            int j = lowerBound(ct, rem, i-1);

            if(j<0){
                j = -(j+1)-1;
            }
            res = Math.max(res, cm[i][1] + pfm[j+1]);
        }

        return res;
    }

    int lowerBound(int[] ct , int val, int end){

        int start = 0;
        int res = -1;

        while(start<=end){
            int mid = (start + end)/2;

            if(ct[mid]==val){
                return mid;
            }
            if(ct[mid]<=val){
                res = mid;
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }

        return res;

    }
}