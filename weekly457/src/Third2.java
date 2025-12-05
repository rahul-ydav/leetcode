import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Third2 {
    public int minTime(int n, int[][] B, int k){

        Graph g = new Graph(n);

        int comps = n;

        Arrays.sort(B, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b){
                return Integer.compare(a[2], b[2]);
            }
        });

        for(int i=B.length-1; i>=0; i--){

            boolean  ans = comps==k;
            comps--;
            if(g.edges.containsKey(B[i][0]) && g.edges.containsKey(B[i][1])){
                Arrays.fill(g.visited, 0);
                if(g.dfs(B[i][0], B[i][1])) comps++;
            }
            g.addEdge(B[i]);

            if(ans && comps<k)  return B[i][2];

        }
        return 0;
    }

    public class Graph {
        private int nodes;

        public int[] visited;

        public HashMap<Integer, ArrayList<Integer>> edges = new HashMap<>();

        Graph(int n) {
            nodes = n;

            visited = new int[n + 1];

        }

        void addEdge(int[] integers){
            ArrayList<Integer> adjacentNodes = this.edges.getOrDefault(integers[0], new ArrayList<>());
            adjacentNodes.add(integers[1]);
            edges.put(integers[0], adjacentNodes);

            ArrayList<Integer> adjacentNodes2 = this.edges.getOrDefault(integers[1], new ArrayList<>());
            adjacentNodes2.add(integers[0]);
            edges.put(integers[1], adjacentNodes2);
        }
        boolean dfs(int currNode, int target){
            if(visited[currNode]==1)    return false;
            visited[currNode] = 1;

            if(currNode==target)    return true;
            if(edges.get(currNode)==null)   return false;
            for(Integer node : edges.get(currNode)){
                if(dfs(node, target))   return true;
            }
            return false;
        }
    }
}
