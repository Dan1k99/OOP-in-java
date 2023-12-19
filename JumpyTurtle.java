
public class JumpyTurtle extends SmartTurtle{
	// draw poligon as jumpy
	public void draw (int sides, double size)
	{ 
		int angle= 360/sides;
		for(int i=0; i<sides; i++) {
			for(int j=0; j<size; j+=10) {
				tailDown();
				moveForward(5);
				tailUp();
				moveForward(5);
			}
			turnRight(angle);
		}	
	}

	

}
