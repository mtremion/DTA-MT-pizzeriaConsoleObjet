package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.console.Pizza;
import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.*;


public class ModifierPizzaService extends MenuService
{
	public ModifierPizzaService(IPizzaDao pIPizzaDao) {
		super(pIPizzaDao);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void executeUC(Scanner scanner) throws UpdatePizzaException 
	{
	
		String codeAChanger;
		String newCode;
		String newLibelle;
		String newCategorie;
		double newPrix;
		
		
		scanner.nextLine();
		
		do
		{
			System.out.println("\nVeuillez choisir le code de la pizza � modifer");
			codeAChanger = scanner.nextLine().toUpperCase();
			
			this.iPizzaDao.pizzaExists(codeAChanger);
			
			if(!this.iPizzaDao.pizzaExists(codeAChanger))
			{
				throw new UpdatePizzaException("Il n'y a pas de pizza r�f�renc� � ce code, veuillez en saisir un nouveau");

			}
		}while(!this.iPizzaDao.pizzaExists(codeAChanger));
		

		System.out.println("Veuillez saisir le nouveau code :");
		newCode = scanner.nextLine().toUpperCase();
			
		System.out.println("Veuillez saisir le nouveau nom (sans espace):");
		newLibelle = scanner.nextLine();
		
		System.out.println("Veuillez saisir la nouvelle cat�gorie : Viande/Poisson/Vegetarienne ?");
		newCategorie = scanner.nextLine().toUpperCase();
			
		System.out.println("Veuillez saisir le nouveau prix :");
		newPrix = Double.parseDouble(scanner.nextLine());
			
		Pizza majPizza = new Pizza(newCode,newLibelle,newCategorie,newPrix);
		
			
		this.iPizzaDao.updatePizza(codeAChanger, majPizza);
		
	}
}
