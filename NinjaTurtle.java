
public class NinjaTurtle extends SmartTurtle {
// draw triangular in probabilty of 0.4 and squre+ poligon in probability of 0.6
	public void draw (int sides, double size) {
		double random= Math.random();
		if(random<=0.4) 
		{
			drawTriangle(size);
		}
		else 
		{
			drawSqure(size);
			super.draw(sides, size);
		}
	}
	// draw triangle
	public void drawTriangle(double size) {
		for(int i=0; i<3; i++) {
		moveForward(size);
		turnRight(120);
		}
	}
	// draw squre
	public void drawSqure(double size) {
		for(int i=0; i<4; i++) {
			moveForward(size);
			turnRight(90);
		}
	}


}
	
	