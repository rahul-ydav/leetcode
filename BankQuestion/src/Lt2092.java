import java.util.*;

class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {

        Graph g = new Graph(n, meetings);

        List<Integer> res = g.djx(firstPerson);

        Collections.sort(res);

        return new ArrayList<>(new LinkedHashSet<>(res));
    }

    class Graph{

        int nodes;
//        Map<Integer, ArrayList<Pair>> edges = new HashMap<>();

        List<int[]>[] edges = new ArrayList[nodes];
        boolean[] visited;

        Graph(int n, int[][] B){
            nodes = n;

            visited = new boolean[n];

            for(int[] vals: B){
                edges[vals[0]].add(new int[]{vals[1], vals[2]});
                edges[vals[1]].add(new int[]{vals[0], vals[2]});
            }
        }

        List<Integer> djx(int startNode){

            List<Integer> res = new ArrayList<>();
            // res.add(0);
            int t=0;
            PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.w, b.w));
            pq.add(new Pair(0, 0));
            pq.add(new Pair(startNode, 0));

            while(!pq.isEmpty()){
                Pair p = pq.poll();

                visited[p.n] = true;
                res.add(p.n);
                if(edges[p.n]==null){
                    continue;
                }
                for(int[] nextPerson : edges[p.n])){
                    if(nextPerson[1]>=p.w && !visited[nextPerson.n]){
                        pq.add(nextPair);
                    }
                }
            }

            return res;

        }


    }

    class Pair{
        int n;
        int w;
        Pair(int n, int w){
            this.n = n;
            this.w = w;
        }
    }
}