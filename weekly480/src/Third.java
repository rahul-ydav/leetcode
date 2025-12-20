import java.util.ArrayList;

public class Third {
    public long minMoves(int[] b) {
        int n = b.length;
        long res = 0;

        long sum = 0;
        int mx =0;
        for(int i=0; i<n; i++){
            if(b[i]>b[mx]){
                mx = i;
            }
            sum = sum + (long)b[i];
        }
        if(sum<0){
            return -1;
        }

        int l=mx;
        int r=mx;
        long s = (long)b[mx];
        int len=1;
        long ns = 0;
        while(len<=n){
            int l2 = (l-1+n)%n;
            int r2 = (r+1)%n;

            if(b[l2]+s>=0){
                s+=b[l2];
                if(b[l2]<0) {
                    int val = b[l2];
                    b[l2] = 0;
                    int i = 0;
                    int lk = 1;
                    while (lk<=len && val < 0) {
                        if (b[i] + val > 0) {
                            ns += -1 *lk * val;
                            b[i] = b[i] + val;
                            val = 0;
                        } else {
                            ns += lk* b[i];
                            val = val + b[i];
                            b[i] = 0;
                        }
                        i = (i + 1) % n;
                        lk++;
                    }
                }
                l = l2;
                len++;
            }

            if(l2==r2)  break;

            if(b[r2]+s>=0) {
                s += b[r2];
                if (b[r2] < 0) {
                    int val = b[r2];
                    b[r2] = 0;
                    int i = r;
                    int rk = 1;
                    while ( val < 0 && rk<=len) {
                        if (b[i] + val > 0) {
                            ns += -1*(rk) * val;
                            val = 0;
                            b[i] = b[i] + val;
                        } else {
                            ns += (rk) * b[i];
                            val = val +b[i];
                            b[i] = 0;
//                            arr.set(i, 0);
                        }
                        i = (i-1+n)%n;
                        rk++;
                    }
//                    arr.add(0);
                    b[r2] = 0;
                }

                r = r2;
                len++;
            }
        }

        return ns;

//        return finder(b, arr, mx, mx, (long)b[mx]);
    }
}
