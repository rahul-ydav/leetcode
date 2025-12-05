import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Jan27 {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> result =  new ArrayList<>();

        Graph g = new Graph(numCourses, prerequisites);
        for(int i=0; i<queries.length; i++){
            result.add(g.dfs(queries[i][0], queries[i][1]));
            g.visited = new int[numCourses+1];
        }
        return result;
    }
    public class Graph{
        private int nodes;
        public int[] visited;
        private HashMap<Integer, ArrayList<Integer>> edges = new HashMap<>();

        Graph(int n, int[][] B){
            nodes = n;

            visited = new int[nodes+1];

            for(int i=0; i<B.length; i++){
                ArrayList<Integer> adjacentNodes = this.edges.getOrDefault(B[i][0], new ArrayList<>());
                adjacentNodes.add(B[i][1]);
                edges.put(B[i][0], adjacentNodes);
            }
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
