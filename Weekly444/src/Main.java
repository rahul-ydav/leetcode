public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Router r = new Router(3);
        //[[3], [1, 4, 90], [2, 5, 90], [1, 4, 90], [3, 5, 95], [4, 5, 105], [], [5, 2, 110], [5, 100, 110]];

        r.addPacket(1, 4, 90);
        r.addPacket(2, 5, 90);
        r.addPacket(1, 4, 90);
        r.addPacket(3, 5, 95);
    }
}