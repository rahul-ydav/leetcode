import java.util.ArrayList;
import java.util.List;

public class Second {
    public List<String> generateValidStrings(int n, int k) {


        List<String> res = new ArrayList<>();
        int num = (1<<n);
        for(int a=0; a<num; a++){
            boolean valid = true;
            String s = Integer.toBinaryString(a);
            int sum = 0;
            for(int i=1; i<s.length(); i++){
                if(s.charAt(i-1)=='1' && s.charAt(i)=='1'){
                    valid = false;
                    break;
                }
                if(s.charAt(i)=='1') sum = sum +i;
                if(sum>k){
                    valid = false;
                    break;
                }
            }
            res.add(s);
        }

        return res;

    }
}
