public class A {
    public boolean hasMatch(String s, String p) {
        String delimiter = "\\*";
        String[] ptrs = p.split(delimiter);

        for(int x=0; x<ptrs.length; x++){
            if(ptrs[x].length()==0) continue;
            int idx = s.indexOf(ptrs[x]);
            System.out.println(idx);
            if(idx==-1)  return false;
            s = s.substring(idx+ptrs[x].length());

        }

        return true;
    }
}
