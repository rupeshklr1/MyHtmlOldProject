package com.thread;

class MultiCThread extends Thread{
	public MultiCThread(String nmeString) {
		super(nmeString);
		// TODO Auto-generated constructor stub
	}
	public MultiCThread() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void run(){  
		for (int i = 0; i < 5; i++) {			
			System.out.println("Thread is running "+Thread.currentThread().getName()+" .");  
			try {
				Thread.sleep(300);				
			} catch (Exception e) {
				System.out.println("Execption rasied for the thread "+i+Thread.currentThread().getName()+" .");
			}
		}
	} 
	public void frie() {
		for(int i=0;i<5000;i++) {
			if(i%1000==0) {
				run();
			}
		}
	}
}
