package com.client.generic;

/**
 * Interval Tree using TreeSet
 * 
 * @author Prakash
 *
 */
public class ClientTBD {

	public static void main(String... strings) {
		ClientTBD ctbd = new ClientTBD();
		sc x = ctbd.new sc();
		sc z = ctbd.add(x);
		System.out.println(x+" \n"+z);
		
	}
	class sc {
		String x="hi";
		
		public String toString() {
			return x;
		}
	}
	
	sc add(sc s) {
		s.x+="_world";
		return s;
	}

}
