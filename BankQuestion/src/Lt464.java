public class Lt464 {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(desiredTotal ==0 )   return true;
        return helper(maxChoosableInteger, desiredTotal, 0, 0, true);
    }

    public boolean helper(int mx, int dt, int curr, int mask, boolean isFirst){
        if(curr>=dt)    return !isFirst;
        // if(mask==((1<<mx)-1))   return false;
        for(int i=1; i<=mx; i++){
            if((mask & (1<<(i-1))) == 0){
                int updatedmask = (mask | (1<<(i-1)));
                boolean res = helper(mx, dt, curr+i, updatedmask, !isFirst);
                if(res && isFirst) return true;
            }
        }

        return false;
    }
}