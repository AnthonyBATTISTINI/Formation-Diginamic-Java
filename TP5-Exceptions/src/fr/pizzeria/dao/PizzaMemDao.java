package fr.pizzeria.dao;

import java.util.LinkedList;
import java.util.List;

import fr.pizzeria.model.Pizza;

public class PizzaMemDao implements IPizzaDao {

private List<Pizza> listPizzas = new LinkedList<Pizza>();
	
	public PizzaMemDao() {
		listPizzas.add(new Pizza("PEP", "Pépéroni", 12.50));
		listPizzas.add(new Pizza("MAR", "Margherita", 14.00));
		listPizzas.add(new Pizza("REIN", "La Reine", 11.50));
		listPizzas.add(new Pizza("FRO", "La 4 fromages", 12.00));
		listPizzas.add(new Pizza("CAN", "La cannibale", 12.50));
		listPizzas.add(new Pizza("SAV", "La Savoyarde", 13.00));
		listPizzas.add(new Pizza("ORI", "L'orientale", 13.50));
		listPizzas.add(new Pizza("IND", "L'indienne", 14.00));
	}
	
	@Override
	public List<Pizza> findAllPizzas() {
		return this.listPizzas;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		listPizzas.add(pizza);
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		int i;
		for(i = 0; !listPizzas.get(i).getCode().equalsIgnoreCase(codePizza); i++);
		listPizzas.set(i, pizza);
	}

	@Override
	public void deletePizza(String codePizza) {
		int i;
		for(i = 0; !listPizzas.get(i).getCode().equalsIgnoreCase(codePizza); i++);
		listPizzas.remove(i);
		for( ; i < listPizzas.size(); i++)
			listPizzas.get(i).decrementId();
	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		int i;
		for(i = 0; !listPizzas.get(i).getCode().equalsIgnoreCase(codePizza); i++);
		return listPizzas.get(i);
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		for(int i = 0; i < listPizzas.size(); i++)
			if(listPizzas.get(i).getCode().equalsIgnoreCase(codePizza))
				return true;
		return false;
	}

}
