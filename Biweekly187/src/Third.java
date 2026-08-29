class Third {
    public boolean[] transformStr(String s, String[] strs) {

        int n = s.length();
        int zeros = 0;
        int ones = 0;

        for(int i=0; i<n; i++){
            if(s.charAt(i)=='0'){
                zeros++;
            }
            else{
                ones++;
            }
        }

        boolean[] ans = new boolean[strs.length];

        for(int i=0; i<strs.length; i++){
            String str = strs[i];
            int sz = 0;
            int so = 0;
            for(char ch : str.toCharArray()){
                if(ch=='0') sz++;
                else if(ch=='1') so++;
            }
            if(zeros<sz || ones<so){
                continue;
            }
            // ans[i] = true;
            int req = ones-so;
            int cnt = 0;
            int canOne = 0;
            boolean possible = true;
            for(int j=0; j<n; j++){
                if(s.charAt(j)=='1') cnt++;
                if(str.charAt(j)=='?' && cnt>0){
                    canOne++;
                    cnt--;
                    req--;
                }
                else{
                    // possible = false;
                    break;
                }
            }

            if(req>0){
                possible = false;
            }
            ans[i] = possible;

        }

        return ans;
    }
}