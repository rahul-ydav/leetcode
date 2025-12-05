
class Third {
    public char processStr(String s, long k) {

        long l = 0;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch=='*' ){
                if(l>0) l--;
            }
            else if(ch=='#'){
                l = l*2;
            }
            else if(ch=='%'){
            }
            else{
                l++;
            }
        }

        if(k>=l) return '.';


        long kd = k;
        long ld = l;
        for(int i=s.length()-1; i>=0; i--){

            char ch = s.charAt(i);
            if(ch=='*'){
                if(ld<=0)   return '.';
                ld = ld+1;
                // kd = kd;
            }
            else if(ch=='#'){
                kd = kd%(ld/2);
                ld = ld/2;
            }
            else if(ch=='%'){
                // ld = ld;
                kd = (ld-1)-kd;
            }
            else{
                if(kd==ld-1){
                    return ch;
                }

                ld = ld-1;
            }
            System.out.println("kd: "+kd+", ld: "+ld+", ch: "+ch);
        }


        return '.';

    }
}