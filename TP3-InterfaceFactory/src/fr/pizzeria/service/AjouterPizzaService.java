package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;

import fr.pizzeria.model.Pizza;

public class AjouterPizzaService extends MenuService {

	@Override
	public void executeUC(Scanner scan, IPizzaDao dao) {
		
		System.out.println("Veuillez saisir le code :");
		String newCode = scan.next();
		System.out.println("Veuillez saisir le nom :");
		String newLibelle = scan.next();
		System.out.println("Veuillez saisir le prix :");
		double newPrix = scan.nextDouble();
		dao.saveNewPizza(new Pizza(newCode, newLibelle, newPrix));
		System.out.println("Ajout effectué");

	}

}
