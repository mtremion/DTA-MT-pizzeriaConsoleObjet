package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.exception.*;

public class MenuServiceFactory 
{
	PizzaMemDao menu = new PizzaMemDao();
	Scanner sc = new Scanner(System.in);
	
	public MenuServiceFactory(PizzaMemDao pMenu, Scanner pScanner)
	{
		this.menu = pMenu;
		this.sc = pScanner;
	}
	
	public static MenuService getMenuService(IPizzaDao pIPizzaDao, int pChoix) throws StockageException
	{		
		switch(pChoix)
		{
			case(1) : 			
				return new ListerPizzasService(pIPizzaDao);
			case(2) : 
				return new AjouterPizzaService(pIPizzaDao);
			case(3) : 
				return new ModifierPizzaService(pIPizzaDao);
			case(4) : 
				return new SupprimerPizzaService(pIPizzaDao);
			case(99) : 
				return null;
				//System.out.println("\nAu revoir :(\n"); break;
			default :
				throw new StockageException("Choix Inexistant !");
		}
		
		/* switch(pChoix)
		 * {
		 * 		case(1) : return new ListerPizzasService(pIPizzaDao);
		 * 		case(2) : return new AjoutPizzaService(pIPizzaDao);
		 * 		case(3) : return new ModifierPizzaService(pIPizzaDao);
		 * 		case(4) : return new SupprimerPizzaService(pIPizzaDao);
		 * 		case(99) : return new ExitOptionService(pIPizzaDao);
		 * 		default:
		 * 				throw new StockageExceptionMere("Choix Inexistant !");
		 */
	
	}
	
}
