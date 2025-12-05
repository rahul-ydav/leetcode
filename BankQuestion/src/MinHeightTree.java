import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinHeightTree {
//    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

//        int minHeight
//        for(int i=0; i<n; i++){
//            if()
//        }
//    }

    public class Graph{
        private int nodes;

        int[] visited;
        private HashMap<Integer, ArrayList<Integer>> edges = new HashMap<>();
        /*
        (1, 2),
        (4, 5),
        (3, 1)
        * */
        Graph(int n, int[][] B){
            nodes = n;

            visited = new int[n+1];

            for(int i=0; i<B.length; i++){
                ArrayList<Integer> adjacentNodes = this.edges.getOrDefault(B[i][1], new ArrayList<>());
                adjacentNodes.add(B[i][0]);
                edges.put(B[i][1], adjacentNodes);
            }

        }


        int dfs(int currNode, int[] order, int pos){
            visited[currNode] = 1;
            if(edges.get(currNode)==null){
                order[pos] = currNode;
                return pos-1;
            }
            for(Integer node : edges.get(currNode)){
                if(visited[node]==0){
                    pos = dfs(node, order, pos);
                }
            }
            order[pos] = currNode;
            return pos-1;
        }
    }
}
