import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class Lt1345 {
    int[] arr;
    int[] memo;
    int n;
    int visited[];
    HashMap<Integer, List<Integer>> hm = new HashMap<>();
    public int minJumps(int[] arr) {

        this.arr = arr;
        n = arr.length;

        memo = new int[n];
        visited = new int[n];

        for(int i=0; i<n; i++){
            List<Integer> list = hm.getOrDefault(arr[i], new ArrayList<>());
            list.add(i);
            hm.put(arr[i], list);

        }

        int steps = finder(0);

        return steps;

    }

    int finder(int idx){
        if(idx==n-1){
            return 0;
        }

        if(memo[idx]>0){
            return memo[idx];
        }
        visited[idx] = 1;


        int res = n;

        int len = hm.get(arr[idx]).size();
        if(len>1){
            int start = Collections.binarySearch(hm.get(arr[idx]), idx)+1;

            while(start<len){
                if(visited[hm.get(arr[idx]).get(start)]==0){
                    res = Math.min(res, 1+finder(hm.get(arr[idx]).get(start)));
                }
                start++;
            }
        }
        if(idx-1>=0 && visited[idx-1]==0){
            res = Math.min(res, 1+finder(idx-1));
        }
        if(idx+1<n && visited[idx+1]==0){
            res = Math.min(res, 1+finder(idx+1));
        }

        visited[idx] = 0;
        memo[idx] = res;
        return res;
    }
}