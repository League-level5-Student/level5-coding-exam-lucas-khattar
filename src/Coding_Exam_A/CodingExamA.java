package Coding_Exam_A;

import java.awt.Color;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class CodingExamA {
	public static void main(String[] args) {
		/*
		 * Write a program that asks the user for three pieces of information.
		 * 1. How many robots
		 * 2. The color of the shapes
		 * 3. How many sides each shape will have
		 * 
		 * Once the information has been collected, the program will then make the requested number of robots
		 * each draw the requested shape in the requested color. The robots should execute at the same time so 
		 * Threads will need to be used. Arrange the robots so that the shapes do not overlap.
		 * For full credit, define the Thread functions using lambdas.
		 * 
		 * See the Coding_Exam_A_Demo.jar for an example of what the finished product should look like.
		 */
		int number = Integer.parseInt(JOptionPane.showInputDialog(null, "How many robots do you want?"));
		String colour = JOptionPane.showInputDialog(null, "What color do you want the shapes to be?(RED | YELLOW | GREEN)").toLowerCase();
		Color color = Color.black;
		if(colour.equals("red")) {
			color = Color.red;
		} else if(colour.equals("yellow")) {
			color = Color.yellow;
		} else if(colour.equals("red")) {
			color = Color.red;
		}
		int sides = Integer.parseInt(JOptionPane.showInputDialog(null, "How many sides do you want your shape to have?"));
		
		Thread robots = new Thread(()-> {
			for (int i = 0; i < number; i++) {
				Thread threadI = new Thread(()-> {
					Robot robotI = new Robot(100+(100*i),300);
					robotI.setSpeed(10);
					robotI.setPenColor(color);
					robotI.penDown();
					robotI.setPenWidth(3);
					
				});
			}
		});
	}
}
