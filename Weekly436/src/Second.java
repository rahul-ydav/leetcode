public class Second {
    public int[] assignElements(int[] groups, int[] elements) {
        int[] res = new int[groups.length];
        for(int i=0; i<groups.length; i++ ){
            res[i] = -1;
        }
        for(int i=0; i<elements.length; i++) {
            for (int j = 0; j < groups.length; j++) {
                if(res[j]==-1 && groups[j]%elements[i]==0){
                    res[j] = i;
                }
            }
        }

        return res;
    }
}
