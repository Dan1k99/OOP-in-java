
	public class Figure {
	protected  String name;
	protected  int age;
	protected  char sign;
	
	public Figure(String name, char sign)
	{
		this.name = name;
		this.age = (int) (20 + Math.random()*60);
		this.sign = sign;
	}
	
		 Boolean check(Figure f)
	{
		if(this.getSign()==f.getSign() || this.getSign()=='P' || f.getSign() == 'P')
			return true;
		else
			return false;
	}
	
	public Character getSign()
	{
		return this.sign;
	}
	
	public String getName()
	{
		return this.name + "";
	}
	public int getAge()
	{
		return this.age;
	}
	
	
	
}
