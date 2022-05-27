package com.pof.models;

public class Vendite {
	
	private int idVendite;
	private Utenti idUtente;
	private Prodotti idProdotto;
	
	
	public Vendite(int idVendite, Prodotti idProdotto, Utenti idUtente) {
		super();
		this.idVendite = idVendite;
		this.idUtente = idUtente;
		this.idProdotto = idProdotto;
		
	}


	public int getIdVendite() {
		return idVendite;
	}


	public void setIdVendite(int idVendite) {
		this.idVendite = idVendite;
	}


	public Utenti getIdUtente() {
		return idUtente;
	}


	public void setIdUtente(Utenti idUtente) {
		this.idUtente = idUtente;
	}


	public Prodotti getIdProdotto() {
		return idProdotto;
	}


	public void setIdProdotto(Prodotti idProdotto) {
		this.idProdotto = idProdotto;
	}

	
	
	
	
}