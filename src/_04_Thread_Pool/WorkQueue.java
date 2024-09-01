package _04_Thread_Pool;

public class WorkQueue implements Runnable{
private Thread[] threads;
	
	public WorkQueue() {
		int runtime = Runtime.getRuntime().availableProcessors()-1;
		threads = new Thread[runtime];
		
		for(int i = 0; i < runtime; i++) {
			threads[i] = new Thread(this);
		}
		
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
	}public int getThreadCount() {
		
		return threads.length;
	}

}
