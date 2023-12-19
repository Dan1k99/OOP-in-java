
class Residents extends Figure{

	public Residents(String name, char sign) 
	{
		super(name, sign);

	}

	public Boolean check(Figure f)
	{
		if( !super.check(f)&& (this.getSign()=='B'|| f.getSign()== 'B'))
				return false;
		else
			return true;
			
	}
	
}
