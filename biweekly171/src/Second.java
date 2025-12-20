import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Second {
    public int[] minOperations(int[] nums) {
        ArrayList<ArrayList<String>> hm = new ArrayList<>();
        ArrayList<Integer> pals = new ArrayList<>();
        pals.add(1);
        pals.add(3);

        hm.add(new ArrayList<>(List.of("")));
        hm.add(new ArrayList<>(List.of("1")));
        hm.add(new ArrayList<>(List.of("11")));
        for(int i=3; i<=13; i++){
            ArrayList<String> strs = new ArrayList<>();

            for(int j=0; j<hm.get(i-2).size(); j++){
                strs.add("1"+hm.get(i-2).get(j)+"1");
//                pals.add(num);
                StringBuilder sb = new StringBuilder();
                for(int k=0; k<hm.get(i-2).get(j).length(); k++){
                    if(hm.get(i-2).get(j).charAt(k)=='0'){
                        sb.append("1");
                    }
                    else sb.append("0");
                }
                strs.add("1"+sb.toString()+"1");
                // int num2 = 1<<i;
                // num2+=hm.get(i-2).get(j)&;
                // num+=1;
                // pals.add(num);
            }
            hm.add(strs);
        }



        for(int i=3; i<14; i++){
            for(int j=0; j<hm.get(i).size(); j++){
                int k=0;
                int num = 0;
                while(k<i){
                    if(hm.get(i).get(j).charAt(i-1-k)=='1')
                        num+=(1<<k);
                    k++;
                }
                pals.add(num);
            }

        }

        Collections.sort(pals);

        int[] res = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            int val = Collections.binarySearch(pals, nums[i]);

            if(val<0){
                val = val*-1;
                res[i] = Math.min(Math.abs(pals.get(val-2)-nums[i]), Math.abs(nums[i] - pals.get(val-1)));
            }
        }

        return res;
    }
}
