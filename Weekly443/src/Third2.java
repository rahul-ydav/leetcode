class Third2 {
    public int longestPalindrome(String s, String t) {
        int sn = s.length();
        int tn = t.length();

        StringBuilder sb = new StringBuilder(t);
        t = sb.reverse().toString();

        if(s.compareTo(t)==0)  return sn+tn;


        int maxLen = 0;

        int comLen = 0;

        int l1 = findMaxPalindrome(s, sn);
        maxLen = Math.max(maxLen, l1);
        int l2 = findMaxPalindrome(t, tn);
        maxLen = Math.max(maxLen, l2);



        maxLen = Math.max(maxLen, comLen*2+1);

        return maxLen;
    }

    int findMaxPalindrome(String s, int len){
        int MaxRes = 0;
        for(int i=0; i<len; i++){
            int res = 0;
            int k = 1;

            while(i-k>=0 && i+k<len){
                if(s.charAt(i-k)!=s.charAt(i+k))    break;
                res++;
                k++;
            }

            MaxRes = Math.max(MaxRes, res*2+1);
            res = 0;
            if(i+1<len && s.charAt(i)==s.charAt(i+1)){
                k=0;
                while(i-k>=0 && i+1+k<len){
                    if(s.charAt(i-k)!=s.charAt(i+1+k))    break;
                    res++;
                    k++;
                }
            }
            MaxRes = Math.max(MaxRes, res*2);
        }
        return MaxRes;
    }
}