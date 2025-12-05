import java.util.*;

class Ques {
    public int maxBalancedSubarray(int[] nums) {
        final int mod = 1000000007;
        int n = nums.length;

        int result = 0;
        int[] cntOdd = new int[n+1];
        int[] cntEven = new int[n+1];

        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();

        int xor = 0;
        hm.put(xor, new ArrayList<>(List.of(-1)));
        for(int i=0; i<n; i++){
            cntOdd[i+1] = cntOdd[i];
            cntEven[i+1] = cntEven[i];
            if((nums[i]&1)==1) cntOdd[i+1]++;
            else cntEven[i+1]++;

            xor = xor^nums[i];
            System.out.print(xor+", ");

            if(hm.containsKey(xor)){
                ArrayList<Integer> alPos = hm.get(xor);
                for(int pos: alPos){
                    if(cntEven[i+1]-cntEven[pos+1] == cntOdd[i+1]-cntOdd[pos+1]){
                        result = Math.max(result, i+1-(pos+1));
                    }
                }
                alPos.add(i);
                hm.put(xor, alPos);
            }
            else{
                hm.put(xor, new ArrayList<>(List.of(i)));
            }
        }
        if(xor==0 && cntOdd[n]==cntEven[n]) return n;
        System.out.println("cntOdd: "+Arrays.toString(cntOdd));
        System.out.println("cntEven: "+ Arrays.toString(cntEven));
        for(Map.Entry<Integer, ArrayList<Integer>> entry : hm.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue().toString());
        }
        return result;
    }
}

