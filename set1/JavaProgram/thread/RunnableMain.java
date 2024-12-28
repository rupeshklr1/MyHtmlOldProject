package com.thread;

public class RunnableMain {

	public static void main(String[] args) {
		Thread  t1=new Thread (new RunnableInterface());
		Thread  t2=new Thread (new RunnableInterface());
		t1.start();
		t2.start();
	}
}
