package fr.pizzeria.console;

import java.util.Scanner;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int choose;
		do {
			System.out.println("***** Pizzeria Administration *****");
			System.out.println("1. Lister les pizzas");
			System.out.println("2. Ajouter une nouvelle pizza");
			System.out.println("3. Mettre � jour une pizza");
			System.out.println("4. Supprimer une pizza");
			System.out.println("99. Sortir");
			
			choose = scan.nextInt();
			
			switch (choose) {
			case 1:
				System.out.println("Liste des pizzas");
				break;
			case 2:
				System.out.println("Ajout d'une nouvelle pizza");
				break;
			case 3:
				System.out.println("Mise � jour d'une pizza");
				break;
			case 4:
				System.out.println("Suppression d'une pizza");
				break;
			case 99:
				System.out.println("Au revoir");
				scan.close();
				return;
			default :
				System.out.println("Choix inexistant");
			}
			scan.nextLine();
		} while(true);

	}

}
