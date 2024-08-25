package _01_Olympic_Rings;

import java.util.Date;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One
	// robot should draw one ring simultaneously with the other 4 robots.
	public static void main(String[] args) {
		Robot timmy = new Robot(400, 400);
		Robot tammy = new Robot(800, 400);
		Robot sammy = new Robot(1200, 400);
		Robot billy = new Robot(600, 600);
		Robot johnny = new Robot(1000, 600);

		System.out.println("olympic rings ja");
		timmy.setSpeed(100);
		tammy.setSpeed(100);
		sammy.setSpeed(100);
		billy.setSpeed(100);
		johnny.setSpeed(100);

		timmy.penDown();
		tammy.penDown();
		sammy.penDown();
		billy.penDown();
		johnny.penDown();

		Thread r1 = new Thread(() -> {
			System.out.println(new Date().getTime());
			for (int i = 0; i < 360; i++) {
				timmy.move(3);
				timmy.turn(1);
			}
		});
		Thread r2 = new Thread(() -> {
			System.out.println(new Date().getTime());
			for (int i = 0; i < 360; i++) {
				tammy.move(3);
				tammy.turn(1);
			}
		});
		Thread r3 = new Thread(() -> {
			System.out.println(new Date().getTime());
			for (int i = 0; i < 360; i++) {
				sammy.move(3);
				sammy.turn(1);
			}
		});
		Thread r4 = new Thread(() -> {
			System.out.println(new Date().getTime());
			for (int i = 0; i < 360; i++) {
				billy.move(3);
				billy.turn(1);
			}
		});
		Thread r5 = new Thread(() -> {
			System.out.println(new Date().getTime());
			for (int i = 0; i < 360; i++) {
				johnny.move(3);
				johnny.turn(1);
			}
		});
		
		r1.start();
		r2.start();
		r3.start();
		r4.start();
		r5.start();
		
		

	}

}
