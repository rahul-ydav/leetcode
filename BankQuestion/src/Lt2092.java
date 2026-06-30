import java.util.*;

class Lt2092 {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Graph g = new Graph(n, meetings);

        g.djx(firstPerson);
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(g.visited[i])    res.add(i);
        }
        return res;
    }

    class Graph{

        int nodes;
        List<int[]>[] edges;
        boolean[] visited;

        Graph(int n, int[][] B){
            nodes = n;

            visited = new boolean[n];
            edges = new ArrayList[nodes];
            for(int i=0; i<n; i++){
                edges[i] = new ArrayList<>();
            }

            for(int[] vals: B){
                edges[vals[0]].add(new int[]{vals[1], vals[2]});
                edges[vals[1]].add(new int[]{vals[0], vals[2]});
            }
        }

        void djx(int startNode){

            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
            pq.add(new int[]{0, 0});
            pq.add(new int[]{startNode, 0});

            while(!pq.isEmpty()){
                int[] p = pq.poll();

                visited[p[0]] = true;

                for(int[] nextPerson : edges[p[0]]){
                    if(nextPerson[1]>=p[1] && !visited[nextPerson[0]]){
                        pq.add(nextPerson);
                    }
                }
            }
        }
    }
}