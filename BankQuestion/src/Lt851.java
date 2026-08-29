import java.util.*;

class Lt851 {
    public int[] loudAndRich(int[][] richer, int[] quiet) {

        int n = quiet.length;
        List<Integer>[] adj = new ArrayList[n];
        int[] indegree = new int[n];
        int[] inv = new int[n];

        for(int i=0; i<n; i++){
            adj[i] = new ArrayList<>();
            inv[quiet[i]] = i;
        }



        for(int[] r : richer){
            adj[r[0]].add(r[1]);
            indegree[r[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<n; i++){
            if(indegree[i]==0){
                q.add(i);
                // System.out.print(i+", ");
            }
        }

        int[] res = new int[n];
        Arrays.fill(res, n);


        while(!q.isEmpty()){
            int node = q.poll();
            // res[node] = Math.min(quiet[res[node]], quiet[node]);
            if(res[node]==n || quiet[res[node]]>quiet[node]){
                res[node] = node;
            }

            System.out.println(Arrays.toString(res));

            for(int next : adj[node]){
                indegree[next]--;
                // res[next] = Math.min(res[next], quiet[node]);
                if(res[next]==n || quiet[res[next]]>quiet[node]){
                    res[next] = node;
                }
                if(indegree[next]==0){
                    q.add(next);
                }
            }
        }

        return res;
    }
}