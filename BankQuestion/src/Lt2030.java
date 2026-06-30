import java.util.Stack;

class Lt2030 {
    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        int n = s.length();

        int skipAlpha = n-k;
        int skipLetter = 0;
        int letterCount = 0;

        char[] chars = s.toCharArray();

        for(char ch: chars){
            if(ch==letter)  letterCount++;
        }
        skipLetter = letterCount - repetition;




        Stack<Character> st = new Stack<>();

        for(char ch: chars){

            while(!st.isEmpty() && skipAlpha>0 && (skipLetter>0 || st.peek()!=letter) && st.peek()>ch){
                skipAlpha--;
                if(st.peek()==letter){
                    skipLetter--;
                }
                st.pop();
            }
            st.push(ch);
        }

        StringBuilder res = new StringBuilder();

        while(!st.isEmpty()){
            res.append(st.pop());
        }

        res = res.reverse();

        System.out.println("res0: "+res.toString());

        int currLetterCount = 0;
        for(int i=0; i<res.length(); i++){
            if(res.charAt(i)==letter){
                currLetterCount++;
            }
            if(currLetterCount==repetition){

                if(k>=i+1){
                    res.setLength(k);
                }
                else{
                    res.setLength(i+1);
                    System.out.println("res1: "+res.toString());
                    int rem = k - (res.length()-i);
                    for(int j=i-1; j>=0; j--){
                        if(res.charAt(j)!=letter){
                            res.setCharAt(j, '#');
                            rem--;
                        }
                        if(rem==0)  break;
                    }
                }
                break;
            }
        }

        int write = 0;

        for(int read = 0; read<res.length(); read++){

            char ch = res.charAt(read);
            if(ch!='#'){
                res.setCharAt(write++, ch);
            }
        }
        res.setLength(write);

        return res.toString();
    }
}
