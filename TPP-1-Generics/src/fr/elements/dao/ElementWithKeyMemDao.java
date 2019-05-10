package fr.elements.dao;

import java.util.HashMap;
import java.util.Map;

import fr.elements.model.ElementWithKey;

public class ElementWithKeyMemDao<Key, Element> implements IElementWithKeyDao<Key, Element> {

	private Map<Key, ElementWithKey<Key, Element>> mapElementsWithKey = new HashMap<Key, ElementWithKey<Key, Element>>();

	@Override
	public Map<Key, ElementWithKey<Key, Element>> findAllElementsWithKey() {
		return this.mapElementsWithKey;
	}

	@Override
	public void saveNewElementWithKey(ElementWithKey<Key, Element> elementWithKey) {
		this.mapElementsWithKey.put(elementWithKey.getKey(), elementWithKey);
	}

	@Override
	public void updateElementWithKey(Key key, ElementWithKey<Key, Element> elementWithKey) {
		this.mapElementsWithKey.replace(key, elementWithKey);
	}

	@Override
	public void deleteElementWithKey(Key key) {
		this.mapElementsWithKey.remove(key);
	}

	@Override
	public ElementWithKey<Key, Element> findElementWithKeyByKey(Key key) {
		return this.mapElementsWithKey.get(key);
	}

	@Override
	public boolean elementWithKeyExists(Key key) {
		return this.mapElementsWithKey.containsKey(key);
	}
	
}
