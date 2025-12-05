import java.util.Stack;

public class RemoveKdigits402 {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();

        int bidx = 0;
        for(int i=0; i<num.length(); i++){
            char ch = num.charAt(i);
            if(!st.isEmpty() && ch-'0'<st.peek()-'0'){
                st.pop();
                k--;
            }
            st.add(ch);

            if(k==0){
                bidx = i;
                break;
            }

        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        if(bidx>0)  sb.append(num.substring(bidx+1));
        else return "0";

        while(sb.length()>1 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }


        return sb.toString();
    }
}
