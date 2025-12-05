import java.util.Arrays;

public class Third3 {

    int[] parent;

    int find(int x){
        if(parent[x]!=x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    boolean union(int a, int b){
        int aParent = find(a);
        int bParent = find(b);
        if(aParent!=bParent){
            parent[bParent] = aParent;
        }
        return aParent!=bParent;
    }
    public int minTime(int n, int[][] B, int k){

        parent = new int[n];

        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        Arrays.sort(B, (a, b) -> a[2] - b[2]);

        int comps = n;

        for(int i=B.length-1; i>=0; i--){
            boolean ans = comps==k;
            if(union(B[i][0], B[i][1])) comps--;
            if(ans && comps<k)  return B[i][2];
        }

        return 0;
    }
}
