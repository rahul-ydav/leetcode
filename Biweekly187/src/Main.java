import java.util.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String s = "101";
        String[] strs = {"1?1","0?1","0?0"};
        Third th = new Third();
        boolean[] res = th.transformStr(s, strs);
        System.out.println("res: "+Arrays.toString(res));



    }
}