package Biweekly168;

public class Main {
	public static void main(String[] args) {
		First fs = new First();

		// String res = fs.lexSmallest("dcab");

		String s = "dcab";
		int n = s.length();
		StringBuilder sb = new StringBuilder(s);
		String ans = s;

		System.out.println("res: " + ans);
	}
}