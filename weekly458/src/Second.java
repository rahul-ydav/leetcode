import java.util.Arrays;

class Second {

    public int[] parent;

    int find(int x){
        if(parent[x]!=x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    int union(int a, int b){
        int parentA = find(a);
        int parentB = find(b);

        if(parentA!=parentB){
            parent[parentB] = parentA;
            return 1;
        }
        return 0;
    }
    public int minCost(int n, int[][] edges, int k) {


        parent = new int[n];
        int comps = n;

        for(int i=0; i<n; i++){
            parent[i] = i;
        }

        Arrays.sort(edges, (a, b) -> b[2]-a[2]);

        for(int i=edges.length-1; i>=0; i--){
            if(comps>k){
                comps = comps - union(edges[i][0], edges[i][1]);
                if(comps==k)    return edges[i][2];
            }
        }




//        System.out.println("second "+ comps+ ", "+ k);
//        if(comps>k) return 0;

//        if(edges.length<=k-comps)  return 0;

//        System.out.println("dif: "+(k-comps));

        return 0;
    }
}