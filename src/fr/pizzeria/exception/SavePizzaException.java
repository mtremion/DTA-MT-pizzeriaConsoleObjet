package fr.pizzeria.exception;

public class SavePizzaException extends StockageException
{
	public SavePizzaException()
	{
		
	}
	
	public SavePizzaException(String pMessage)
	{
		super(pMessage);
	}
}
