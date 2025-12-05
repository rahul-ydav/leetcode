import java.util.ArrayList;

public class Second {
    ArrayList<ArrayList<Integer>> vals = new ArrayList<>(26);

    int[] dp;
    public int maxSubstrings(String word) {

        dp = new int[word.length()];

        for(int i=0; i<26; i++){
            vals.add(new ArrayList<>());
        }
        for(int i=0; i<word.length(); i++){
            int idx = word.charAt(i) - 'a';
            vals.get(idx).add(i);
        }

        int result = findMax(word, 0);
        return result;
    }

    public int findMax(String word, int pos){
        if(pos>word.length()-4)  return 0;

        if(dp[pos]!=0)  return dp[pos];

        int charVal = word.charAt(pos) - 'a';

        int idx = upperBound(vals.get(charVal), pos+3);

        int maxCount = 0;

        if(idx<vals.get(charVal).size()){
            for(int i=idx; i<vals.get(charVal).size(); i++){
                maxCount = Math.max(maxCount, findMax(word, vals.get(charVal).get(i)+1)+1);
            }
            maxCount = Math.max(maxCount, findMax(word, pos+1));
        }
        else maxCount = findMax(word, pos+1);

        dp[pos] = maxCount;

        return maxCount;
    }

    public int upperBound(ArrayList<Integer> arr, int val){

        int start = 0;
        int end = arr.size()-1;

        while(start<=end){
            int mid = start + (end-start)/2;

            if(arr.get(mid)==val) return mid;

            if(arr.get(mid)<val){
                start=mid+1;
            }
            else if(arr.get(mid)>val){
                end = mid-1;
            }
        }

        return start;
    }
}
