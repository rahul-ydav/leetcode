import java.util.ArrayList;
import java.util.List;

class Lt282 {
    List<String> res = new ArrayList<>();
    int target;
    String num;
    public List<String> addOperators(String num, int target) {
        this.target = target;
        this.num = num;

        finder(0, 0, "", 0, false);

        return res;
    }


    void finder(int idx, long eval, String curr, long lastVal, boolean multiplied){

        if(idx==num.length()){
            if(eval==target){
                res.add(curr);
            }
            return;
        }


        for(int i=idx+1; i<=num.length(); i++){
            long currVal = Long.parseLong(num.substring(idx, i));


            if(idx==0){
                finder(idx+1, eval+currVal, curr+currVal, currVal, true);
                continue;
            }

            finder(idx+1, multiplied? eval*currVal : eval+lastVal - lastVal*currVal, curr+'*'+currVal, 0, true);

            finder(idx+1, eval+currVal, curr+'+'+currVal, -currVal, false);

            finder(idx+1, eval-currVal, curr+'-'+currVal, currVal, false);

        }
    }
}