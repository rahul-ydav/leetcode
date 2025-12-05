import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        String s = "ckckkk";
//        String p = "ck*kc";
//
//        A a = new A();
//
//        boolean res = a.hasMatch(s, p);
//
//        System.out.println("res: "+res);


        List<List<Integer>> tasks = new ArrayList<>();

//        List<Integer> ls = List.of();
        tasks.add(new ArrayList(List.of(6, 15, 1)));
        tasks.add(new ArrayList(List.of(3, 18, 38)));
        tasks.add(new ArrayList(List.of(7, 8, 31)));

        TaskManager ts = new TaskManager(tasks);


        ts.edit(15, 11);
        ts.print();
        ts.add(6, 26, 44);
        ts.print();

        ts.edit(26, 47);
        ts.print();
        System.out.println("excec: "+ts.execTop());
        ts.print();
//        ts.rmv(101);
//        ts.print();
//        ts.add(5, 105, 15);
//        ts.print();
//        System.out.println("excec: "+ts.execTop());
    }
}