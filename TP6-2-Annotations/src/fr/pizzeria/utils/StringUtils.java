package fr.pizzeria.utils;

import java.lang.reflect.Field;

public class StringUtils {

	public static String toStringWithCase(Object o) {
		String text = new String();
		switch(o.getClass().getName()) {
		case "fr.pizzeria.model.Pizza" :
			for (Field f : o.getClass().getDeclaredFields()) {
				ToString ts = f.getDeclaredAnnotation(ToString.class);
				if(ts != null) {
					try {
						f.setAccessible(true);
						if(ts.uppercase())
							text += f.get(o).toString().toUpperCase();
						if(ts.lowercase())
							text += f.get(o).toString().toLowerCase();
						if(!ts.uppercase() && !ts.lowercase())
							text += f.get(o).toString();
						text += "  ";
						f.setAccessible(false);
					}
					catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			return text;
		default :
			return null;
		}
	}
	
}
