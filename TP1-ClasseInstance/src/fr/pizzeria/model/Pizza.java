package fr.pizzeria.model;

public class Pizza {
	
	private static int nextId = 0;
	
	public int id;
	public String code;
	public String libelle;
	public double prix;
	
	public Pizza(String code, String libelle, double prix) {
		this.id = Pizza.nextId++;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
	}
	public Pizza(int id, String code, String libelle, double prix) {
		if(id >= Pizza.nextId)
			Pizza.nextId = id + 1;
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
	}
	
}
