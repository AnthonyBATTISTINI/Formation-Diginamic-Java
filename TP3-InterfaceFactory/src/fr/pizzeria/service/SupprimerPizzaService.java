package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;

public class SupprimerPizzaService extends MenuService {

	@Override
	public void executeUC(Scanner scan, IPizzaDao dao) {
		
		System.out.println("Veuillez choisir le code de la pizza à supprimer");
		String code = scan.next();
		if(!dao.pizzaExists(code))
			System.out.println("Code inexistant");
		else {
			dao.deletePizza(code);
			System.out.println("Suppression effectuée");
		}
		
	}

}
