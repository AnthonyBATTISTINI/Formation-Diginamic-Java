package fr.pizzeria.service;

import java.util.List;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;

import fr.pizzeria.model.Pizza;

public class ListerPizzasService extends MenuService {

	@Override
	public void executeUC(Scanner scan, IPizzaDao dao) {
		
		List<Pizza> listPizzas = dao.findAllPizzas();
		for(Pizza p : listPizzas)
			System.out.println(p.getCode() + " -> " + p.getLibelle() + " (" + String.format("%.2f", p.getPrix()) + "€)");
		System.out.println("Affichage effectué");
		
	}

}
