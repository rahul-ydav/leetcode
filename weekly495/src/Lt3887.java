import java.util.ArrayList;
import java.util.List;

public class Lt3887 {
    class DSU{
        int[] parent;
        DSU(int n){
            parent = new int[n];
            for(int i=0; i<n; i++){
                parent[i] = i;
            }
        }

        int findParent(int a){
            if(a!=parent[a]){
                int p = findParent(parent[a]);
                parent[a] = p;
            }
            return parent[a];
        }

        void merge(int a, int b){
            int x = findParent(a);
            int y = findParent(b);
            parent[y] = x;
        }
    }

    class Graph{
        int nodes;
        List<int[]>[] adj;
        boolean[] visited;
        Graph(int n){
            nodes = n;
            adj = new ArrayList[n];

            for(int i=0; i<n; i++){
                adj[i] = new ArrayList<>();
            }
        }

        int addEdge(int[] edge, DSU dsu){
            int firstP = dsu.findParent(edge[0]);
            int secP = dsu.findParent(edge[1]);
            if(firstP==secP){
                visited = new boolean[nodes];
                for(int sum : dfs(edge[0], edge[1])){
                    int cycleSum = edge[2] + sum;
                    if(cycleSum%2!=0){
                        return 0;
                    }
                }
            }
            else{
                dsu.parent[secP] = firstP;
            }
            adj[edge[0]].add(new int[]{edge[1], edge[2]});
            adj[edge[1]].add(new int[]{edge[0], edge[2]});
            return 1;
        }

        List<Integer> dfs(int src, int dest){
            if(src==dest){
                return new ArrayList<>(List.of(0));
            }

            visited[src] = true;
            List<Integer> res = new ArrayList<>();
            for(int[] next : adj[src]){
                if(!visited[next[0]]){
                    List<Integer> ans = dfs(next[0], dest);
                    if(ans.size()>0){
                        for(int val : ans){
                            res.add(next[1]+val);
                        }
                    }
                }
            }

            return res;
        }


    }
    public int numberOfEdgesAdded(int n, int[][] edges) {


        DSU dsu = new DSU(n);
        Graph g = new Graph(n);

        int count = 0;
        for(int[] edge : edges){
            count+=g.addEdge(edge, dsu);
        }
        return count;
    }
}