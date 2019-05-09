package fr.pizzeria.model;

public class Pizza {

private static int nextId = 0;
	
	private int id;
	private String code;
	private String libelle;
	private double prix;
	
	public Pizza(String code, String libelle, double prix) {
		this.setId(Pizza.nextId++);
		this.setCode(code);
		this.setLibelle(libelle);
		this.setPrix(prix);
	}
	public Pizza(int id, String code, String libelle, double prix) {
		if(id >= Pizza.getNextId())
			Pizza.setNextId(id + 1);
		this.setId(id);
		this.setCode(code);
		this.setLibelle(libelle);
		this.setPrix(prix);
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
	
	public void modif(String newCode, String newLibelle, double newPrix) {
		this.setCode(newCode);
		this.setLibelle(newLibelle);
		this.setPrix(newPrix);
	}
	public void decrementId() {
		int id = this.getId();
		this.setId(--id);
	}
	
}
