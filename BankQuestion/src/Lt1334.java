import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Lt1334 {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {


        List<Pair>[] adj = new ArrayList[n];

        for(int i=0; i<n; i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] edge : edges){
            adj[edge[0]].add(new Pair(edge[1], edge[2]));
            adj[edge[1]].add(new Pair(edge[0], edge[2]));
        }

        int res = n;
        int maxCount = 0;

        for(int i=n-1; i>=0; i--){

            int[] dist = djx(n, adj, i);
            int count = 0;
            for(int d : dist){
                if(d>distanceThreshold){
                    count++;
                }
            }
            System.out.println("dist: "+ Arrays.toString(dist));
            System.out.println("i: "+i+", count: "+count);

            if(count>maxCount){
                maxCount = count;
                res = i;
            }
        }

        return res;
    }


    int[] djx(int n, List<Pair>[] adj, int start){

        int max = (int)1e6 + 5;
        int[] dist = new int[n];
        Arrays.fill(dist, max);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.w - b.w);
        boolean[] vis = new boolean[n];

        pq.add(new Pair(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            vis[curr.n] = true;

            for(Pair next : adj[curr.n]){
                if(!vis[next.n] && (dist[next.n]>next.w + dist[curr.n])){
                    dist[next.n] = next.w + dist[curr.n];
                    pq.add(new Pair(next.n, dist[next.n]));
                }
            }
        }

        return dist;
    }

    class Pair{
        int n;
        int w;
        Pair(int a, int b){
            n = a;
            w = b;
        }
    }
}