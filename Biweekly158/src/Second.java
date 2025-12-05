class Second {

    long[][] memo;

    public long maximumProfit(int[] prices, int k) {
        memo = new long[prices.length+1][k+1];
        return finder(prices, k, 0);
    }

    long finder(int[] prices, int k, int idx){

         if(memo[idx][k]!=0){
             return memo[idx][k];
         }


        if(k==0 || idx==prices.length){
            return 0;
        }

        long mx = 0;
        for(int i=idx; i<prices.length-1; i++){
            for(int j=i+1; j<prices.length; j++){
                mx = Math.max(mx, (long)(Math.abs(prices[j] - prices[i])) + finder(prices, k-1, j+1));
            }
        }
        memo[idx][k]=mx;
        return mx;
    }
}