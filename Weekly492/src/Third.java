class Third {
    public int minOperations(String s) {

        int n = s.length();
        int mx = 0;
        int mxc = 0;
        int mn = 25;
        int mnc = 0;


        boolean isAscend = true;
        for(int i=0; i<n; i++){
            int curr = s.charAt(i) - 'a';
            if(i>0 && s.charAt(i)<s.charAt(i-1)){
                isAscend = false;
            }
            if(curr<mn){
                mn = curr;
                mnc = 1;
            }
            else if(curr==mn){
                mnc++;
            }
            if(curr>mx){
                mx = curr;
                mxc = 1;
            }
            else if(curr==mx){
                mxc++;
            }
        }

        if(isAscend) return 0;

        if(s.charAt(0)-'a'==mn || s.charAt(n-1)-'a'==mx){
            return 1;
        }
        if(s.charAt(0)-'a'==mx && s.charAt(n-1)-'a'==mn){
            if(n==2) return -1;
            if(mxc == 1 && mnc ==1) return 3;
        }

        return 2;

    }
}