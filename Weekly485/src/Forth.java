class Forth {
    public String lexSmallestAfterDeletion(String s) {


        int n = s.length();

        StringBuilder sb = new StringBuilder(s);

        for(int c = 0; c<26; c++){
            int count = 0;
            for(int i=0; i<n; i++){
                char ch = s.charAt(i);

                if(ch=='a'+c){
                    count++;
                    if(count>1){
                        if(i==n-1 || (i<n-1 && s.charAt(i+1)<ch)){
                            sb.setCharAt(i, '#');
                        }
                    }
                }
            }

        }

        int write = 0;
        for(int read =0; read<n; read++){
            char ch = sb.charAt(read);
            if(ch!='#'){
                sb.setCharAt(write++, ch);
            }
        }
        sb.setLength(write);

        return sb.toString();
    }
}