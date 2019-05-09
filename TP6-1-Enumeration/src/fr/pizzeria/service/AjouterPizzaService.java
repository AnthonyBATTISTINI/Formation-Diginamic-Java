package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;

import fr.pizzeria.exception.PizzaException;

import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class AjouterPizzaService extends MenuService {

	@Override
	public void executeUC(Scanner scan, IPizzaDao dao) throws PizzaException {
		
		System.out.println("Veuillez saisir le code :");
		String newCode = scan.next();
		if(dao.pizzaExists(newCode))
			throw new SavePizzaException("Code existant");
		System.out.println("Veuillez saisir le nom :");
		String newLibelle = scan.next();
		System.out.println("Veuillez saisir le prix :");
		double newPrix = scan.nextDouble();
		System.out.println("Veuillez choisir la catégorie :");
		System.out.println("1. Viande");
		System.out.println("2. Poisson");
		System.out.println("3. Végétarienne");
		int newCat = scan.nextInt();
		switch(newCat) {
		case 1:
			dao.saveNewPizza(new Pizza(newCode, newLibelle, newPrix, CategoriePizza.VIANDE));
			break;
		case 2:
			dao.saveNewPizza(new Pizza(newCode, newLibelle, newPrix, CategoriePizza.POISSON));
			break;
		case 3:
			dao.saveNewPizza(new Pizza(newCode, newLibelle, newPrix, CategoriePizza.VEGETARIENNE));
			break;
		default :
			throw new SavePizzaException("Catégorie inexistante");
		}
		System.out.println("Ajout effectué");

	}

}
