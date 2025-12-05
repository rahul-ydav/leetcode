class Second {

    boolean isPalidrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low) != s.charAt(high))
                return false;
            low++;
            high--;
        }
        return true;
    }
    public int longestPalindrome(String s, String t) {
        int sn = s.length();
        int tn = t.length();

        int maxLen = 0;

        for(int i1=0; i1<sn; i1++){
            for(int j1=i1; j1<sn; j1++){
                int l1 = 0;
                if(isPalidrome(s, i1, j1)) {
                    l1 = j1 - i1 + 1;
                    maxLen = Math.max(maxLen, l1);
                }
                for(int i2=0; i2<tn; i2++){
                    StringBuilder sb = new StringBuilder(s.substring(i1, j1+1));
                    for(int j2=i2; j2<tn; j2++){
                        int l2 = 0;
                        if(isPalidrome(t, i2, j2)){
                            l2 = j2-i2+1;
                            maxLen = Math.max(maxLen, l2);
                        }
                        sb.append(t.charAt(j2));
                        if(isPalidrome(sb.toString(), 0, sb.length()-1)){
                            maxLen = Math.max(maxLen, sb.length());
                        }
                    }
                }
            }
        }

        return maxLen;
    }
}