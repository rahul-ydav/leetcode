public class QC1 {

    public static  String wordScramble(String[] words, String note){

        int[] mp = new int[26];

        for(int i=0;i<note.length();i++){
            mp[note.charAt(i)-'a']++;
        }
        for(int i=0; i<words.length; i++){
            boolean good = true;
            int[] curr = new int[26];
            for(int j=0; j<words[i].length(); j++){
                int idx = words[i].charAt(j)-'a';
                curr[idx]++;
                if(curr[idx]>mp[idx]){
                    good = false;
                    break;
                }

            }

            if(good){
                return words[i];
            }
        }
        return "-";
    }

    public static void main(String[] args) {
        String[] words = {"baby", "referee", "cat", "dada", "dog", "bird", "ax", "baz", "bgb"};
        String note1 = "ctay";
        String note2 = "bcanihjsrrrferet";
        String note3 = "tbaykkjlga";
        String note4 = "bbbblkkjbaby";
        String note5 = "dad";
        String note6 = "breadmaking";
        String note7 = "dadaa";

        System.out.println(wordScramble(words, note1));
        System.out.println(wordScramble(words, note2));
        System.out.println(wordScramble(words, note3));
        System.out.println(wordScramble(words, note4));
        System.out.println(wordScramble(words, note5));
        System.out.println(wordScramble(words, note6));
        System.out.println(wordScramble(words, note7));
    }
}
