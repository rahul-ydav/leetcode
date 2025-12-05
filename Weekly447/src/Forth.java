public class Forth {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] res = new int[queries.length];

        for(int i=0; i<queries.length; i++){
            int u = Math.min(queries[i][0], queries[i][1]);
            int v = Math.max(queries[i][0], queries[i][1]);

            int k = u;
            while(k<=v){
                int lastK = k;
                while(k<v && nums[k+1]-nums[lastK]<=maxDiff){
                    k++;
                }
                if(k==lastK){
                    res[i] = -1;
                    break;
                }
                res[i]++;

            }


        }
        return res;
    }
}
