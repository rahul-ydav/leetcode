import java.util.Stack;

public class Jan12 {
    public boolean canBeValid(String s, String locked) {
        Stack<Pair> st = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)==')'){
                if(!st.isEmpty() && st.peek().a=='('){
                    Pair top = st.peek();
                    st.pop();
                }
            }
            else{
                Pair p = new Pair(s.charAt(i), Integer.parseInt(String.valueOf(locked.charAt(i))));
                st.push(p);
            }
        }
        return st.size()==s.length();
    }

    public class Pair{
        char a;
        int b = -1;
        Pair(char a, int b){
            this.a = a;
            this.b = b;
        }
    }
}
