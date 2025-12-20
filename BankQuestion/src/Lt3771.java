public class Lt3771 {
    public long totalScore(int hp, int[] damage, int[] rq) {

        int n = damage.length;
        int st = 0;
        int end = -1;

        long res = 0;

        int ext = 0;


        for(int i=0; i<n; i++){
            int hl = (i==0) ? hp : ext+damage[i-1];
            if(end<i-1){
                end =i-1;
                hl = hp;
            }
            while(end<n-1){
                hl = hl-damage[end+1];
                if(hl<rq[end+1]){
                    ext = hl+damage[end+1];
                    break;
                }
                end++;
            }
            System.out.println("idx: "+i+", end: "+end);
            res = res + end+1-i;

        }

        return res;
    }
}
