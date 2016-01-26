package mavenforjenkins;

public class BankAccount {
	
	private double dBalance;
	public BankAccount()
	{
		dBalance = 0;
	}
	
	public boolean depositAmount( double dAmount )
	{
		if (dAmount <= 0)
		{
			System.out.println("Met negative deposit condition");
			return false;
		}
		
		dBalance += dAmount;		
		return true;
	}
	
	public boolean withdrawAmount( double dAmount )
	{
		
		if( dAmount <= 0 )
		{
			System.out.println("Met ivalid withdrawal amount condition");
			return false;
		}
		
		if( dAmount > dBalance )
		{
			System.out.println("Met overdraft condition");
			return false;
		}
		
		dBalance -= dAmount;
		return true;
	}
	
	public double getBalance()	
	{
		return dBalance;
	}
	
	public boolean transferFunds( BankAccount oSource, double dAmount )
	{
		if( 0 >= dAmount )
		{
			System.out.println("Met invalid transfer amount condition");
			return false;
		}
		
		if( dAmount > dBalance )
		{
			System.out.println("Met INSUFFICIENT FUNDS condition");
			return false;
		}
		
		oSource.depositAmount(dAmount);
		dBalance -= dAmount;
		
		return true;		
	}

}
