class Lt3869 {

    public long countFancy(long l, long r) {

//        long b = finderInc(new StringBuilder(""+r), 0, true);
//        b += finderDec(new StringBuilder(""+r), 0, true);
//
//        long a = finderInc(new StringBuilder(""+l), 0, true);
//        a += finderDec(new StringBuilder(""+l), 0, true);

        long b = finderDec(new StringBuilder(""+r), 0, true);
        l--;
        long a = finderDec(new StringBuilder(""+l), 0, true);

        return b-a;

    }
    long finderInc(StringBuilder num, int idx, boolean tight){
        int digits = num.length();
        if(idx==digits){
            long val = Long.parseLong(num.toString());
            String ne = ""+val;
            System.out.println("ne: "+ne);
            if(val<10L)  return val;
            if(isGoodInc(ne)){
                return 1L;
            }
            int sum = 0;
            for(int i=0; i<ne.length(); i++){
                sum+=(ne.charAt(i) - '0');
            }
            if(isGoodInc(""+sum)){
                return 1L;
            }
            return 0L;
        }

        long res = 0;

        int mn = (idx==0) ? 0 : num.charAt(idx-1) - '0';
        int mx = num.charAt(idx) - '0';
        if(mn==mx)  return res;
        for(int i=mx; i>=mn; i--){
            num.setCharAt(idx, (char)('0'+i));
            res+=finderInc(num, idx+1, false);
        }

        return res;
    }

    boolean isGoodInc(String s){
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i)<=s.charAt(i-1)){
                return false;
            }
        }

        return true;
    }

    long finderDec(StringBuilder num, int idx, boolean tight){
        int digits = num.length();
        if(idx==digits){
            String ne = ""+Long.parseLong(num.toString());
            if(isGoodDec(ne)){
                return 1L;
            }
            int sum = 0;
            for(int i=0; i<ne.length(); i++){
                sum+=(ne.charAt(i) - '0');
            }
            if(isGoodDec(""+sum)){
                return 1L;
            }
            return 0L;
        }

        long res = 0;

//        int mx = (idx==0) ? 10 : num.charAt(idx-1) - '0';
        int mx = 10;
        if(tight){
            res += finderDec(num, idx+1, true);
            int curr = num.charAt(idx) - '0';
            mx = Math.min(mx, curr);
        }
        for(int i=mx-1; i>=0; i--){
            num.setCharAt(idx, (char)('0'+i));
            res+=finderDec(num, idx+1, false);
        }

        return res;
    }

    boolean isGoodDec(String s){
        if(s.length()==1)   return true;
        boolean inc = true;
        boolean dec = true;
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i)>=s.charAt(i-1))  dec =  false;
            if(s.charAt(i)<=s.charAt(i-1))  inc =  false;
        }

        return inc || dec;
    }
}