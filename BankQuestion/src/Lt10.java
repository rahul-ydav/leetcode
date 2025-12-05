class Lt10 {
    public boolean isMatch(String s, String p) {

        return finder(s, p, 0, 0);
    }
    boolean finder(String s, String p, int sIdx, int pIdx){

        if(pIdx==p.length()){
            return sIdx==s.length() && pIdx==p.length();
        }

        char firstChar = p.charAt(pIdx);
        if(pIdx==p.length()-1) {
            if(sIdx==s.length()){
                return false;
            }
            if (sIdx != s.length() - 1) return false;
            return firstChar == '.' || s.charAt(sIdx) == p.charAt(pIdx);
        }
        char secChar = p.charAt(pIdx+1);
        if(secChar!='*'){
            if(sIdx==s.length()){
                return false;
            }
            if(firstChar=='.' || firstChar==s.charAt(sIdx)){
                return finder(s, p, sIdx+1, pIdx+1);
            }
            return false;
        }
        if(firstChar=='.'){
            int sItr = sIdx;
            while(sItr<=s.length()){
                if(finder(s, p, sItr, pIdx+2))  return true;
                sItr++;
            }
        }
        while(sIdx<s.length()){
            if(s.charAt(sIdx)!=firstChar)   break;
            if(finder(s, p, sIdx, pIdx+2))   return true;
            sIdx++;
        }
        return finder(s, p, sIdx, pIdx+2);
    }
}
