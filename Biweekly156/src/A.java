
public class A {
    int[] vcount = new int[26];
    public int maxFreqSum(String s) {
        for(int i = 0; i<s.length(); i++){
            int idx = s.charAt(i) - 'a';
            vcount[idx]++;
        }

        int vmax = 0;
        int cmax = 0;
//        for(int i=0; i<26; i++){
        for(int i: vcount){
            if(i==0 || i== 4 || i==8 || i==14 || i==20){
                vmax = Math.max(vmax, vcount[i]);
            }
            else{
                cmax = Math.max(cmax, vcount[i]);
            }
        }


        return vmax+cmax;
    }
}
