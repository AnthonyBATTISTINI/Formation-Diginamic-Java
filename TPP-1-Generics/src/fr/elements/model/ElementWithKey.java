package fr.elements.model;

public class ElementWithKey<Key, Element> {
	
	private Key key;
	private Element element;
	
	public ElementWithKey(Key key, Element element){
		this.setKey(key);
		this.setElement(element);
	}
	
	private void setKey(Key key) {
		this.key = key;
	}
	private void setElement(Element element) {
		this.element = element;
	}
	
	public Key getKey() {
		return this.key;
	}
	public Element getElement() {
		return this.element;
	}
	
}
