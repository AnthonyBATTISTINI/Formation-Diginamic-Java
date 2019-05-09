package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;

import fr.pizzeria.exception.DeletePizzaException;

import fr.pizzeria.exception.PizzaException;

public class SupprimerPizzaService extends MenuService {

	@Override
	public void executeUC(Scanner scan, IPizzaDao dao) throws PizzaException {
		
		System.out.println("Veuillez choisir le code de la pizza à supprimer");
		String code = scan.next();
		if(!dao.pizzaExists(code))
			throw new DeletePizzaException("Code inexistant");
		dao.deletePizza(code);
		System.out.println("Suppression effectuée");
		
	}

}
