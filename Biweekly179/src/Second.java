class Second {
    final int mod = 1_000_000_007;
    long[] fact;
    long[] invFact;
    long power(long base, long exp) {
        long result = 1;
        base %= mod;

        while (exp > 0) {
            if ((exp & 1) == 1)
                result = (result * base) % mod;

            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }

    void init(int n) {
        fact = new long[n + 1];
        invFact = new long[n + 1];

        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % mod;
        }

        invFact[n] = power(fact[n], mod - 2);

        for (int i = n - 1; i >= 0; i--) {
            invFact[i] = (invFact[i + 1] * (i + 1)) % mod;
        }
    }

    long nCr(int n, int r) {
        if (r > n || r < 0) return 0;
        return (fact[n] * invFact[r] % mod * invFact[n - r] % mod) % mod;
    }
    public int countVisiblePeople(int n, int pos, int k) {


        init(n);
        long res = 0;
        for(int i=0; i<=k; i++){
            if(i<pos && n-1-pos>k-i){
                long val = (nCr(pos, i)*nCr(n-1-pos, k-i))%mod;
                res = (res+val)%mod;
            }
        }
        res = res*2;

        return (int)res;
    }
}
