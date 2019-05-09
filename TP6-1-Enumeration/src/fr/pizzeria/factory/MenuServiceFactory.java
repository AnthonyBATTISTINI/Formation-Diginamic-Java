package fr.pizzeria.factory;

import fr.pizzeria.exception.MenuServiceFactoryException;

import fr.pizzeria.service.*;

public class MenuServiceFactory {

	public static MenuService selectService(int choose) throws MenuServiceFactoryException {
		switch (choose) {
		case 1:
			System.out.println("Liste des pizzas");
			return new ListerPizzasService();
		case 2:
			System.out.println("Ajout d'une nouvelle pizza");
			return new AjouterPizzaService();
		case 3:
			System.out.println("Mise à jour d'une pizza");
			return new ModifierPizzaService();
		case 4:
			System.out.println("Suppression d'une pizza");
			return new SupprimerPizzaService();
		case 99:
			System.out.println("Au revoir");
			System.exit(0);
		default:
			throw new MenuServiceFactoryException("Choix inexistant");
		}
	}
	
}
