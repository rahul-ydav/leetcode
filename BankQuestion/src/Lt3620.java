import java.util.ArrayList;
import java.util.HashMap;

public class Lt3620 {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        Graph g = new Graph(online.length, edges, online, k);

        int res = g.dfs(new Pair(0, 0), 0, Integer.MAX_VALUE);
        return res;
    }


    public class Graph{
        private int nodes;

        private int[] visited;
        boolean[] online;
        int target;
        long k;
        private HashMap<Integer, ArrayList<Pair>> edges = new HashMap<>();
        Graph(int n, int[][] B, boolean[] online, long k){
            nodes = n;
            this.online = online;
            this.k = k;
            target = n-1;
            visited = new int[n];

            for(int[] integers: B){
                ArrayList<Pair> adjacentNodes = this.edges.getOrDefault(integers[0], new ArrayList<>());
                adjacentNodes.add(new Pair(integers[1], integers[2]));
                edges.put(integers[0], adjacentNodes);
            }
        }

        int dfs(Pair currNode, long sum, int minCost){

            sum= sum+(long)currNode.cost;
            if(currNode.node!=0)    minCost = Math.min(minCost, currNode.cost);

            if(currNode.node==target){
                if(sum<=k)  return minCost;
                return -1;
            }
            visited[currNode.node] = 1;
            if(edges.get(currNode.node)==null || sum>k)   return -1;

            int ansCost = -1;
            for(Pair nodePair : edges.get(currNode.node)){
                // if(dfs(node))   return true;
                if(visited[nodePair.node]==0 && online[nodePair.node]){
                    int res = dfs(nodePair, sum, minCost);
                    if(res!=-1){
                        ansCost = Math.max(res, ansCost);
                    }
                }
            }

            visited[currNode.node] = 0;

            return ansCost;
        }
    }

    class Pair{
        int node;
        int cost;
        Pair(int a, int b){
            node = a;
            cost = b;
        }
    }
}
