import java.util.ArrayList;
import java.util.HashMap;

public class Third {

    int[][] dp;
    public int assignEdgeWeights(int[][] edges) {
        Graph g = new Graph(edges);

        g.dfs(1, -1);
        int n = g.maxDepth;

        dp = new int[n+1][2*n+1];

        return findOdds(n, 0, 0);
    }

    private int findOdds(int n, int idx, int sum){
        //base condition
        if(idx==n){
            if(sum%2==1)    return 1;
            return 0;
        }

        if(dp[idx][sum]!=0) return dp[idx][sum];

        int oddPaths = findOdds(n, idx+1, sum+1) + findOdds(n, idx+1, sum+2);

        dp[idx][sum] = oddPaths;
        return oddPaths;
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