package com.thread;

public class RunnableInterface implements Runnable{
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {			
			System.out.println("Runnable Thread is running "+Thread.currentThread().getName()+" "+i);  
			try {
				Thread.sleep(300);				
			} catch (Exception e) {
				System.out.println("Execption rasied for the runnable thread "+i+Thread.currentThread().getName()+" .");
			}
		}
		
	}

}
