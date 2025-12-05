package Biweekly168;

public class First {
	public String lexSmallest(String s) {

		// char smallest = s.charAt(0);
		// char largest = s.charAt(0);

		int n = s.length();

		StringBuilder sb = new StringBuilder(s);

		int smallest = 0;
		for (int i = 1; i < n; i++) {

			char ch = s.charAt(i);
			if (ch - 'a' < s.charAt(smallest) - 'a') {
				smallest = i;
			} else if (ch - 'a' == s.charAt(smallest) - 'a') {
				String a = new StringBuilder(sb.substring(0, smallest + 1)).reverse().toString();
				String b = new StringBuilder(sb.substring(0, i + 1)).reverse().toString();

				int cmp = a.compareTo(b);

				if (cmp > 0) {
					smallest = i;
				}
			}
		}

		if (smallest != 0) {
			int largest = 0;
			for (int i = 1; i < n; i++) {
				char ch = s.charAt(i);
				if (ch - 'a' > s.charAt(largest) - 'a') {
					largest = i;
				} else if (ch - 'a' == s.charAt(largest) - 'a') {
					String a = new StringBuilder(sb.substring(largest)).reverse().toString();
					String b = new StringBuilder(sb.substring(i)).reverse().toString();

					int cmp = a.compareTo(b);

					if (cmp < 0) {
						largest = i;
					}
				}
			}
			return (sb.substring(0, largest) + new StringBuilder(sb.substring(largest)).reverse()).toString();
		}

		return (new StringBuilder(sb.substring(0, smallest + 1)).reverse() + sb.substring(smallest + 1)).toString();

	}
}