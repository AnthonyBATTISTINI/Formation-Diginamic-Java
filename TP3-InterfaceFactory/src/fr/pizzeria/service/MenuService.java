package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;

public abstract class MenuService {

	public abstract void executeUC(Scanner scan, IPizzaDao dao);
	
}
