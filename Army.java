import Turtle.*;
import java.util.Scanner;

public class Army {
	static Scanner sc = new Scanner(System.in);
	
	
	//The function asks to choose five turtles
	public static void chooseTurtles(Turtle[]army) {
		
		int index=1;
		for(int i = 0;i<army.length;i++) 
		{
			System.out.println("Choose your "+index+ " turtle :\r\n" //print options
				+ "1.	Simple\r\n"
				+ "2.	Smart\r\n"
				+ "3.	Drunk\r\n"
				+ "4.	Jumpy\r\n"
				+ "5.	Ninja\r\n"
				+ "6.	Party\r\n"
				+ "");

			int num = sc.nextInt();  //get user's choice for the five turtles 
				index++;
			if(num == 1) 
				army[i] = new Turtle();
			else if(num == 2) 
				army[i] = new SmartTurtle();
			else if(num == 3) 
				army[i] = new DrunkTurtle();
			else if(num == 4) 
				army[i] = new JumpyTurtle();
			else if(num == 5) 
				army[i] = new NinjaTurtle();
			else if(num == 6) 
				army[i] = new PartyTurtle();
		}
			
	}
	// the function sets the turtles army in a straight line
	public static void straightLine (Turtle [] army) { 
		for(int i=0;i<army.length;i++) {
			army[i].show();
			army[i].tailUp();
			if(army[i] instanceof DrunkTurtle) { // make Drunk and Party move like simple turtle
				((DrunkTurtle)army[i]).turnRightSahi(90);
				((DrunkTurtle)army[i]).moveSahi(i*120);
				((DrunkTurtle)army[i]).turnLeftSahi(90);
			}
			else {
				army[i].turnRight(90);
				army[i].moveForward(120*i);
				army[i].turnLeft(90);
			}
		}
	}
	// tail down for all the army
	public static void setTailDown (Turtle [] army) {
		for(int i=0;i<army.length;i++) {
			army[i].tailDown();
		}
	}
	//the army will move forward. every turtle in his way
	public static void moveForwardTogether (Turtle [] army, int distance) {
		for(int i=0;i<army.length;i++) {
			army[i].moveForward(distance);
		}
	}
	//the army will turn right. every turtle in his way
	public static void turnRightTogether (Turtle [] army, int angle) {
		for(int i=0;i<army.length;i++) {
			army[i].turnRight(angle);
		}
	}
	// the smart turtles will draw
	public static void canDraw (Turtle [] army, int sides, double size) {
		for(int i=0;i<army.length;i++) 
		{
			if(army[i] instanceof SmartTurtle) 
			{
				((SmartTurtle)army[i]).draw(sides,size);
			}
		}
	}
	// all will disappear
	public static void disapear (Turtle [] army) {
		for(int i=0;i<army.length;i++) {
			army[i].hide();
		}
	}
	//main
	public static void main(String[] args) {
		Turtle[]army = new Turtle [5]; 
		chooseTurtles(army);
		straightLine( army);
		setTailDown(army);
		moveForwardTogether(army,60);
		turnRightTogether(army,45);
		moveForwardTogether(army,70);
		canDraw(army,6,40);
		disapear(army);

	}


}
	
	