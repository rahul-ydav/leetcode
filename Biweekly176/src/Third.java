class Third {
    public int almostPalindromic(String s) {


        int start = 0;
        int end = s.length()-1;

        while(start<end){
            int mid = (start+end)/2;
            if(isValid(s, mid)){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }

        return end;

    }

    boolean isValid(String s, int len){

        for(int x=0; x<s.length(); x++){
            int i = x-len;
            if(i<0) i = 0;

            for(int j=i; j<=x; j++){
                int start = j;
                int end = start + len-1;
                if(end>=s.length())  break;
                boolean found = true;
                while(start<end){
                    if(start==x) start++;
                    else if(end==x) end--;
                    if(s.charAt(start)!=s.charAt(end)){
                        found = false;
                        break;
                    }
                    start++;
                    end--;
                }
                if(found) return true;
            }

        }
        return false;
    }
}