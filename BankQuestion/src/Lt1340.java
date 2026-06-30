class Lt1340 {

    int[] arr;
    int[] memo;
    int d;
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        memo = new int[n];
        this.arr = arr;
        this.d = d;

        int steps = 0;
        for(int i=0; i<n; i++){
            steps = Math.max(steps, finder(i));
        }

        return steps;
    }


    int finder(int idx){

        if(memo[idx]!=0)  return memo[idx];
        int res = 1;

        int k= idx-1;
        while(k>=0 && k>=idx-d){
            if(arr[idx]<=arr[k]) break;

            res = Math.max(res, 1+finder(k));
            k--;
        }

        k = idx+1;
        while(k<=arr.length-1 && k<=idx+d){
            if(arr[idx]<=arr[k]) break;

            res = Math.max(res, 1+finder(k));
            k++;
        }

        memo[idx] = res;
        return res;
    }
}