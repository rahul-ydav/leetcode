public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        String input = "abcd234b1c3c3";

        StringBuilder result = new StringBuilder();
        int n =input.length();
        for(int i=0; i<n; i++){

            int diff = input.charAt(i) - '0';

            if(diff<=9) continue;

            int startIdx = i;
            while(i<n){
                if((input.charAt(i) - '0')<=9)   break;
                i++;
            }   

            int endIdx = i;

            StringBuilder sb = new StringBuilder();
            while(i<n){
                if((input.charAt(i) - '0')>9)   break;
                sb.append(input.charAt(i));
                i++;
            }
            int num = Integer.parseInt(sb.toString());

            String ss = input.substring(startIdx, endIdx);
            for(int j=0; j<num; j++){
                result.append(ss);
            }
            i--;
        }

        System.out.println("result: "+result.toString());
    }
}