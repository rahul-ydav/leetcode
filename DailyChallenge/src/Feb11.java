public class Feb11 {
    public String removeOccurrences(String s, String part) {
        while(s.indexOf(part)>0){
            s = s.replace(part, "");
            s.indexOf("0");
        }
        return s;
    }
}
