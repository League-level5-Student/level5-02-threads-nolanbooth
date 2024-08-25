package _00_Thread_Demo;


import java.util.Date;

import org.jointheleague.graphical.robot.Robot;

public class ThreadDemo {
	public static void main(String[] args) {
			Robot timmy = new Robot(400, 700);
			Robot tammy = new Robot(800, 700);
			Robot sammy = new Robot(1200, 700);
			
			timmy.setSpeed(10);
			tammy.setSpeed(10);
			sammy.setSpeed(10);
			
			timmy.move(400);
			tammy.move(400);
			sammy.move(400);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			timmy.moveTo(400, 700);
			tammy.moveTo(800, 700);
			sammy.moveTo(1200, 700);
			
			timmy.setSpeed(1);
			tammy.setSpeed(1);
			sammy.setSpeed(1);
			System.out.println(new Date().getTime());
			Thread r1 = new Thread(()->{System.out.println(new Date().getTime()); timmy.move(400);});
			Thread r2 = new Thread(()->{System.out.println(new Date().getTime()); tammy.move(400);});
			Thread r3 = new Thread(()->{System.out.println(new Date().getTime()); sammy.move(400);});
			
			
			
			r1.start();
			r2.start();
			r3.start();
			
	}
}
