import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Q2permute {
    public ArrayList<ArrayList<Integer>> allPermutations = new ArrayList<>();

    public int findMinimumTime(List<Integer> strength, int K) {

        findPermutes(strength, 0);

        int minTime = Integer.MAX_VALUE;
        for(ArrayList<Integer> arr: allPermutations){
            int totalTime = 0;
            for(int i=0; i< arr.size(); i++){
                int time = (int) Math.ceil((double) arr.get(i) /(1 + K*i));
                totalTime += time;
            }
            minTime = Math.min(minTime, totalTime);
        }
        return minTime;
    }
    public void findPermutes(List<Integer> A, int idx){
        HashSet<Integer> hs = new HashSet<>();
        for(int i=idx; i<A.size(); i++){
            if(!hs.contains(A.get(idx))) {
                hs.add(A.get(idx));
                findPermutes(A, idx + 1);
            }
            rotateSubArrayBy1(A, idx);
        }

        ArrayList<Integer> Anew = new ArrayList<>(A);
        if(idx==A.size())  allPermutations.add(Anew);
    }

    public void rotateSubArrayBy1(List<Integer> A, int idx){
        int firstVal = A.get(idx);
        for(int i= idx+1; i<A.size(); i++){
            A.set(i-1, A.get(i));
        }
        A.set(A.size()-1, firstVal);
    }
}
