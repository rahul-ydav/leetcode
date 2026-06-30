import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Third {
    public int shortestPath(int n, int[][] edges, String labels, int k) {

        List<Pair>[] adj = new ArrayList[n];
        for(int i=0; i<n; i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] e : edges){
            adj[e[0]].add(new Pair(e[1], e[2]));
        }
        PriorityQueue<Pair2> p = new PriorityQueue<>((a, b) -> a.w-b.w);
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);


        p.add(new Pair2(0, 0, labels.charAt(0), 1));
        dist[0] = 0;

        int[] visited = new int[n];

        while(!p.isEmpty()){
            Pair2 currPair = p.poll();
            visited[currPair.n] = 1;

            List<Pair> currArr = adj[currPair.n];
            for(Pair pair: currArr){

                if(dist[pair.n]> (dist[currPair.n] + pair.w) && visited[pair.n]==0 && (currPair.c != labels.charAt(pair.n) || currPair.cnt+1<=k)){
                    int newCnt = currPair.cnt;
                    if(currPair.c == labels.charAt(pair.n)){
                        newCnt++;
                    }
                    dist[pair.n] = dist[currPair.n] + pair.w;
                    p.add(new Pair2(pair.n, dist[pair.n], labels.charAt(pair.n), newCnt));
                }

            }
        }
        if(dist[n-1]==Integer.MAX_VALUE)    return -1;
        return dist[n-1];
    }

    class Pair2{
        int n;
        int w;
        char c;
        int cnt = 0;
        Pair2(int a, int b, char ch, int cnt){
            n = a;
            w = b;
            c = ch;
            this.cnt = cnt;
        }
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