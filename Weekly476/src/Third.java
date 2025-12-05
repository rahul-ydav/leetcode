import java.util.Arrays;

class Third {

    int[] ans;
    public int[] lexSmallestNegatedPerm(int n, long target) {
        ans = new int[n];
        Arrays.fill(ans, n);

        finder(n, target, 1, 0L, new int[n]);
        return ans;
    }

    void finder(int n, long target, int i, long sum, int[] arr){

        if(i>n){
            if(sum==target){
                Arrays.sort(arr);
                if(Arrays.toString(ans).compareTo(Arrays.toString(arr))>0){

                    System.out.println("ans: "+Arrays.toString(ans));
                    System.out.println("arr: "+Arrays.toString(arr));
//                    ans = arr;
                    ans = Arrays.copyOf(arr, arr.length);
                }
            }
            return;
        }
        arr[i-1] = i;
        finder(n, target, i+1, sum+i, arr);
        arr[i-1] = -1*i;
        finder(n, target, i+1, sum-i, arr);
    }
}