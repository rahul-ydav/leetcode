import java.util.List;

public class Q2 {
    int n;
    public int findMinimumTime(List<Integer> strength, int K) {
        this.n = strength.size();
        int currX = 1;
        int energy = 0;
        int time = 0;
        int[] isValid = new int[n];
        while(1>0){
            int maxS = -1;

            for(int i=0; i<n; i++){
                if(isValid[i]==0 && strength.get(i)<=energy){
                    if(maxS==-1 || strength.get(i)>strength.get(maxS)){
                        maxS = i;
                    }
                }
            }
            if(maxS!=-1){
                isValid[maxS] = 1;
                energy = 0;
                currX +=K;
            }
            energy += currX;
            int s = 0;
            for(int z=0; z<n; z++){
                s+=isValid[z];
            }
            if(s==n)    break;
            time++;
        }

        return time;
    }
}
