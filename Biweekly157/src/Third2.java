import java.util.ArrayList;
import java.util.HashMap;

public class Third2 {
    final int mod = 1000000007;
    public int assignEdgeWeights(int[][] edges) {
        Graph g = new Graph(edges);

        g.dfs(1, -1);
        int n = g.maxDepth;
        n--;

        int result = (int) (findVal((long)n)%mod);
        return result;
    }

    long findVal(long n){
        if(n==0)    return 1;
        if(n==1)    return 2;
        long val = findVal(n/2);
        if(n%2==0){
            return (val*val)%mod;
        }
        return (val*val*2)%mod;
    }

    public class Graph{

        private int[] visited;
        int maxDepth = 0;
        private HashMap<Integer, ArrayList<Integer>> edges = new HashMap<>();

        Graph(int[][] B){
            for(int[] integers: B){
                ArrayList<Integer> adjacentNodes = this.edges.getOrDefault(integers[0], new ArrayList<>());
                adjacentNodes.add(integers[1]);
                edges.put(integers[0], adjacentNodes);

                ArrayList<Integer> adjacentNodes2 = this.edges.getOrDefault(integers[1], new ArrayList<>());
                adjacentNodes2.add(integers[0]);
                edges.put(integers[1], adjacentNodes2);
            }

            int n = edges.size();
            visited = new int[n+1];
        }

        void dfs(int currNode, int currDepth){
            if(visited[currNode]==1)    return;
            visited[currNode] = 1;

            currDepth +=1;
            maxDepth = Math.max(maxDepth, currDepth);

            if(edges.get(currNode)==null)   return;
            for(Integer node : edges.get(currNode)){
                dfs(node, currDepth);
            }
        }
    }
}
