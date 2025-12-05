import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Router {
    int memoryLimit;

    Queue<int[]> q;
    Set<String> st;
    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        q = new LinkedList<>();
        st = new HashSet<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        String key = keyMake(source) + keyMake(destination) + keyMake(timestamp);

        if(st.contains(key))    return false;
        if(q.size()>=memoryLimit){
            int[] first = q.poll();
            String key1 = keyMake(first[0]) + keyMake(first[1]) + keyMake(first[2]);
            st.remove(key1);
        }
        int[] packet = {source, destination, timestamp};
        q.add(packet);
        st.add(key);
        return true;
    }

    public int[] forwardPacket() {
        if(q.isEmpty()){
            return new int[0];
        }
        int[] first = q.poll();
        String key1 = keyMake(first[0]) + keyMake(first[1]) + keyMake(first[2]);
        st.remove(key1);
        return first;
    }

    public int getCount(int destination, int startTime, int endTime) {
        int res = 0;
        for(int[] item : q){
            if(item[1] == destination && item[2]>=startTime && item[2]<=endTime)    res++;
        }
        return res;
    }

    private String keyMake(int val){
        StringBuilder res = new StringBuilder(""+val);
        while(res.length()<10){
            res.insert(0, "0");
        }

        return res.toString();
    }
}