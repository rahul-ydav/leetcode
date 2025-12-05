class Lt1012 {
    public int numDupDigitsAtMostN(int n) {
        String s = Integer.toString(n);
        int len = s.length();
        int res =0;

        int[] mult = new int[10];
        mult[0] = 1;
        mult[1] = 9;
        for(int i=8; i>0; i--){
            mult[10-i] = mult[10-i-1]*(i);
        }

        for(int i=1; i<len; i++){
            res = res + 9*mult[i-1];
        }


        for(int i=0; i<len; i++){
            int digit = s.charAt(i) - '0';
            // if(digit>0){
            if(i==0) {
                res = res + (digit-1)*(mult[len-i-1]);
            }
            else{
                int cnt = s.charAt(i) - '0';
                boolean[] present = new boolean[cnt+1];
                for(int j=0; j<i; j++){
                    int sdigit = s.charAt(j) - '0';
                    if(sdigit<=cnt){
                        present[sdigit] = true;
                    }
                }
                int notPresent = 0;
                for(int j=0; j<=cnt; j++){
                    if(!present[j])  notPresent++;
                }
                res = res + notPresent*(mult[len-i-1]);
            }
            // }
        }

        res = n - res;

        return res;
    }
}