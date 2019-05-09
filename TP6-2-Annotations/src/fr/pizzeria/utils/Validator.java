package fr.pizzeria.utils;

import java.lang.reflect.Field;

import fr.pizzeria.exception.NumberInvalidException;

public class Validator {
	
	public static void check(Object o) throws NumberInvalidException {
		for (Field f : o.getClass().getDeclaredFields()) {
			Rule r = f.getDeclaredAnnotation(Rule.class);
			if(r != null) {
				f.setAccessible(true);
				double d = 0;
				try {
					d = f.getDouble(o);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				f.setAccessible(false);
				if(d <= r.min())
					throw new NumberInvalidException("Nombre négatif ou nul");
			}
		}
		
	}
	
}