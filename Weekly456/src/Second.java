public class Second {
    public int[] longestCommonPrefix(String[] words) {

        int n = words.length;
        int[][] mp = new int[n][2];

        int maxLen = 0;
        int maxC = 0;
        int secMax = 0;
        for(int i=0; i<n-1; i++){
            mp[i][0] = comp(words[i], words[i+1]);
            if(i!=n-2) mp[i][1] = comp(words[i], words[i+2]);

            if(mp[i][0]>maxLen){
                secMax = maxLen;
                maxLen = mp[i][0];
                maxC = 1;
            }
            else if(mp[i][0]==maxLen){
                maxC++;
            }
            else secMax = Math.max(secMax, mp[i][0]);

        }
        for(int i=n-1; i>0; i--){
            mp[i][0] = Math.max(mp[i][0], mp[i-1][0]);
        }

        int[] res = new int[n];

        for(int i=0; i<n; i++){

            res[i] = maxLen;

            if(i>0 && i<n-1 && mp[i-1][1]>maxLen){
                res[i] = mp[i-1][1];
            }

            if(mp[i][0]==maxLen && maxC==1){
                res[i] = secMax;
            }
        }

        return res;
    }

    int comp(String str1, String str2){
        int minLength = Math.min(str1.length(), str2.length());
        int commonLength = 0;

        for (int i = 0; i < minLength; i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                commonLength++;
            } else {
                break;
            }
        }

        return commonLength;
    }
}