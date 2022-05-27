package com.pof;


import com.pof.controller.gestioneMetodi;


public class Main {
	public static void main(String[]args) {
	
		gestioneMetodi metodi = new gestioneMetodi();

		
		metodi.avvio();
	
	}
}

//Mappare gli utenti, prodotti e ordini utilizzando gli id come keys
//fare un arraylist -> arraylist utenti -> utenti.add(new user)
//String[] row = line.split(";"); contiene già i dati del csv

