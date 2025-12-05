import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Third th = new Third();

        String[] words = {"fdcc","ccfef","acaa","adfa","afc","fdbda"};
        int[] res = th.longestCommonPrefix(words, 1);

        System.out.println("res: "+Arrays.toString(res));
    }
}