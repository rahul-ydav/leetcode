import java.util.*;

public class Lt210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new ArrayList[numCourses];

        int[] inDegree = new int[numCourses];

        for(int i=0; i<numCourses; i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] pre : prerequisites){
            adj[pre[1]].add(pre[0]);
            inDegree[pre[0]]++;
        }

        for(int i=0; i<numCourses; i++){
            int[] v = new int[numCourses];
            if(findCycle(adj, i, v))   return new int[0];
        }


        boolean[] vis = new boolean[numCourses];
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<numCourses; i++){
            if(inDegree[i]==0)   continue;
            q.add(i);
            vis[i] = true;
        }
        int i=0;
        int[] order = new int[numCourses+100];
        Arrays.fill(order, -1);
        while(!q.isEmpty()){
            int val = q.poll();

            order[i] = val;
            i++;

            for(int nextCourse : adj[val]){
                inDegree[nextCourse]--;
                if(inDegree[nextCourse]==0){
                    q.add(nextCourse);
                }
            }
        }

        return order;

    }

    boolean findCycle(List<Integer>[] adj, int node, int[] vis){

        if(vis[node]==1)    return true;
        if(vis[node]==2)    return false;

        vis[node] = 1;

        for(int next : adj[node]){
            if(findCycle(adj, next, vis))   return true;
        }

        vis[node] = 2;

        return false;
    }
}