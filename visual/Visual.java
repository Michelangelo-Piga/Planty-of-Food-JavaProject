package com.pof.visual;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Visual {
	
public void visualizzaListe() {
		
		int scelta = 0;
		
		System.out.println("Scegli un'azione da compiere:");
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("0 ---> Vista degli utenti");
		System.out.println("1 ---> Vista dei prodotti");
		System.out.println("2 ---> Vista delle vendite");
		do {
		
		scelta = scanner.nextInt();
		
		switch (scelta) {
		case 0: {
			System.out.println("Vista degli utenti: ");
			
			String file = "C:\\Users\\PGIMHL96H\\Desktop\\Start2Impact\\progetti\\Progetto Java\\utenti.csv";
			BufferedReader reader = null;
			String line = "";
			
			try {
				reader = new BufferedReader(new FileReader(file));
				while((line = reader.readLine()) !=null) {
					String[] row = line.split(";");
					for(String index : row) {
						System.out.printf("%-10s", index);
					}
					System.out.println();
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			break;
		}case 1: {
			System.out.println("Vista dei prodotti: ");
			
			String file = "C:\\Users\\PGIMHL96H\\Desktop\\Start2Impact\\progetti\\Progetto Java\\prodotti.csv";
			BufferedReader reader = null;
			String line = "";
			
			try {
				reader = new BufferedReader(new FileReader(file));
				while((line = reader.readLine()) !=null) {
					String[] row = line.split(";");
					for(String index : row) {
						System.out.printf("%-20s", index);
					}
					System.out.println();
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			break;
		}case 2: {
			System.out.println("Vista delle vendite: ");
			
			String file = "C:\\Users\\PGIMHL96H\\Desktop\\Start2Impact\\progetti\\Progetto Java\\vendite.csv";
			BufferedReader reader = null;
			String line = "";
			
			try {
				reader = new BufferedReader(new FileReader(file));
				while((line = reader.readLine()) !=null) {
					String[] row = line.split(";");
					for(String index : row) {
						System.out.printf("%-10s", index);
					}
					System.out.println();
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			break;
		}case 3: {
			System.out.println("Uscita...");
			break;
		}
		default:
			break;
		}
		}while(scelta !=3);
		scanner.close();
		
	}

public void stampaProdotti() {
	
	String file = "/prodotti.csv";
	BufferedReader reader = null;
	String line = "";
	
	try {
		reader = new BufferedReader(new FileReader(file));
		while((line = reader.readLine()) !=null) {
			String[] row = line.split(";");
			for(String index : row) {
				System.out.printf("%-20s", index);
			}
			System.out.println();
		}
		reader.close();
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	}
	
}


