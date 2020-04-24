package samples.com.designpatterns.gof.creational;

public abstract class Prototype implements Cloneable {
	public Prototype clone() throws CloneNotSupportedException {
		return (Prototype) super.clone();
	}
}