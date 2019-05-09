package fr.pizzeria.controller;

import java.util.InputMismatchException;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaMemDao;

import fr.pizzeria.exception.MenuServiceFactoryException;
import fr.pizzeria.exception.NumberInvalidException;
import fr.pizzeria.exception.PizzaException;

import fr.pizzeria.factory.MenuServiceFactory;

import fr.pizzeria.service.MenuService;

public class App {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		PizzaMemDao dao = null;
		try {
			dao = new PizzaMemDao();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		int choose;
		do {
			System.out.println("***** Pizzeria Administration *****");
			System.out.println("1. Lister les pizzas");
			System.out.println("2. Ajouter une nouvelle pizza");
			System.out.println("3. Mettre à jour une pizza");
			System.out.println("4. Supprimer une pizza");
			System.out.println("99. Sortir");
			try{
				choose = scan.nextInt();
				MenuService ms = MenuServiceFactory.selectService(choose);
				ms.executeUC(scan, dao);
			}
			catch (InputMismatchException ime) {
				System.out.println("Veuillez entrer un nombre entier");
				scan.next();
			}
			catch (MenuServiceFactoryException msfe) {
				System.out.println(msfe.getMessage());
			}
			catch (PizzaException pe) {
				System.out.println(pe.getMessage());
			}
			catch (NumberInvalidException nie) {
				System.out.println(nie.getMessage());
			}
		} while(true);

	}

}
