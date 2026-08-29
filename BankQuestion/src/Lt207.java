import java.util.*;
class Lt207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new ArrayList[numCourses];

        boolean[] start = new boolean[numCourses];
        Arrays.fill(start, true);

        for(int i=0; i<numCourses; i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] pre : prerequisites){
            adj[pre[1]].add(pre[0]);
            start[pre[0]] = false;
        }

        for(int i=0; i<numCourses; i++){
            int[] v = new int[numCourses];
            if(findCycle(adj, i, v))   return false;
        }


        boolean[] vis = new boolean[numCourses];
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<numCourses; i++){
            if(!start[i])   continue;
            q.add(i);
        }
        int cnt=0;
        while(!q.isEmpty()){
            int val = q.poll();
            cnt++;

            for(int nextCourse : adj[val]){
                if(!vis[nextCourse]){
                    vis[val] = true;
                    q.add(nextCourse);
                }
            }
        }
        if(cnt==numCourses) return true;

        return false;

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