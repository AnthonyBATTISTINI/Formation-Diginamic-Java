package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		
		Pizza[] arrayPizzas = {
				new Pizza("PEP", "Pépéroni", 12.50),
				new Pizza("MAR", "Margherita", 14.00),
				new Pizza("REIN", "La Reine", 11.50),
				new Pizza("FRO", "La 4 fromages", 12.00),
				new Pizza("CAN", "La cannibale", 12.50),
				new Pizza("SAV", "La Savoyarde", 13.00),
				new Pizza("ORI", "L'orientale", 13.50),
				new Pizza("IND", "L'indienne", 14.00)
		};
		Scanner scan = new Scanner(System.in);
		int choose, i;
		String code, newCode, newLibelle;
		double newPrix;
		do {
			System.out.println("***** Pizzeria Administration *****");
			System.out.println("1. Lister les pizzas");
			System.out.println("2. Ajouter une nouvelle pizza");
			System.out.println("3. Mettre à jour une pizza");
			System.out.println("4. Supprimer une pizza");
			System.out.println("99. Sortir");
			
			choose = scan.nextInt();
			
			switch (choose) {
			case 1:
				System.out.println("Liste des pizzas");
				for(i = 0; i < arrayPizzas.length; i++)
					System.out.println(arrayPizzas[i].getCode() + " -> " + arrayPizzas[i].getLibelle() + " (" + String.format("%.2f", arrayPizzas[i].getPrix()) + "€)");
				System.out.println("Affichage effectué");
				break;
			case 2:
				System.out.println("Ajout d'une nouvelle pizza");
				System.out.println("Veuillez saisir le code :");
				newCode = scan.next();
				System.out.println("Veuillez saisir le nom :");
				newLibelle = scan.next();
				System.out.println("Veuillez saisir le prix :");
				newPrix = scan.nextDouble();
				Pizza[] arrayPizzasTempAdd =  new Pizza[arrayPizzas.length + 1];
				for(i = 0; i < arrayPizzas.length; i++)
					arrayPizzasTempAdd[i] = arrayPizzas[i];
				arrayPizzasTempAdd[arrayPizzas.length] = new Pizza(newCode, newLibelle, newPrix);
				arrayPizzas = arrayPizzasTempAdd;
				System.out.println("Ajout effectué");
				break;
			case 3:
				System.out.println("Mise à jour d'une pizza");
				System.out.println("Veuillez choisir le code de la pizza à modifier");
				code = scan.next();
				for(i = 0; i < arrayPizzas.length && !arrayPizzas[i].getCode().equalsIgnoreCase(code); i++);
				if(i == arrayPizzas.length)
					System.out.println("Code inexistant");
				else {
					System.out.println("Veuillez saisir le nouveau code :");
					newCode = scan.next();
					System.out.println("Veuillez saisir le nouveau nom :");
					newLibelle = scan.next();
					System.out.println("Veuillez saisir le nouveau prix :");
					newPrix = scan.nextDouble();
					arrayPizzas[i].modif(newCode, newLibelle, newPrix);
					System.out.println("Modification effectuée");
				}
				break;
			case 4:
				System.out.println("Suppression d'une pizza");
				System.out.println("Veuillez choisir le code de la pizza à supprimer");
				code = scan.next();
				for(i = 0; i < arrayPizzas.length && !arrayPizzas[i].getCode().equalsIgnoreCase(code); i++);
				if(i == arrayPizzas.length)
					System.out.println("Code inexistant");
				else {
					Pizza[] arrayPizzasTempDel = new Pizza[arrayPizzas.length - 1];
					for(int j = 0; j < i; j++)
						arrayPizzasTempDel[j] = arrayPizzas[j];
					for(int j = i; j < arrayPizzasTempDel.length; j++) {
						arrayPizzasTempDel[j] = arrayPizzas[j+1];
						arrayPizzasTempDel[j].decrementId();
					}
					arrayPizzas = arrayPizzasTempDel;
					System.out.println("Suppression effectuée");
				}
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
