class Second {
    public long numOfSubsequences(String s) {

        int n = s.length();

        System.out.println("n: "+ n);

        int[] lcount = new int[n+1];
        int[] tcount = new int[n+1];

        long res = 0;

        for(int i=0; i<n; i++){
            if(s.charAt(i)=='L'){
                lcount[i+1] = lcount[i]+1;
            }
            else lcount[i+1] = lcount[i];
        }

        for(int i=n-1; i>=0; i--){
            if(s.charAt(i)=='T'){
                tcount[i] = tcount[i+1]+1;
            }
            else tcount[i] = tcount[i+1];
        }


        long maxProd = 0;
        int lccount = 0;
        int tccount = 0;

        int t=0;
        for(int i=0; i<n; i++){

            if(i>49996 && i<50004){
                System.out.println("lccount: "+lcount[i]+", tcount: "+tcount[i]);
            }
            if(s.charAt(i)=='L'){
                t = i;
                maxProd = (long)Math.max(maxProd, (long)((lcount[i]+1)*tcount[i]));
                if(i>49996 && i<50004){
                    System.out.println("maxProd1: "+maxProd);
                }
            }
            else if(s.charAt(i)=='T'){
                if(i>49996 && i<50004){
                    System.out.println("maxProd2: "+maxProd);
                }
                maxProd = (long)Math.max(maxProd, (long)(lcount[i]*(tcount[i])));
            }
            else if(s.charAt(i)=='C'){
                lccount+=lcount[i];
                tccount+=tcount[i];
                res+=lcount[i]*tcount[i];
                maxProd = Math.max(maxProd, (long)(lcount[i]*(tcount[i])));
            }
        }

        System.out.println("t:"+t);
        long r1 = (long)(t+1)*(n-(t+1));
        System.out.println("t2:"+r1+"maxProd: "+maxProd);

        int aMax = Math.max(lccount, tccount);
        res+=Math.max(aMax, maxProd);

        return res;
    }
}