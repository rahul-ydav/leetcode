import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Jan24 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ar = new ArrayList<Integer>();
        return ar;
    }


    public class Graph{
        private int nodes;

        private int[] visited;
        int target;
//        private HashMap<Integer, ArrayList<Integer>> edges = new HashMap<>();
        private int[][] edges;
        /*
        (1, 2),
        (4, 5),
        (3, 1)
        * */
        Graph(int n, int[][] B){
            nodes = n;

            visited = new int[n+1];

//            for(int[] integers: B){
//                ArrayList<Integer> adjacentNodes = this.edges.getOrDefault(integers.get(0), new ArrayList<>());
//                adjacentNodes.add(integers.get(1));
//                edges.put(integers.get(0), adjacentNodes);
//            }
            edges = B;

        }

        boolean dfs(int currNode){
            if(visited[currNode]==1)    return false;
            visited[currNode] = 1;

//            if(currNode==target)    return true;
            for(int i=0; i<edges[currNode].length; i++){
                if(dfs(edges[currNode][i]))   return true;
            }
            return false;
        }
    }
}
