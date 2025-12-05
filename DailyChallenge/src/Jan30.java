import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Jan30 {
    public int magnificentSets(int n, int[][] edges) {
        Graph g = new Graph(n, edges);
        for(int node=1; node<=n; node++){
//        for(int node : g.nodes){
            if(g.visited[node]==0 && !g.biPartCheck(node, 0)) return -1;
        }

        Arrays.fill(g.visited, 0);

        int allMax = 0;
        for(int node=1; node<=n; node++){
//        for(int node : g.nodes){
            if(g.visited[node]==0){
                int s = g.longestPath(node, new ArrayList<Integer>());
                allMax = allMax+s;
            }
        }
        return allMax;
    }
    public class Graph{
//        public HashSet<Integer> nodes = new HashSet<>();
        public int nodes;
        public int[] visited;
        int target;
        private HashMap<Integer, ArrayList<Integer>> edges = new HashMap<>();
        Graph(int n, int[][] B){
            nodes = n;

            visited = new int[n+1];

            for(int[] integers: B){
//                nodes.add(integers[0]);
                ArrayList<Integer> adjacentNodes = this.edges.getOrDefault(integers[0], new ArrayList<>());
                adjacentNodes.add(integers[1]);
                edges.put(integers[0], adjacentNodes);

//                nodes.add(integers[1]);
                ArrayList<Integer> adjacentNodes2 = this.edges.getOrDefault(integers[1], new ArrayList<>());
                adjacentNodes2.add(integers[0]);
                edges.put(integers[1], adjacentNodes2);
            }
        }


        boolean biPartCheck(int currNode, int lastVisit){
            visited[currNode] = (lastVisit)%2+1;

            if(edges.get(currNode)==null)   return true;
            for(Integer node : edges.get(currNode)){
                if(visited[node]==visited[currNode]){
                    return false;
                }
                if(visited[node]==0 && !biPartCheck(node, visited[currNode]))   return false;
            }
            return true;
        }

        int longestPath(int currNode, ArrayList<Integer> path){
            visited[currNode]=1;
            int maxPath = nodes+1;
            if(edges.get(currNode)==null)   return 1;
            path.add(currNode);
            for(Integer node : edges.get(currNode)){
                if(visited[node]==0){
                    maxPath = Math.min(maxPath, longestPath(node, path));
                }
            }
            path.remove(path.size()-1);
            if(maxPath==nodes+1)    return 1;
            return maxPath+1;
        }
    }
}
