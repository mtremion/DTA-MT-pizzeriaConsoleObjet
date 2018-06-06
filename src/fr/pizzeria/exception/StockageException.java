package fr.pizzeria.exception;

public class StockageException extends Exception
{
	public StockageException()
	{
		
	}
	
	public StockageException(String pMessage)
	{
		System.out.println(pMessage);
	}
}
