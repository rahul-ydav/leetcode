import java.util.*;

public class Third {

    public int minTime(int n, int[][] edges) {
        Graph1 g = new Graph1(n, edges);
        return g.djx(0);
    }


    public static class Graph1 {
        int nodes;
        Map<Integer, ArrayList<Pair>> edges = new HashMap<>();
        public int[] visited;

        Graph1(int A, int[][] B) {

            nodes = A;
            visited = new int[A];
            for (int[] integers : B) {
                ArrayList<Pair> ar1 = edges.getOrDefault(integers[0], new ArrayList<>());
                Pair p = new Pair(integers[1], integers[2], integers[3]);
                ar1.add(p);
                edges.put(integers[0], ar1);
            }
        }

        public int djx(int startNode){

            PriorityQueue<int[]> p = new PriorityQueue<>((a, b) -> a[1] - b[1] );

            p.add(new int[]{startNode, 0});

            while(!p.isEmpty()){
                int[] currNode = p.poll();

                if(currNode[0]==nodes-1)    return currNode[1];
                visited[currNode[0]] = 1;

                ArrayList<Pair> currArr = edges.get(currNode[0]);
                if (currArr == null) continue;
                for(Pair pair: currArr){
                    if(currNode[1]<=pair.e && visited[pair.n]==0){
                        System.out.println("time: "+(Math.max(currNode[1], pair.s)+1));
                        p.add(new int[]{pair.n, Math.max(currNode[1], pair.s)+1});
                    }
                }
            }
            return -1;
        }
    }

    public static class Pair{
        public int n;
        public int s;
        public int e;
        Pair(int node, int start, int end){
            n = node;
            s = start;
            e = end;
        }
    }
}
