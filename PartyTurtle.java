
public class PartyTurtle extends DrunkTurtle {
	// move forward as party
	public void moveForward ( double x) {
	double random= Math.random();
	if(random<=0.4) 
	{
		super.moveForward(x);
	}
	else if (random<=0.7) 
	{
		super.moveSahi(x);
	}
	else if(random>0.7)
	{
		super.turnRight((int)x);
		super.moveSahi(1.5*x);
	}

}
	

}
