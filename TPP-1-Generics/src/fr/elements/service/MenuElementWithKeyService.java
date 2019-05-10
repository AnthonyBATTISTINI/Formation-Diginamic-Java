package fr.elements.service;

import java.util.Scanner;

import fr.elements.dao.IElementWithKeyDao;;

public abstract class MenuElementWithKeyService<Key, Element> {

	public abstract void executeUC(Scanner scan, IElementWithKeyDao<Key, Element> dao);
	
}
