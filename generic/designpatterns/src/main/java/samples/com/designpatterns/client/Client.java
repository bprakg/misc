package samples.com.designpatterns.client;

import org.apache.commons.lang3.StringUtils;

public class Client {

	public static void main(String[] args) {
		String s = "comm.apache.commons.lang";
		System.out.println(StringUtils.substringAfterLast(s, "."));
	}

}
