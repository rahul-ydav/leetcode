import java.util.*;

public class Third {
    ArrayList<Integer>[] adj;
    public int specialNodes(int n, int[][] edges, int x, int y, int z) {

        adj = new ArrayList[n];

        for(int i=0; i<n; i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] eg : edges){
            adj[eg[0]].add(eg[1]);
            adj[eg[1]].add(eg[0]);
        }

        int[][] dis = new int[3][n];

        dis[0] = finder(n, x);
        dis[1] = finder(n, y);
        dis[2] = finder(n, z);

        int res = 0;
        for(int i=0; i<n; i++){
            long[] vals = {(long)dis[0][i]*dis[0][i], (long)dis[1][i]*dis[1][i], (long)dis[2][i]*dis[2][i]};

            Arrays.sort(vals);

            if(vals[2] == vals[1] + vals[0]){
                res++;
            }
        }

        return res;

    }

    int[] finder(int n, int start){

        int[] dis = new int[n];
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        vis[start] = true;

        while(!q.isEmpty()){
            int node = q.poll();
            vis[node] = true;

            for(int next: adj[node]){
                if(!vis[next]){
                    dis[next] = dis[node]+1;
                    q.offer(next);
                }
            }
        }

        return dis;
    }
}