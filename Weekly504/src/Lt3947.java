import java.util.Arrays;

class Lt3947 {
    public int maximumSaleItems(int[][] items, int budget) {

        int n = items.length;

        Arrays.sort(items, (int[] a, int[] b) -> a[1]-b[1]);

        int res = 0;
        for(int i=0; i<n; i++){
            int cnt=0;
            for(int j=0; j<n; j++){
                if(i!=j && items[j][0]%items[i][0]==0){
                    cnt++;
                }
            }
            if(cnt>0){
                int canGo = Math.min(budget/items[i][1], cnt);
                res+=canGo;
                budget = budget - canGo*items[i][1];

            }
        }
        System.out.println(budget);

        int rem = budget/items[0][1];

        return 2*res+rem;
    }
}