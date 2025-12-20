class Third2 {
    public long minMoves(int[] b) {
        int n = b.length;
        long res = 0;

        long sum = 0;
        int neg =-1;
        for(int i=0; i<n; i++){
            if(b[i]<0){
                neg = i;
            }
            sum = sum + (long)b[i];
        }
        if(sum<0){
            return -1;
        }
        if(neg==-1) return 0;

        int k=1;
        while(b[neg]<0){
            int l = (neg-k+n)%n;
            int r = (neg+k)%n;

            if(b[l]+b[neg]>0){
                res+=-1*(k)*b[neg];
                b[neg] = 0;
            }
            else{
                res+=k*b[l];
                b[neg] = b[neg] - b[l];
            }

            if(b[r]+b[neg]>0){
                res+=-1*(k)*b[neg];
                b[neg] = 0;
            }
            else{
                res+=k*b[r];
                b[neg] = b[neg] - b[r];
            }
            k++;
        }

        return res;
    }
}