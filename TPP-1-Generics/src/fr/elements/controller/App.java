package fr.elements.controller;

import java.util.Scanner;

import fr.classs.service.MenuClasssService;

public class App {

	public int truc;
	
	public App(int t) {
	 this.truc = t;
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Object o = MenuClasssService.executeUC(scan, App.class);
		System.out.println(o.getClass().toString());

	}

}
