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
		Color co = Color.black;
		if(colour.equals("red")) {
			co = Color.red;
		} else if(colour.equals("yellow")) {
			co = Color.yellow;
		} else if(colour.equals("red")) {
			co = Color.red;
		}
		int sides = Integer.parseInt(JOptionPane.showInputDialog(null, "How many sides do you want your shape to have?"));
		int angle = 360/sides;
		Color color = co;
		Thread robots = new Thread(()-> {
			for (int i1 = 0; i1 < number; i1++) {
				int i = i1;
				Thread threadI = new Thread(()-> {
					Robot robotI = new Robot(50+(100*i),300);
					robotI.setSpeed(10);
					robotI.setPenColor(color);
					robotI.penDown();
					robotI.setPenWidth(3);
					robotI.hide();
					for (int j = 0; j < sides; j++) {
						robotI.move(5*(20-(sides+number)));
						robotI.turn(angle);
					}
				});
				threadI.start();
			}
		});
		robots.start();
	}
}
