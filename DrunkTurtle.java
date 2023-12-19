import Turtle.*;

public class DrunkTurtle extends Turtle {
// move forward as drunk	
	public void moveForward(double x)
	{
		super.moveForward(x*Math.random());
		if (Math.random()<0.4)
		{
			super.turnRight((int)x);
		}
		super.moveForward(x*Math.random());
	}
	//turn left as drunk
	public void turnLeft (int y)
	{
		super.turnLeft( (int)(y*Math.random()));
	}
	//turn right as drunk
	public void turnRight (int y)
	{
		super.turnRight((int)(y*Math.random()));
	}
	// move as regular turtle
	public void moveSahi ( double x) 
	{
		super.moveForward(x);
	}
	// turn right as regular  turtle
	public void turnRightSahi ( int x) {
		super.turnRight(x);
	}
	// turn left as regular  turtle
	public void turnLeftSahi ( int x) {
		super.turnLeft(x);
	}
	
	

}
