package fr.pizzeria.model;

public enum CategoriePizza {

	VIANDE("Viande"),
	POISSON("Poisson"),
	VEGETARIENNE("Végétarienne");
	
	private String type;
	
	private CategoriePizza(String type) {
		this.setType(type);
	}
	
	private void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}
	
	public String toString() {
		return this.type;
	}
	
}
