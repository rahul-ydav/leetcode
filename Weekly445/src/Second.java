public class Second {
    public String smallestPalindrome(String s) {

        int[] mp = new int[26];

        for(int i=0; i<s.length(); i++){
            int pos = s.charAt(i)-'a';
            mp[pos]++;
        }
        int oddVal = -1;
        for(int i=0; i<26; i++){
            if(mp[i]%2==1){
                oddVal = i;
                mp[i]--;
                break;
            }
        }

        StringBuilder res = new StringBuilder();
        if(oddVal>=0)   res.append((char)('a'+oddVal));
        for(int i=25; i>=0; i--){
            if(mp[i]>0){
                int half = mp[i]/2;
                char ch = (char)('a'+i);

                String st = String.valueOf(ch).repeat(half);
                res.append(st);
                res.insert(0, st);
            }
        }

        return res.toString();
    }
}
