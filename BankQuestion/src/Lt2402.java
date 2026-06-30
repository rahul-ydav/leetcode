import java.util.*;

class Lt2402 {
    public int mostBooked(int n, int[][] meetings) {

        int m = meetings.length;
        int[] meetCount = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) ->{
            if(a[0]==b[0])   return a[1]-b[1];
            return a[0] - b[0];
        });
        PriorityQueue<Integer> avroom = new  PriorityQueue<>((a,b) -> a-b);

        Arrays.sort(meetings, (a, b)-> a[0] - b[0]);

        for(int i=0; i<n; i++){
            avroom.add(i);
        }


        for(int i=0; i<m; i++){
            while(!pq.isEmpty() && pq.peek()[0]<=meetings[i][0]){
                int[] rem = pq.poll();
                avroom.add(rem[1]);
            }

            if(avroom.isEmpty()){
                int[] rem = pq.poll();
                pq.add(new int[]{meetings[i][1]+rem[0], rem[1]});
                meetCount[rem[1]]++;
            }
            else{
                int rm = avroom.poll();
                pq.add(new int[]{meetings[i][1], rm});
                meetCount[rm]++;
            }
        }

        int room = 0;
        for(int i=0; i<n; i++){
            if(meetCount[i]>meetCount[room]){
                room = i;
            }
        }

        return room;
    }
}