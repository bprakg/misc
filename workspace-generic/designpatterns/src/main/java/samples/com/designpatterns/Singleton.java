package samples.com.designpatterns;

public final class Singleton {

	private Singleton() {
	}

	private static class Local {
		private static final Singleton INSTANCE = new Singleton();
	}

	public static Singleton getInstance() {
		return Local.INSTANCE;
	}
}
