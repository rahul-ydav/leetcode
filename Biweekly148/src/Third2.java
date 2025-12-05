import java.util.*;

public class Third2 {

    public int[] longestSpecialPath(int[][] edges, int[] nums) {

        Graph g = new Graph(edges, nums);
//        HashSet<Integer> st = new HashSet<>();
        Deque<ArrayList<Integer>> dq = new LinkedList<>();
        g.dfs(0, dq, 0);

        int[] res = new int[2];
        res[0] = g.maxLength;
        if(res[0]==Integer.MIN_VALUE)   res[0] = 0;
        res[1] = (g.minNodes==Integer.MAX_VALUE) ? 1 : g.minNodes;
        return res;
    }

    public class Graph{
        private int nodes;

        int[] values;

        private int[] visited;
        public int maxLength = Integer.MIN_VALUE;
        public int minNodes = Integer.MAX_VALUE;
        private HashMap<Integer, ArrayList<ArrayList<Integer>>> edges = new HashMap<>();

        Graph(int[][] B, int[] nums){
            nodes = B.length+1;

            visited = new int[nodes+1];
            values = nums;

            for(int i=0; i<B.length; i++){
                ArrayList<ArrayList<Integer>> adjacentNodes = this.edges.getOrDefault(B[i][0], new ArrayList<>());
                ArrayList<Integer> edgeData = new ArrayList<Integer>();
                edgeData.add(B[i][1]);
                edgeData.add(B[i][2]);
                adjacentNodes.add(edgeData);
                edges.put(B[i][0], adjacentNodes);

                ArrayList<ArrayList<Integer>> adjacentNodes2 = this.edges.getOrDefault(B[i][1], new ArrayList<>());
                ArrayList<Integer> edgeData2 = new ArrayList<Integer>();
                edgeData2.add(B[i][0]);
                edgeData2.add(B[i][2]);
                adjacentNodes2.add(edgeData2);
                edges.put(B[i][1], adjacentNodes2);
            }
        }

        void dfs(int currNode, Deque<ArrayList<Integer>> dq, int length){
            visited[currNode] = 1;

            set.add(values[currNode]);

            if(dq.size()>1){
                if(length==maxLength){
                    if(dq.size()<minNodes){
                        maxLength= length;
                        minNodes = dq.size();
                    }
                }
                else if(length>maxLength){
                    maxLength= length;
                    minNodes = dq.size();
                }
            }

            for(ArrayList<Integer> nodeData : edges.get(currNode)){
                if(visited[nodeData.get(0)]==0){
                    if(dq.peekFirst()==values[nodeData.get(0)]){
                        dfs(nodeData.get(0), dq, length+nodeData.get(1));
                    }
                    else{
                        HashSet<Integer> set2 = new HashSet<>();
//                        set2.add(values[currNode]);
                        dfs(nodeData.get(0), dq, 0);
                    }
                }
            }
            dq.remove(values[currNode]);
        }
    }

}
