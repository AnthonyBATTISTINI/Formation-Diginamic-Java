package fr.pizzeria.controller;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaMemDao;

import fr.pizzeria.factory.MenuServiceFactory;

import fr.pizzeria.service.MenuService;

public class App {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		PizzaMemDao dao = new PizzaMemDao();
		int choose;
		do {
			System.out.println("***** Pizzeria Administration *****");
			System.out.println("1. Lister les pizzas");
			System.out.println("2. Ajouter une nouvelle pizza");
			System.out.println("3. Mettre à jour une pizza");
			System.out.println("4. Supprimer une pizza");
			System.out.println("99. Sortir");
			choose = scan.nextInt();
			MenuService ms = MenuServiceFactory.selectService(choose);
			if(ms != null) {
				ms.executeUC(scan, dao);
			}
		} while(true);

	}

}
