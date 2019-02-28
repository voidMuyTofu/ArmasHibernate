package com.fer;


public class Main {
	
	public static void main(String[] args) {
		
		// CREAMOS UNA INSTANCIA DE VISTA Y MODELO Y SE LO PASAMOS AL CONTROLADOR
		
		Vista view = new Vista();
		Modelo model = new Modelo();
		Controller controller = new Controller(view,model);
	} 
} 