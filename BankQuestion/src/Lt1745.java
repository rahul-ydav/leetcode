public class Lt1745 {
    String s;
    public boolean checkPartitioning(String s) {

        int n = s.length();
        this.s = s;

        for(int i=0; i<n; i++){
            if(isPalindrome(0, i+1)){
                for(int j=i+1; j<n; j++){
                    if(isPalindrome(i+1, j+1) && isPalindrome(j+1, n)){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    boolean isPalindrome(int start, int end){
        end--;
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
