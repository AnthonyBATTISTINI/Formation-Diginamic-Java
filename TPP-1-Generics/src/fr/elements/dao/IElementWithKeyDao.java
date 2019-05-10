package fr.elements.dao;

import java.util.Map;

import fr.elements.model.ElementWithKey;

public interface IElementWithKeyDao<Key, Element> {

	Map<Key, ElementWithKey<Key, Element>> findAllElementsWithKey();
	void saveNewElementWithKey(ElementWithKey<Key, Element> elementWithKey);
	void updateElementWithKey(Key key, ElementWithKey<Key, Element> elementWithKey);
	void deleteElementWithKey(Key key);
	ElementWithKey<Key, Element> findElementWithKeyByKey(Key key);
	boolean elementWithKeyExists(Key key);
	
}
