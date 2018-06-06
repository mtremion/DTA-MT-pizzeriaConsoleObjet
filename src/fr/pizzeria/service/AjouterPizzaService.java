package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.console.Pizza;
import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.CategoriePizza;

public class AjouterPizzaService extends MenuService
{

	public AjouterPizzaService(IPizzaDao pIPizzaDao) 
	{
		super(pIPizzaDao);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void executeUC(Scanner scanner) throws SavePizzaException
	{

		String tempCode;
		String tempLibelle;
		double tempPrix;
		
		String tempCategorie;

	
		System.out.println("*** Ajout d'une nouvelle pizza ***\n");
			
		System.out.println("Veuillez saisir le code :");
		tempCode = scanner.nextLine();
			
		tempCode = scanner.nextLine().toUpperCase();
		
		if(this.iPizzaDao.findPizzaByCode(tempCode) != null)
		{
			throw new SavePizzaException("Une pizza est d�j� enregistr� avec ce code. Veuillez en saisir un nouveau");
		}
		
		
		System.out.println("Veuillez saisir le nom (sans espace):");
		tempLibelle = scanner.nextLine();
		
		if(tempLibelle.isEmpty())
		{
			throw new IllegalArgumentException("Vous avez entr� une mauvaise valeur. Veuillez r�essayer.");
		}
		
		System.out.println("Veuillez saisir la cat�gorie : Viande/Poisson/Vegetarienne");
		tempCategorie= scanner.nextLine().toUpperCase();
		
		System.out.println("Veuillez saisir le prix :");
		tempPrix = Double.parseDouble(scanner.nextLine());
		
		if(tempPrix < 0)
		{
			throw new SavePizzaException("Vous avez saisis un prix n�gatif !");
		}
			
		Pizza newPizza = new Pizza(tempCode,tempLibelle,tempCategorie,tempPrix);
					
		this.iPizzaDao.saveNewPizza(newPizza);
		
		
	}

}
