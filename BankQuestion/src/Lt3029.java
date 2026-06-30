import java.util.Arrays;

class Lt3029 {
    int[] calculateZ(String s){

        int n = s.length();
        int left = 0;
        int right = 0;
        int[] zArr = new int[n];
        for(int k=1; k<n; k++){
            if(k>right){
                left = right = k;
                while(right<n && s.charAt(right-left)==s.charAt(right)){
                    right++;
                }
                zArr[k] = right-left;
                right--;
            }
            else{
                if(zArr[k-left]<right-k+1){
                    zArr[k] = zArr[k-left];
                }
                else{
                    left = k;
                    while(right<n && s.charAt(right-left)==s.charAt(right)){
                        right++;
                    }
                    zArr[k] = right-left;
                    right--;
                }
            }
        }

        return zArr;
    }
    public int minimumTimeToInitialState(String word, int k) {

        int n = word.length();

        if(k==1){
            for(int i=1; i<n; i++){
                if(word.charAt(i)==word.charAt(0))    return i;
            }

            return n;
        }
        int[] zArr = calculateZ(word);

        System.out.println(Arrays.toString(zArr));

        for(int i=1; i<n; i++){
            if(zArr[i]+i>=n){
                return (int)Math.ceil(i/k);
            }
        }

        // return (n + k - 1) / k;
        // return (int)Math.ceil(n/k);
        return n/k;

    }
}