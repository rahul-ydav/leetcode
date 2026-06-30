import java.util.Stack;

class Lt907 {
    public int sumSubarrayMins(int[] nums) {
        long mod = (long)1e9 + 7;
        int n = nums.length;

        long res = 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        for(int i=0; i<n; i++){
            int popped = 1;
            while(st.peek()!=-1 && nums[st.peek()]>=nums[i]){
                st.pop();
            }
            popped = st.peek()==-1 ? i+1 : (i-st.peek());
            st.push(i);
            int lead = 0;

            for(int j= i+1; j<n; j++){
                if(nums[j]<=nums[i]){
                    lead = j-i;
                    break;
                }
            }
            if(lead==0){
                lead = n-i;
            }

            System.out.println("popped: "+popped+", lead: "+lead+", prod: "+(lead*popped));

            res= (res + nums[i]*(lead*popped))%mod;
        }

        return (int)res;
    }
}