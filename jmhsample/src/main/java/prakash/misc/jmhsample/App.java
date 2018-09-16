package prakash.misc.jmhsample;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		System.out.println("ootb = " + ootbParseInt());
		System.out.println("customParseInt = " + customParseInt());
	}

	public static int ootbParseInt() {
		return Integer.parseInt("2000000000");
	}

	public static int customParseInt() {
		String s = "2000000000";
		int num = 0;
		for (int i = 0; i < s.length(); i++)
			num = num * 10 + ((int) s.charAt(i) - 48);

		return num;
	}
}
