class Second2 {

    long[][][] memo;

    public long maximumProfit(int[] prices, int k) {
        memo = new long[prices.length+1][k+1][3];
        return finder(prices, k, 0, 0);

    }

    long finder(int[] prices, int k, int idx, int state){
        if(memo[idx][k][state]!=0){
            return memo[idx][k][state];
        }

        if(k==0 || idx==prices.length){
            return (state ==0) ? 0 : Integer.MIN_VALUE;
        }

        long mx = 0;

        mx = finder(prices, k, idx+1, state);

        if(state==0){
            mx = Math.max(mx, finder(prices, k, idx+1, 1) - prices[idx]);
            mx = Math.max(mx, finder(prices, k, idx+1, 2) + prices[idx]);

        }
        else if(state==1){
            mx = Math.max(mx, finder(prices, k-1, idx+1, 0) + prices[idx]);
        }
        else if(state==2){
            mx = Math.max(mx, finder(prices, k-1, idx+1, 0) - prices[idx]);
        }

        memo[idx][k][state]=mx;
        return mx;
    }
}