package com.rand;

import java.util.Random;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "com.rand.RandService")
public class RandImpl implements RandService {
	private static final int maxRands = 16;

	@WebMethod
	public int next1() {
		System.out.println("next1()");
		return new Random().nextInt();
	}

	@WebMethod
	public int[] nextN(final int n) {
		System.out.println("nextN()");
		final int k = (n > maxRands) ? maxRands : Math.abs(n);
		int[] rands = new int[k];
		Random r = new Random();
		for (int i = 0; i < k; i++)
			rands[i] = r.nextInt();
		return rands;
	}
}
