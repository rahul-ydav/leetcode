import java.util.*;

public class Forth {

    public long interactionCosts(int n, int[][] edges, int[] group) {

        int[] ttlgrpCount = new int[21];

        for(int i=0; i<n; i++){
            ttlgrpCount[group[i]]++;
        }

        Graph g = new Graph(n, edges, group, ttlgrpCount);

        HashMap<Integer, int[]>[] dp = new HashMap[n];
        for(int i=0; i<n; i++){
            dp[i] = new HashMap<>();
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<g.edges[i].size(); j++){
                int nextNode= g.edges[i].get(j);
                if(!dp[i].containsKey(nextNode)){
                    Arrays.fill(g.visited, false);
                    g.visited[i] = true;
                    dp[i].put(nextNode, g.dfs(nextNode, dp));
                }
            }
        }

        long res = 0;
        for(int i=0; i<edges.length; i++){
            int node1 = edges[i][0];
            int node2 = edges[i][1];
            int[] cnt = dp[node1].get(node2);
            for(int j=0; j<21; j++){
                res += (long) cnt[j]*(ttlgrpCount[j] - cnt[j]);
            }
        }

        return res;
    }

    public class Graph{
        private int nodes;
        long res = 0;
        int[] group;
        int[] ttlgrpCount;
        boolean[] visited;
        List<Integer>[] edges;

        Graph(int n, int[][] B, int[] group, int[] ttlgrpCount){
            nodes = n;

            visited = new boolean[n];
            this.group = group;
            this.ttlgrpCount = ttlgrpCount;

            edges = new ArrayList[n];
            for(int i=0; i<n; i++){
                edges[i] = new ArrayList<>();
            }

            for(int[] integers: B){
                edges[integers[0]].add(integers[1]);
                edges[integers[1]].add(integers[0]);
            }
        }

        int[] dfs(int currNode, HashMap<Integer, int[]>[] dp){
            visited[currNode] = true;
            int[] curgrpCount = new int[21];
            int grp = group[currNode];
            curgrpCount[grp]++;

            for(Integer node : edges[currNode]){
                if(!visited[node]){

                    int[] nextgrpCount;
                    if(dp[currNode].get(node)==null){
                        nextgrpCount = dfs(node, dp);
                        dp[currNode].put(node, nextgrpCount);
                    }
                    else nextgrpCount = dp[currNode].get(node);
                    for(int i=0; i<21; i++){
                        curgrpCount[i] += nextgrpCount[i];
                    }
                }
            }

            return curgrpCount;
        }
    }
}
