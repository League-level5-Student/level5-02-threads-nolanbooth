package _06_Wait_and_Notify.Practice;

/*
 
Below are two threads. One thread increments the counter
and the other thread prints the result. If you run the
program as it is, you'll notice that the output in not
sequential.

Your goal is to modify the code inside the threads so that 
they are in synch. Use synchronized, wait, and notify to make
it so that t1 will only increase counter after t2 has printed 
the previous result. The output should be the numbers 0 to 100000
printed in order.
  
*/

public class SynchedSplitLoops {
	static int counter = 0;
	static Object thing = new Object();
	//so basically thread 1 needs to run, then thread 2 needs to run. 
	//Synchronized means
	public static void main(String[] args) {
		//System.err.println("hello");
		
		Thread t1 = new Thread(() -> {
			synchronized(thing) {
			for(int i = 0; i < 1000; i++) {
				System.err.println("thread 1");
				counter++;
				thing.notify();
				
				try {
					thing.wait();
				}catch(InterruptedException e) {
					System.err.print("Error");
					e.printStackTrace();
				}
			}}
		});
		
		Thread t2 = new Thread(() -> {
			synchronized(thing) {
			for(int i = 0; i < 1000; i++) {
				
				System.err.println("thread 2");
				thing.notify();	
				try {
					thing.wait();
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}}
		
		});
		
		t1.start();
		t2.start();
		
		try {
			
			t1.join();
			t2.join();
			
		} catch (InterruptedException e) {
			System.err.println("Could not join threads");
		}
		
	}
}
