package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class ListerPizzasService extends MenuService {

	@Override
	public void executeUC(Scanner scan, IPizzaDao dao) {
		
		Pizza[] arrayPizzas = dao.findAllPizzas();
		for(int i = 0; i < arrayPizzas.length; i++)
			System.out.println(arrayPizzas[i].getCode() + " -> " + arrayPizzas[i].getLibelle() + " (" + String.format("%.2f", arrayPizzas[i].getPrix()) + "€)");
		System.out.println("Affichage effectué");
		
	}

}
