import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SafeStates {
    int[][] g;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        g = graph;
        HashSet<Integer> res = new HashSet<>();
        for(int i=0; i<graph.length; i++){
            int[] visited = new int[graph.length];
            if(dfs(i, visited, res)){
                // return res;
                List<Integer> ans = new ArrayList<>();
                for(int node=0; node<graph.length; node++){
                    if(!res.contains(node))    ans.add(node);
                }
                return ans;

            }

        }
        return new ArrayList<Integer>();
    }

    boolean dfs(int currNode, int[] visited, HashSet<Integer> cycle){
        visited[currNode] = 1;

        cycle.add(currNode);

        if(g[currNode]==null)  return false;
        boolean delete = true;
        for(int i=0; i<g[currNode].length; i++){
            int node = g[currNode][i];
            if(visited[node]==1)    delete = false;
            else if(dfs(node, visited, cycle))    delete = false;
        }

        if(delete) cycle.remove(cycle.size()-1);

        return false;
    }
}
