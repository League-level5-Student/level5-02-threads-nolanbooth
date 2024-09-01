package _02_Advanced_Robot_Race;

import org.jointheleague.graphical.robot.Robot;
import java.util.Random;

import javax.swing.JOptionPane;

public class AdvancedRobotRace {
	// Re-do the robot race recipe from level 3 module 0. 
	//actually level 2 module 0. 
	// This time, use threads to make all of the robots go at the same time.
	static volatile  boolean raceOver = false;
	static volatile String winner = "";
	
	public static void main(String[] args) {
		Random rand = new Random();
		 
		Robot[] robots = new Robot[3];
		for(int i = 0; i < 3; i++) {
			robots[i] = new Robot();
			robots[i].setX(i*200 + 200);
			robots[i].setY(800);
			robots[i].setSpeed(50);
			
			
			
		}

		Thread r1 = new Thread(() -> {
		do {
		robots[0].move(rand.nextInt(50));
		
		}while(!atTheTop(robots[0]) && !raceOver);
		if(!raceOver) {
			raceOver  = true;
			winner = "robot 1";
			JOptionPane.showMessageDialog(null, "The winner is "+ winner);
		}
		
		
		
			
			
			
		});
		Thread r2 = new Thread(() -> {
		
			do {
				robots[1].move(rand.nextInt(50));
				
				}while(!atTheTop(robots[1]) && !raceOver);
			
			if(!raceOver) {
				raceOver  = true;
				winner = "robot 2";
				JOptionPane.showMessageDialog(null, "The winner is "+ winner);
			}
		});
		Thread r3 = new Thread(() -> {
			do {
				robots[2].move(rand.nextInt(50));
				
				}while(!atTheTop(robots[2]) && !raceOver);
			
			if(!raceOver) {
				raceOver  = true;
				winner = "robot 3";
				
				JOptionPane.showMessageDialog(null, "The winner is "+ winner);
			}
			
		});
		
		r1.start();
		r2.start();
		r3.start();
		
		
		
		
		
	}
	public static  boolean atTheTop(Robot robot) {
		if(robot.getY() <= 0) {
			return true;
		}else {
			return false;
		}
	}
	
}
