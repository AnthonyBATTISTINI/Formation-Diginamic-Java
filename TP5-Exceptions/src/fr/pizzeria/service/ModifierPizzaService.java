package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;

import fr.pizzeria.exception.PizzaException;

import fr.pizzeria.exception.UpdatePizzaException;

import fr.pizzeria.model.Pizza;

public class ModifierPizzaService extends MenuService {

	@Override
	public void executeUC(Scanner scan, IPizzaDao dao) throws PizzaException {
		
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
		Pizza pizzaModif = dao.findPizzaByCode(code);
		pizzaModif.modif(newCode, newLibelle, newPrix);
		dao.updatePizza(code, pizzaModif);
		System.out.println("Modification effectuée");

	}

}
