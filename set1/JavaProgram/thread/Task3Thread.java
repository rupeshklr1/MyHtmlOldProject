package com.thread;

public class Task3Thread extends Thread{
	@Override
	public void run(){  
		for (int i = 0; i < 5000; i++) {	
			if(i%500==0) {
				System.out.println("Thread is running "+Thread.currentThread().getName()+" .");  
				try {
					Thread.sleep(10);				
				} catch (Exception e) {
					System.out.println("Execption rasied for the thread "+i+Thread.currentThread().getName()+" .");
				}
			}
		}
	}  
//	public static void firm() {
//		Thread.stop();
//	}
}
