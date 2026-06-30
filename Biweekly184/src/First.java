class First {
    public boolean consecutiveSetBits(int n) {

        int lastBit = (n&1);
        n = (n>>1);
        boolean found = true;
        while(n>0){
            int currBit = (n&1);
            if(currBit==1 && lastBit==1){
                if(!found){
                    found = true;
                }
                else return false;
            }
            lastBit = currBit;
            n = (n>>1);
        }
        if(found) return true;
        return false;
    }
}