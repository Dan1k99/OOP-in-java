
import Turtle.*;
public class TwoTurtles {
// write the letters M & H
	public static void main(String[] args) {
		Turtle my = new Turtle();
		Turtle Heritage = new Turtle();
		my.tailDown();
		my.moveForward(100);
		my.turnRight(135);
		my.moveForward(50);
		my.turnLeft(90);
		my.moveForward(50);
		my.turnRight(135);
		my.moveForward(100);
		my.tailUp();
		my.hide();
		Heritage.tailUp();
		Heritage.turnRight(90);
		Heritage.moveForward(100);
		Heritage.turnLeft(90);
		Heritage.tailDown();
		Heritage.moveForward(100);
		Heritage.tailUp();
		Heritage.moveBackward(50);
		Heritage.turnRight(90);
		Heritage.tailDown();
		Heritage.moveForward(50);
		Heritage.turnLeft(90);
		Heritage.moveForward(50);
		Heritage.moveBackward(100);
		Heritage.hide();
		
		
	}

}
