public class First {
    boolean[] prime;
    public void sieve(int n) {
        //Sieve of Eratosthenes
        for (int i = 0; i <= n; i++)
            prime[i] = true;

        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }
    }

    public long sumOfLargestPrimes(String s) {
        int n = Integer.parseInt(s);
        prime = new boolean[n+1];
        sieve(n);

        long ans = 0;
        int count = 3;
        for(int i=n; i>0; i--){
            if(prime[i]){
                ans+=i;
                count--;
            }
            if(count==0)    break;
        }

        return ans;
    }
}
