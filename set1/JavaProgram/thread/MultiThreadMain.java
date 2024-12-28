package com.thread;
public class MultiThreadMain {
	public static void main(String[] args) {
		MultiCThread t1=new MultiCThread("m1 thread");
		MultiCThread t2=new MultiCThread();
		MultiCThread t3=new MultiCThread();		
		t2.start();
		try {
			t2.join(1500);
			t2.join();
		} catch (Exception e) {
			System.out.println("The exception has been occured at " + Thread.currentThread().getName());  
		}
		t1.start();
		t3.start();		
	}
}
//java multiThread using Thread concept