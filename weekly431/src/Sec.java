import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sec {
    public long calculateScore(String s) {
        long res = 0;

        Map<Character, ArrayList<Integer>> mp = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            int mir = s.codePointAt(i) - 97;
            char ch = (char) (122-mir);

            ArrayList<Integer> mir2Arr = mp.getOrDefault(ch, new ArrayList<>());
            if(!mir2Arr.isEmpty()){
                int mir2 = mir2Arr.remove(mir2Arr.size()-1);
                res+= i-mir2;
                mp.put(ch, mir2Arr);
            }
            else{
                ArrayList<Integer> currArr = mp.getOrDefault(s.charAt(i), new ArrayList<>());
                currArr.add(i);
                mp.put(s.charAt(i), currArr);
            }
        }
        return res;
    }
}
