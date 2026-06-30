public class LowerBound {

    int lb(int[] ct , int val, int en){

        int start = 0;
        int end = en;
        int res = -1;

        while(start<=end){
            int mid = (start + end)/2;

            if(ct[mid]>=val){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        if(start==en+1 || ct[start]!=val)   start= -(start+1);

        return start;

    }
}
