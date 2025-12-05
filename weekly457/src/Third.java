import java.util.*;

public class Third {
    public int minTime(int n, int[][] B, int k){
        Graph g = new Graph(n, B);

        int comps = 0;
        for(int i=0; i<n; i++){
            if(g.visited[i]==0){
                comps++;
                g.bfs(i);
            }
        }

        Arrays.sort(B, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b){
                return Integer.compare(a[2], b[2]);
            }
        });
        if(comps==k)    return 0;

        for(int i=0; i<B.length; i++){
            Arrays.fill(g.visited, 0);
            g.remove(B[i][0], B[i][1]);
            if(!g.dfs(B[i][0], B[i][1])){
                comps++;
            }
            if(comps==k)    return B[i][2];
        }


        return -1;
    }

    public class Graph{
        private int nodes;

        private int[] visited;

        private HashMap<Integer, ArrayList<Integer>> edges = new HashMap<>();

        Graph(int n, int[][] B){
            nodes = n;

            visited = new int[n+1];

            for(int[] integers: B){
                ArrayList<Integer> adjacentNodes = this.edges.getOrDefault(integers[0], new ArrayList<>());
                adjacentNodes.add(integers[1]);
                edges.put(integers[0], adjacentNodes);

                ArrayList<Integer> adjacentNodes2 = this.edges.getOrDefault(integers[1], new ArrayList<>());
                adjacentNodes2.add(integers[0]);
                edges.put(integers[1], adjacentNodes2);
            }
        }

        void remove(int a, int b){
            ArrayList<Integer> adjacentNodes = this.edges.get(a);
            for(int i=0; i<adjacentNodes.size(); i++){
                if(adjacentNodes.get(i) == b) {
                    adjacentNodes.remove(i);
                    break;
                }
            }
            edges.put(a, adjacentNodes);

            ArrayList<Integer> adjacentNodes2 = this.edges.get(b);
            for(int i=0; i<adjacentNodes2.size(); i++){
                if(adjacentNodes2.get(i) == a) {
                    adjacentNodes2.remove(i);
                    break;
                }
            }
            edges.put(b, adjacentNodes2);
        }

        void bfs(int startNode){
            Queue<Integer> q = new LinkedList<>();
            visited[startNode] = 1;
            q.add(startNode);
            while(!q.isEmpty()){
                int currNode = q.remove();
                visited[currNode] = 1;


                //traversing
                if(edges.get(currNode)==null)   return;
                for(Integer node: edges.get(currNode)){
                    if(visited[node]==0){
                        q.add(node);
                    }
                }
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
