import java.util.HashMap;

public class First {
    public String findValidPair(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            int x = hm.getOrDefault(ch, 0);
            hm.put(ch, x+1);
        }
        for(int i=0; i<s.length()-1; i++){
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(i+1);
            int v1 = ch1 - '0';
            int v2 = ch2 - '0';
            if(v1==hm.get(ch1) && v2==hm.get(ch2))  return s.substring(i, i+1);
        }
        return "";
    }
}
