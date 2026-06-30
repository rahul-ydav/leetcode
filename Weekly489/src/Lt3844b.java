class Lt3844b {
    public int almostPalindromic(String s) {

        int n = s.length();
        int maxRes = 1;
        for(int i=0; i<n; i++){

            int res = finder(s, n, i, i);
            maxRes = Math.max(res, maxRes);
            res = finder(s, n, i, i+1);
            maxRes = Math.max(res, maxRes);
        }

        return maxRes;
    }

    int finder(String s, int n, int l, int r){
        int res = 1;
        while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        if(l>=0 && r<n){
            int l1 = l-1;
            int r1 = r;
            while(l1>=0 && r1<n && s.charAt(l1)==s.charAt(r1)){
                l1--;
                r1++;
            }
            int l2 = l;
            int r2 = r+1;
            while(l2>=0 && r2<n && s.charAt(l2)==s.charAt(r2)){
                l2--;
                r2++;
            }

            res = Math.max(r2-l2-1, r1-l1-1);
        }
        else{
            res = r-l;
            if(l==-1 && r==n) res--;
        }
        return res;
    }
}