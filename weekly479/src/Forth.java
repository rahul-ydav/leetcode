import java.util.ArrayList;
import java.util.List;

class Forth {
    public int[] maxSubgraphScore(int n, int[][] edges, int[] good) {

        for(int i=0; i<n; i++){
            if(good[i]==0)  good[i] = -1;
        }

        Graph g = new Graph(n, edges, good);

        g.dfs(0, -1);
        g.ans[0] = g.dp[0];
        g.dfsTopDown(0, -1);

        return g.ans;

    }

    class Graph{
        int nodes;
        List<Integer>[] adj;
        int[] good;
        int[] dp;
        int[] ans;

        Graph(int n, int[][] edges, int[] good){
            nodes = n;
            adj = new ArrayList[n];
            dp = new int[n];
            ans = new int[n];
            this.good = good;

            for(int i=0; i<n; i++){
                adj[i] = new ArrayList<>();
            }

            for(int[] edge : edges){
                adj[edge[0]].add(edge[1]);
                adj[edge[1]].add(edge[0]);
            }
        }

        void dfs(int currNode, int parent){

            dp[currNode] = good[currNode];

            for(Integer node : adj[currNode]){
                if(node != parent){
                    dfs(node, currNode);
                    if(dp[node]>0){
                        dp[currNode]+=dp[node];
                    }
                }
            }
        }

        void dfsTopDown(int currNode, int parent){

            for(int node: adj[currNode]){
                if(node!=parent){
                    int currNodeWithoutNodeContribution = ans[currNode] - Math.max(0, dp[node]);
                    ans[node] = dp[node] + Math.max(0, currNodeWithoutNodeContribution);
                    dfsTopDown(node, currNode);
                }
            }
        }
    }
}