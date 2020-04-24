package com.springinaction.knights;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Audience {

	@Pointcut("execution(* com.springinaction.knights.Knight.*(..))")
	public void performance(){}
	
	@Before("performance()")
	public void silenceCellPhones() {
		System.out.println("Silencing cell phones.");
	}
	
	@Before("performance()")
	public void takingSeats() {
		System.out.println("Taking Seats.");
	}

	@AfterReturning("performance()")
	public void applaud() {
		System.out.println("CLAP CLAP CLAP!!");
	}

	@AfterThrowing("performance()")
	public void demandRefund() {
		System.out.println("Demanding a refund.");
	}
}
