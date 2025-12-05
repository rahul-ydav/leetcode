import java.util.*;

public class Second {


    public int[] baseUnitConversions(int[][] conversions) {

        Graph1 g = new Graph1(conversions.length+1, conversions);

        g.bfs();

        return g.visited;
    }

    public static class Graph1 {
        final int mod = 1000000007;
        int nodes;
        Map<Integer, ArrayList<Pair>> edges = new HashMap<>();
        public int[] visited;

        Graph1(int A, int[][] B) {

            nodes = A;
            visited = new int[A];
            for (int[] integers : B) {
                ArrayList<Pair> ar1 = edges.getOrDefault(integers[0], new ArrayList<>());
                Pair p = new Pair(integers[1], integers[2]);
                ar1.add(p);
                edges.put(integers[0], ar1);
            }
        }

        void bfs(){
            Queue<Pair> q = new LinkedList<>();
            visited[0] = 1;
            q.add(new Pair(0, 0));
            while(!q.isEmpty()){
                Pair currNode = q.remove();

                if(!(edges.get(currNode.n)==null)) {
                    for (Pair node : edges.get(currNode.n)) {
                        if (visited[node.n] == 0) {
                            visited[node.n] = (int)((((long)(visited[currNode.n] % mod) * (long)(node.w % mod)) % mod);
                            q.add(node);
                        }
                    }
                }
            }
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
