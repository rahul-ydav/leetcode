//Giving TLE;
class Lt1526 {

    public int minNumberOperations(int[] target) {
        return finder(target, 0, target.length-1);

    }

    int finder(int[] target, int start, int end){

        if(start>end)   return 0;
        int res = 0;

        int smallest = 100001;
        for(int i=start; i<=end; i++){
            smallest = Math.min(smallest, target[i]);
        }
        res+=smallest;

        int nextStart = start;
        for(int i=start; i<=end; i++){
            target[i] = target[i] - smallest;
            if(target[i]==0){
                res+=finder(target, nextStart, i-1);
                nextStart=i+1;
            }
        }
        res+=finder(target, nextStart, end);

        return res;
    }

}