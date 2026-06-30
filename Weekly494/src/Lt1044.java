class Lt1044 {
    public String longestDupSubstring(String s) {

        int n = s.length();
        int res = 0;

        String str = "";

        for(int i=0; i<n-1; i++){
            int mxCount = 0;
            int count = 0;
            for(int j=i+1; j<n; j++){
                if(s.charAt(i + count)==s.charAt(j)){
                    count++;
                }
                else{
                    count=0;
                }
                mxCount = Math.max(mxCount, count);
            }
            if(mxCount>res){
                res = mxCount;
                str = s.substring(i, i+mxCount);
            }

        }

        return str;
    }
}