package fr.pizzeria.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import fr.pizzeria.console.Pizza;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.exception.UpdatePizzaException;

public class RemettreAZeroBaseService extends MenuService
{

	public RemettreAZeroBaseService(IPizzaDao pIPizzaDao) 
	{
		super(pIPizzaDao);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void executeUC(Scanner scanner) throws SavePizzaException, DeletePizzaException, UpdatePizzaException, StockageException 
	{
		// TODO Auto-generated method stub
		List<Pizza> tempList = new ArrayList<>();
		
		tempList = this.iPizzaDao.findAllPizzas();
		
		for(Pizza p : tempList)
		{
			this.iPizzaDao.deletePizza(p.getCode());
		}
		
	}

}
