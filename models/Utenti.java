package com.pof.models;


public class Utenti {

	
	private int idUtenti;
	private String nome;
	private String cognome;
	private String dataDiNascita;
	private String indirizzo;
	private String documentoID;
	
	public Utenti(int idUtenti, String nome, String cognome, String dataDiNascita, String indirizzo, String documentoID) {
		super();
		this.idUtenti = idUtenti;
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.indirizzo = indirizzo;
		this.documentoID = documentoID;
	}

	public int getIdUtenti() {
		return idUtenti;
	}

	public void setIdUtenti(int idUtenti) {
		this.idUtenti = idUtenti;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(String dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getDocumentoID() {
		return documentoID;
	}

	public void setDocumentoID(String documentoID) {
		this.documentoID = documentoID;
	}
	
	
	
	
}