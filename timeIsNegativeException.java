package LakesPackage;

public class timeIsNegativeException extends Exception
{

	public timeIsNegativeException()
	{
		super("Time cannot be a negative value");
	}
	
}
