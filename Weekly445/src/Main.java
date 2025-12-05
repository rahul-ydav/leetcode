public class Main {
    public static void main(String[] args) {
        System.out.println((char)('a'+2));

        Second s = new Second();
        String res = s.smallestPalindrome("daccad");

        System.out.println("result:: "+res);

    }
}