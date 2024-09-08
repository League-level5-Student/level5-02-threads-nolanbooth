package _04_Thread_Pool;

public class ThreadPoolTester {
public static void main(String[] args) {
	WorkQueue wq = new WorkQueue();
	//System.out.println("Number of threads: " + wq.getThreadCount());
	for(int i = 0; i < 1000; i++) {
		int x = i;
		
		Job j = () -> {
			System.out.println("Printing " + x + " from Thread #" + Thread.currentThread().getId());
			
		};
		
		wq.addJob(j);;
	}
	
	
	
	
//	try {
//		Thread.sleep(1000);
//	}catch(InterruptedException e) {
//		e.printStackTrace();
//		
//	}
	
	
	wq.shutdown();
	
	
	
	
}
}
