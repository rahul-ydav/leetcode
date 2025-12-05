public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

//        int[] value = {4,2,6};
//        int[] limit = {1, 1, 1};
//
//        Third  th = new Third();
//
//        long res = th.maxTotal(value, limit);
//
//        System.out.println("res: "+res);

        System.out.println("222".compareTo("223"));
        System.out.println(Long.parseLong("3433"));
        StringBuilder st = new StringBuilder("23456");
        System.out.println(st);
        st.append(new StringBuilder(st.substring(0, st.length()-1)).reverse());
        System.out.println(st);
        System.out.println(Long.parseLong(st.toString()));
        st.reverse();
        System.out.println(Integer.parseInt(String.valueOf(st.charAt(st.length()-1))));

    }
}