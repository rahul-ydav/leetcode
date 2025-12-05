public class Q3 {
    public boolean checkValidCuts(int n, int[][] rectangles) {

        int xres = 0;
        int yres = 0;
        for(int k=1; k<n; k++){
            boolean goodxK = true;
            boolean goodyK = true;
            for(int i=0; i<rectangles.length; i++){
                if(rectangles[i][0]<k && rectangles[i][2]>k){
                    goodxK = false;
                }
                if(rectangles[i][1]<k && rectangles[i][3]>k){
                    goodyK = false;
                }
            }
            if(goodxK) xres++;
            if(xres==2) return true;
            if(goodyK) yres++;
            if(yres==2) return true;
        }

        return false;
    }
}
