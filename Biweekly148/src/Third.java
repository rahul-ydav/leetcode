//import java.util.*;
//
//public class Third {
//
//    public int[] longestSpecialPath(int[][] edges, int[] nums) {
//
//        Graph g = new Graph(edges, nums);
//        HashSet<Integer> st = new HashSet<>();
//        Deque<Integer> dq = new LinkedList<>();
//        g.dfs(new ArrayList<>(List.of(0, 0)), st, 0, dq);
//        int[] res = new int[2];
//        res[0] = g.maxLength;
//        if(res[0]==Integer.MIN_VALUE)   res[0] = 0;
//        res[1] = (g.minNodes==Integer.MAX_VALUE) ? 1 : g.minNodes;
//        return res;
//    }
//
//    public class Graph{
//        private int nodes;
//
//        int[] values;
//
//        private int[] visited;
//        public int maxLength = Integer.MIN_VALUE;
//        public int minNodes = Integer.MAX_VALUE;
//        private HashMap<Integer, ArrayList<ArrayList<Integer>>> edges = new HashMap<>();
//
//        Graph(int[][] B, int[] nums){
//            nodes = B.length+1;
//
//            visited = new int[nodes+1];
//            values = nums;
//
//            for(int i=0; i<B.length; i++){
//                ArrayList<ArrayList<Integer>> adjacentNodes = this.edges.getOrDefault(B[i][0], new ArrayList<>());
//                ArrayList<Integer> edgeData = new ArrayList<Integer>();
//                edgeData.add(B[i][1]);
//                edgeData.add(B[i][2]);
//                adjacentNodes.add(edgeData);
//                edges.put(B[i][0], adjacentNodes);
//
//                ArrayList<ArrayList<Integer>> adjacentNodes2 = this.edges.getOrDefault(B[i][1], new ArrayList<>());
//                ArrayList<Integer> edgeData2 = new ArrayList<Integer>();
//                edgeData2.add(B[i][0]);
//                edgeData2.add(B[i][2]);
//                adjacentNodes2.add(edgeData2);
//                edges.put(B[i][1], adjacentNodes2);
//            }
//        }
//
//        void dfs(ArrayList<Integer> currNode, HashSet<Integer> set, int length, Deque<Integer> dq){
//            visited[currNode.get(0)] = 1;
//
//            set.add(values[currNode.get(0)]);
//
//            //
////            if(length+currNode.get(1)==k)
//
//            //leaf Node
//            if(currNode.get(0)!=0 && edges.get(currNode.get(0)).size()==1){
//                if(length>=maxLength){
//                    if(set.size()<minNodes){
//                        maxLength= length;
//                        minNodes = set.size();
//                    }
//
//                }
//                return;
//            }
//            for(ArrayList<Integer> nodeData : edges.get(currNode.get(0))){
//                if(visited[nodeData.get(0)]==0  && !set.contains(values[nodeData.get(0)])){
//                    dfs(nodeData, set, length+nodeData.get(1));
//                }
//            }
//        }
//    }
//
//}
