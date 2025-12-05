class Lt522 {
    public int findLUSlength(String[] strs) {

        int n = strs.length;
        int mx = -1;
        for(int i=0; i<n; i++){
            int len = strs[i].length();
            for(int j=0; j<n; j++){
                if(i!=j){
                    if(compare(strs[i], strs[j])){
                        j = n;
                        len = -1;
                    }
                }
            }
            mx = Math.max(len, mx);
        }

        return mx;
    }

    boolean compare(String a, String b){

        int al = a.length();
        int bl = b.length();
        if(al>bl){
            return false;
        }

        int j=0;
        while(j<bl-al){

            boolean found = true;
            int i=0;
            while(i<al){
                if(a.charAt(i)!=b.charAt(i+j)){
                    found = false;
                    i = al;
                }
                i++;
            }
            if(found)   return true;
            j++;
        }

        return false;
    }
}