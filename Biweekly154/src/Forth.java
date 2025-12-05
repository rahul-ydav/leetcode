import java.util.*;

public class Forth {

    public int[] treeQueries(int n, int[][] B, int[][] queries) {
        int len = 0;
        for(int i=0; i<queries.length; i++){
            if(queries[i].length==2)    len++;
        }
        int[] res = new int[len];

        Graph1 g = new Graph1(n, B);

        for(int i=0; i<queries.length; i++){
            if(queries[i].length==2){
                res[i] = g.djx(1, queries[i][1]);
            }
            else{
                ArrayList<Pair> adjacentNodes = g.edges.getOrDefault(queries[i][1], new ArrayList<>());
                Pair p = new Pair(queries[i][2], queries[i][3]);
                adjacentNodes.add(p);
                g.edges.put(queries[i][1], adjacentNodes);

                ArrayList<Pair> adjacentNodes2 = g.edges.getOrDefault(queries[i][2], new ArrayList<>());
                Pair p2 = new Pair(queries[i][1], queries[i][3]);
                adjacentNodes2.add(p2);
                g.edges.put(queries[i][2], adjacentNodes2);
            }
        }

        return res;
    }

    public static class Graph1 {
        int nodes;
        Map<Integer, ArrayList<Pair>> edges = new HashMap<>();
        public int[] visited;

        Graph1(int n, int[][] B){
            nodes = n;

            visited = new int[n+1];

            for(int i=0; i<B.length; i++){
                ArrayList<Pair> adjacentNodes = this.edges.getOrDefault(B[i][0], new ArrayList<>());
                Pair p = new Pair(B[i][1], B[i][2]);
                adjacentNodes.add(p);
                edges.put(B[i][0], adjacentNodes);

                ArrayList<Pair> adjacentNodes2 = this.edges.getOrDefault(B[i][1], new ArrayList<>());
                Pair p2 = new Pair(B[i][0], B[i][2]);
                adjacentNodes2.add(p2);
                edges.put(B[i][1], adjacentNodes2);
            }

        }

        public int djx(int startNode, int endNode){

            PriorityQueue<Pair> p = new PriorityQueue<>((a, b) -> a.w - b.w );
            ArrayList<Integer> dist = new ArrayList<>(Collections.nCopies(nodes, Integer.MAX_VALUE));

            p.add(new Pair(startNode, 0));
            dist.set(startNode, 0);

            while(!p.isEmpty()){
                Pair currPair = p.poll();
                visited[currPair.n] = 1;

                if(currPair.n == endNode)    break;

                ArrayList<Pair> currArr = edges.get(currPair.n);
                if (currArr == null) return 0;
                for(Pair pair: currArr){
                    if(dist.get(pair.n)> (dist.get(currPair.n) + pair.w) && visited[pair.n]==0){

                        dist.set(pair.n, dist.get(currPair.n) + pair.w);
                        p.add(new Pair(pair.n, dist.get(pair.n)));
                    }

                }
            }
            return dist.get(endNode);
        }
    }

    public static class Pair{
        public int n;
        public int w;
        Pair(int node, int weight){
            n = node;
            w = weight;
        }
    }
}
