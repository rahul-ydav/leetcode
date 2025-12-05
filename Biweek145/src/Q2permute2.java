import java.util.ArrayList;
import java.util.List;

public class Q2permute2 {
    private boolean[] used;
    private int K;
    private int minTime = Integer.MAX_VALUE;
    public int findMinimumTime(List<Integer> strength, int K) {
        this.used = new boolean[strength.size()];
        this.K = K;
        backTrack(strength, 1, 0, 0);

        return this.minTime;
    }

    private void backTrack(List<Integer> A, int currX, int idx, int currTime){

        if(idx==A.size()){
            minTime = Math.min(minTime, currTime);
            return;
        }
        for(int i=0; i<A.size(); i++){
            if(used[i]) continue;
            int newTime = (currTime+currX-1)/currX;
            if(newTime>=minTime) continue;
            used[i] = true;
            backTrack(A, currX+this.K, idx+1, newTime);
            used[i] = false;
        }

    }
}
