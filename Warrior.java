
public class Warrior extends Figure {

	public Warrior(String name, char sign) 
	{
		super(name, sign);
		// TODO Auto-generated constructor stub
	}


	public Boolean check(Figure f)
	{
		if( !super.check(f)&& (this.getSign()=='G'|| f.getSign()== 'G'))
				return false;
		else
			return true;
			
	}
	
}