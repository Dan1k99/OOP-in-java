
import Turtle.*;

public class SmartTurtle extends Turtle {

	// draw a polygon in the given sides and size
	public void draw (int sides, double size){ 
		int angle= 360/sides;
		for(int i=0; i<sides; i++) 
		{
			super.moveForward(size);
			super.turnRight(angle);
		}
	}
	

}
