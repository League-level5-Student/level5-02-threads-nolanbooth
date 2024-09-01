package _03_Threaded_Greeting;

public class ThreadedGreeter implements Runnable{
	int number;
	
	public ThreadedGreeter(int number) {
	this.number = number;	
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Hello from thread number: " + number);
		if(number <= 50) {
			Thread newthread = new Thread(new ThreadedGreeter(number+1));
			
			newthread.start();
		}
	}

}
