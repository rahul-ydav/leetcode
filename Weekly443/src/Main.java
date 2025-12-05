public class Main {
    public static void main(String[] args) {


        String s = "abcde";
        String t = "ecdba";



        Third tr = new Third();

        int res = tr.longestPalindrome(s, t);

        System.out.println("Main res :: "+res);
    }
}