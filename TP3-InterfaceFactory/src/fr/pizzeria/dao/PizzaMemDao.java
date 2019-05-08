package fr.pizzeria.dao;

import fr.pizzeria.model.Pizza;

public class PizzaMemDao implements IPizzaDao {

	private Pizza[] arrayPizzas = {
			new Pizza("PEP", "Pépéroni", 12.50),
			new Pizza("MAR", "Margherita", 14.00),
			new Pizza("REIN", "La Reine", 11.50),
			new Pizza("FRO", "La 4 fromages", 12.00),
			new Pizza("CAN", "La cannibale", 12.50),
			new Pizza("SAV", "La Savoyarde", 13.00),
			new Pizza("ORI", "L'orientale", 13.50),
			new Pizza("IND", "L'indienne", 14.00)
	};
	
	@Override
	public Pizza[] findAllPizzas() {
		return this.arrayPizzas;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		Pizza[] arrayPizzasTempAdd =  new Pizza[arrayPizzas.length + 1];
		for(int i = 0; i < arrayPizzas.length; i++)
			arrayPizzasTempAdd[i] = arrayPizzas[i];
		arrayPizzasTempAdd[arrayPizzas.length] = pizza;
		arrayPizzas = arrayPizzasTempAdd;
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		int i;
		for(i = 0; !arrayPizzas[i].getCode().equalsIgnoreCase(codePizza); i++);
		arrayPizzas[i] = pizza;
	}

	@Override
	public void deletePizza(String codePizza) {
		int i;
		for(i = 0; !arrayPizzas[i].getCode().equalsIgnoreCase(codePizza); i++);
		Pizza[] arrayPizzasTempDel = new Pizza[arrayPizzas.length - 1];
		for(int j = 0; j < i; j++)
			arrayPizzasTempDel[j] = arrayPizzas[j];
		for(int j = i; j < arrayPizzasTempDel.length; j++) {
			arrayPizzasTempDel[j] = arrayPizzas[j+1];
			arrayPizzasTempDel[j].decrementId();
		}
		arrayPizzas = arrayPizzasTempDel;
	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		int i;
		for(i = 0; !arrayPizzas[i].getCode().equalsIgnoreCase(codePizza); i++);
		return arrayPizzas[i];
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		for(int i = 0; i < arrayPizzas.length; i++)
			if(arrayPizzas[i].getCode().equalsIgnoreCase(codePizza))
				return true;
		return false;
	}

}
