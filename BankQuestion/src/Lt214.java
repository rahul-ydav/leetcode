import java.util.HashSet;

class Lt214 {
    public String shortestPalindrome(String s) {

        int n = s.length();
        HashSet<String> hs = new HashSet<>();
        // HashSet<Long> hs = new HashSet<>();

        long base = 27;
        long mod1 = 1000_000_007;
        long val1 = 0;
        long mod2 = 1000_000_009;
        long val2 = 0;

        long[] pows1 = new long[n+1];
        long[] pows2 = new long[n+1];
        pows1[0] = 1;
        pows2[0] = 1;
        for(int i=1; i<=n; i++){
            pows1[i] = (pows1[i-1]*base)%mod1;
            pows2[i] = (pows2[i-1]*base)%mod2;
        }


        for(int i=n-1; i>=0; i--){
            int charI = (s.charAt(i)-'a')+1;
            val1 = (val1*base + charI)%mod1;
            val2 = (val2*base + charI)%mod2;

            if(i<=n/2){
                long r1 = val1;
                long r2 = val2;
                for(int j=i+1; j<n; j++){
                    int charJ = (s.charAt(j)-'a')+1;
                    r1 = (r1*base + charJ)%mod1;
                    r2 = (r2*base + charJ)%mod2;
                }
                // long key = (r1<<32)^r2;
                String key = r1+"#"+r2;
                hs.add(key);
                StringBuilder sb = new StringBuilder(s.substring(i+1));
                String str = sb.reverse().toString() + s.substring(i);
                System.out.println("str1: "+ str +", Key: "+key);

                r1 = ((r1*base)%mod1 + (charI*pows1[n-i])%mod1)%mod1;
                r2 = ((r2*base)%mod2 + (charI*pows2[n-i])%mod2)%mod2;

                // key = (r1<<32)^r2;
                key = r1+"#"+r2;
                hs.add(key);
                sb = new StringBuilder(s.substring(i));
                str = sb.reverse().toString() + s.substring(i);
                System.out.println("str2: "+ str +", Key: "+key);
            }
        }


        // if(hs.contains((val1<<32)^val2)){
        //     return s;
        // }

        long r1 = 0;
        long r2 = 0;

        for(int i=n-1; i>=0; i--){
            val1 = (val1*base)%mod1;
            val2 = (val2*base)%mod2;

            int charI = (s.charAt(i)-'a')+1;
            r1 = (r1*base + charI)%mod1;
            r2 = (r2*base + charI)%mod2;
            long a1 = (r1 + val1)%mod1;
            long a2 = (r2 + val2)%mod2;

            // long key = (a1<<32)^a2;
            String key = a1+"#"+a2;
            StringBuilder sb = new StringBuilder(s.substring(i));
            String str = sb.reverse().toString() + s;
            System.out.println("str: "+ str +", Key: "+key);
            if(hs.contains(key)){
                return s.substring(i) + s;
            }
        }

        return s;
    }
}