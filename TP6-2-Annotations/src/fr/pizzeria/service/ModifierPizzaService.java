package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.NumberInvalidException;
import fr.pizzeria.exception.PizzaException;

import fr.pizzeria.exception.UpdatePizzaException;

import fr.pizzeria.model.CategoriePizza;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.utils.Validator;

public class ModifierPizzaService extends MenuService {

	@Override
	public void executeUC(Scanner scan, IPizzaDao dao) throws PizzaException, NumberInvalidException {
		
		System.out.println("Veuillez choisir le code de la pizza à modifier");
		String code = scan.next();
		if(!dao.pizzaExists(code))
			throw new UpdatePizzaException("Code inexistant");
		System.out.println("Veuillez saisir le nouveau code :");
		String newCode = scan.next();
		if(!code.equalsIgnoreCase(newCode) && dao.pizzaExists(newCode))
			throw new UpdatePizzaException("Code existant");
		System.out.println("Veuillez saisir le nouveau nom :");
		String newLibelle = scan.next();
		System.out.println("Veuillez saisir le nouveau prix :");
		double newPrix = scan.nextDouble();
		System.out.println("Veuillez choisir la catégorie :");
		System.out.println("1. Viande");
		System.out.println("2. Poisson");
		System.out.println("3. Végétarienne");
		int newCat = scan.nextInt();
		Pizza pizzaModif = dao.findPizzaByCode(code);
		switch(newCat) {
		case 1:
			pizzaModif.modif(newCode, newLibelle, newPrix, CategoriePizza.VIANDE);
			break;
		case 2:
			pizzaModif.modif(newCode, newLibelle, newPrix, CategoriePizza.POISSON);
			break;
		case 3:
			pizzaModif.modif(newCode, newLibelle, newPrix, CategoriePizza.VEGETARIENNE);
			break;
		default :
			throw new UpdatePizzaException("Catégorie inexistante");
		}
		Validator.check(pizzaModif);
		dao.updatePizza(code, pizzaModif);
		System.out.println("Modification effectuée");

	}

}
