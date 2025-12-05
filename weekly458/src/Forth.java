import java.util.ArrayList;
import java.util.HashMap;

class Forth {
    public int maxLen(int n, int[][] edges, String label) {

        Graphs g = new Graphs(n, edges, label);

        int res = 0;
        for(int i=0; i<n; i++){
            g.visited = new boolean[n];
            g.pLen = 0;

            g.dfs(i, new StringBuilder());

            res = Math.max(res, g.pLen);
        }

        return res;
    }


    class Graphs{

        int nodes;
        String label;
        boolean[] visited;
        int pLen = 0;

        HashMap<Integer, ArrayList<Integer>> edges = new HashMap<>();

        Graphs(int n, int[][] edge, String label){
            this.nodes = n;
            this.label = label;

            visited = new boolean[n];

            for(int[] integers : edge){
                ArrayList<Integer> adj = edges.getOrDefault(integers[0], new ArrayList<>());
                adj.add(integers[1]);
                edges.put(integers[0], adj);
            }

            for(int[] integers : edge){
                ArrayList<Integer> adj = edges.getOrDefault(integers[1], new ArrayList<>());
                adj.add(integers[0]);
                edges.put(integers[1], adj);
            }
        }

        void dfs(int node, StringBuilder str){
            visited[node] = true;

            str.append(label.charAt(node));

            if(str.length()>pLen && isPalindrome(str)){
                pLen = str.length();
            }

            if(edges.get(node)==null)  return;

            for(Integer val: edges.get(node)){
                if(!visited[val]){
                    dfs(val, str);
                }
            }

            visited[node] = false;
            str.deleteCharAt(str.length()-1);
        }

        boolean isPalindrome(StringBuilder s){
            int len = s.length();

            for(int i=0; i<len/2; i++){
                if(s.charAt(i)!=s.charAt(len-1-i)){
                    return false;
                }
            }

            return true;
        }
    }

}