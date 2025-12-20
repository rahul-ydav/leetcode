public class Lt3352 {
        final int mod = 1000000007;
        public int countKReducibleNumbers(String s, int k) {


            int n = s.length();

            long[] memo = new long[n+1];
            long[] facts = new long[n+1];

            long res = 0;
            int preSum = 0;

            facts[0] = 1;
            for(int i=1; i<=n; i++){
                facts[i] = ((long)i*facts[i-1])%mod;
            }

            int sdm = 0;
            for(int i=0; i<n; i++) {
                if (s.charAt(i) == '1') sdm++;
            }

            for(int i=0; i<n-1; i++){
                if(s.charAt(i)=='1'){
                    for(int x=1; x<=n-i-1; x++){
                        int mIdx = preSum + x;
                        long div = (facts[x]*facts[n-i-1-x])%mod;
                        long count = (facts[n-i-1]/div)%mod;
                        memo[mIdx] = (memo[mIdx] + count)%mod;
                    }
                    preSum++;
                    if(preSum!=sdm) memo[preSum] = memo[preSum] + 1;
                }
            }

            int[] ctr = new int[n+1];
            for(int i=1; i<=n; i++){
                if(i<2){
                    res += memo[i];
                    ctr[i] = 1;
                    continue;
                }
                int digitSum = 0;
                int x = i;
                while(x>0){
                    if((x&1)==1){
                        digitSum++;
                    }
                    x=(x>>1);
                }
                ctr[i] = ctr[digitSum]+1;
                if(ctr[i]<=k){
                    res = (res + memo[i])%mod;
                }
            }

            return (int)res;


        }
    }
