package com.thread;

public class Task3Main {

	public static void main(String[] args) {
		Task3Thread t1=new Task3Thread();
		Task3Thread t2=new Task3Thread();

		t1.start();
		try {
			t1.join();
		} catch (Exception e) {
			System.out.println("Execption at thread join");
		}
		t2.start();
		//13 , 14 ...soon
		//id number of thread
		System.out.println(t1.getId()+" , "+t2.getId());
		// getPriority setPriority =>>MIN_PRIORITY NORM_PRIORITY MAX_PRIORITY
		t2.setPriority(10);
		System.out.println(t1.getPriority()+" , "+t2.getPriority());
		// setName and getName
		System.out.println(t1.getName()+" , "+t2.getName());
		// TERMINATED , RUNNABLE , new
		System.out.println(t1.getState()+" , "+t2.getState());
		//false , true as per thread existing 
		System.out.println(t1.isAlive()+" , "+t2.isAlive());
		System.out.println(t1.isDaemon());
		t1.setDaemon(true);
		System.out.println(t1.isDaemon());
		//change to Daemon or user defined
		//isInterrupted interrupt
		System.out.println("testing t2 is interrupted are not "+t2.isInterrupted());
//		interrupted help static and about current thread
		System.out.println("testing thread is interrupted are not "+Thread.interrupted());
		System.out.println("Current running thread  "+Thread.currentThread());

		 t1=new Task3Thread();
		 t2=new Task3Thread();
		 t1.setName("myfiles --1");
		 t2.setName("myfiles --2");
		t1.start();
		t2.start();
		
	}

}
/*
 		t1.start();
		try {
			t1.join();
		} catch (Exception e) {
			System.out.println("Execption at thread join");
		}
		t2.start();
		//13 , 14 ...soon
		//id number of thread
		System.out.println(t1.getId()+" , "+t2.getId());
		// getPriority setPriority =>>MIN_PRIORITY NORM_PRIORITY MAX_PRIORITY
		t2.setPriority(10);
		System.out.println(t1.getPriority()+" , "+t2.getPriority());
		// setName and getName
		System.out.println(t1.getName()+" , "+t2.getName());
		// TERMINATED , RUNNABLE , new
		System.out.println(t1.getState()+" , "+t2.getState());
		//false , true as per thread existing 
		System.out.println(t1.isAlive()+" , "+t2.isAlive());
		System.out.println(t1.isDaemon());
		t1.setDaemon(true);
		System.out.println(t1.isDaemon());
		//change to Daemon or user defined
		//isInterrupted interrupt
		System.out.println("testing t2 is interrupted are not "+t2.isInterrupted());
//		interrupted help static and about current thread
		System.out.println("testing thread is interrupted are not "+Thread.interrupted());
		System.out.println("Current running thread  "+Thread.currentThread());

		 t1=new Task3Thread();
		 t2=new Task3Thread();
		t1.start();
		t2.start();
 */
