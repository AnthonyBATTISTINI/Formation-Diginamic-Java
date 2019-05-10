package fr.classs.service;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.Scanner;

public class MenuClasssService {

	public static Object executeUC(Scanner scan, Class<?> o) {
		
		Constructor<?>[] arrayConstructors = o.getConstructors();
		System.out.println("Choisir le constructeur à utiliser :");
		for(int i = 0; i < arrayConstructors.length; i++) {
			System.out.println(i + ". " + arrayConstructors[i].toString());
		}
		int chooseConstructor = scan.nextInt();
		
		Parameter[] arrayParameters = arrayConstructors[chooseConstructor].getParameters();
		Object[] arrayValues = new Object[arrayParameters.length];
		for(int i = 0; i < arrayParameters.length; i++) {
			if(arrayParameters[i].getType().isPrimitive()) {
				System.out.print(arrayParameters[i].getType().getName() + " " + arrayParameters[i].getName() + " = ");
				arrayValues[i] = new Integer(scan.next());
				continue;
			}
			if(arrayParameters[i].getType().isLocalClass()) {
				arrayValues[i] = MenuClasssService.executeUC(scan, arrayParameters[i].getType());
			}
		}
		Object objectResult = null;
		try {
			objectResult = arrayConstructors[chooseConstructor].newInstance(arrayValues);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objectResult;
	}
	
}
