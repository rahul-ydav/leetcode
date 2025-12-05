import java.util.ArrayList;

public class Second {
    public String answerString(String word, int numFriends) {
        if(numFriends==1)   return word;
        char maxChar = 'a';
        ArrayList<Integer> charIdx = new ArrayList<>();
        for(int i=0; i<word.length(); i++){
            int comp = Character.compare(maxChar, word.charAt(i));
            if(comp<0){
                maxChar = word.charAt(i);
                charIdx = new ArrayList<>();
                charIdx.add(i);
            }
            else if(comp==0){
                charIdx.add(i);
            }
        }
        numFriends--;
        String resString = "";
        for(Integer cIdx : charIdx){
            String currString = maxString(numFriends, word, cIdx);

            if(resString.compareTo(currString)<0){
                resString = currString;
            }
        }
        return resString;
    }

    String maxString(int numFriends, String word, int charIdx){
        if((charIdx)-numFriends>0){
            return word.substring(charIdx);
        }
        numFriends = numFriends-charIdx;

        return word.substring(charIdx, word.length()-numFriends);
    }
}
