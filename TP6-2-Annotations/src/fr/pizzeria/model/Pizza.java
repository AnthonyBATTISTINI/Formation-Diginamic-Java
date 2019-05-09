package fr.pizzeria.model;

import fr.pizzeria.exception.PizzaException;

import fr.pizzeria.utils.Rule;
import fr.pizzeria.utils.StringUtils;
import fr.pizzeria.utils.ToString;

public class Pizza {

	private static int nextId = 0;
	
	private int id;
	@ToString(uppercase = true)
	private String code;
	@ToString
	private String libelle;
	@ToString
	@Rule
	private double prix;
	@ToString(uppercase = true)
	private CategoriePizza cat;
	
	public Pizza(String code, String libelle, double prix, CategoriePizza cat) {
		this.setId(Pizza.nextId++);
		this.setCode(code);
		this.setLibelle(libelle);
		this.setPrix(prix);
		this.setCategoriePizza(cat);
	}
	public Pizza(int id, String code, String libelle, double prix, CategoriePizza cat) {
		if(id >= Pizza.getNextId())
			Pizza.setNextId(id + 1);
		this.setId(id);
		this.setCode(code);
		this.setLibelle(libelle);
		this.setPrix(prix);
		this.setCategoriePizza(cat);
	}
	
	private static void setNextId(int nextId) {
		Pizza.nextId = nextId;
	}
	private void setId(int id) {
		this.id = id;
	}
	private void setCode(String code) {
		this.code = code;
	}
	private void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	private void setPrix(double prix) {
		this.prix = prix;
	}
	private void setCategoriePizza(CategoriePizza cat) {
		this.cat = cat;
	}
	
	private static int getNextId() {
		return Pizza.nextId;
	}
	public int getId() {
		return this.id;
	}
	public String getCode() {
		return this.code;
	}
	public String getLibelle() {
		return this.libelle;
	}
	public double getPrix() {
		return this.prix;
	}
	public CategoriePizza getCategoriePizza() {
		return this.cat;
	}
	
	public String toString() {
		//return this.getCode() + " -> " + this.getLibelle() + " (" + String.format("%.2f", this.getPrix()) + "€," + this.getCategoriePizza() + ")";
		return StringUtils.toStringWithCase(this);
	}
	
	public void modif(String newCode, String newLibelle, double newPrix, CategoriePizza cat) throws PizzaException {
		this.setCode(newCode);
		this.setLibelle(newLibelle);
		this.setPrix(newPrix);
		this.setCategoriePizza(cat);
	}
	public void decrementId() {
		int id = this.getId();
		this.setId(--id);
	}
	
}
