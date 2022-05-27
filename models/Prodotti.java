package com.pof.models;

public class Prodotti {

	private int idProdotti;
	private String dataInserimento;
	private String marca;
	private String nome;
	private String prezzo;
	private Boolean disponibile;

	public Prodotti(int idProdotti, String nome, String dataInserimento, String prezzo, String marca,
			String disponibile) {
		super();
		this.idProdotti = idProdotti;
		this.dataInserimento = dataInserimento;
		this.marca = marca;
		this.nome = nome;
		this.prezzo = prezzo;
		if (disponibile.compareTo("SI") == 0) {
			this.disponibile = true;
		} else {
			this.disponibile = false;
		}
	}

	public String disponibilita() {
		if (disponibile) {
			return "SI";
		} else {
			return "NO";
		}
	}

	public int getIdProdotti() {
		return idProdotti;
	}

	public void setIdProdotti(int idProdotti) {
		this.idProdotti = idProdotti;
	}

	public String getDataInserimento() {
		return dataInserimento;
	}

	public void setDataInserimento(String dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(String prezzo) {
		this.prezzo = prezzo;
	}

	public Boolean getDisponibile() {
		return disponibile;
	}

	public void setDisponibile(Boolean disponibile) {
		this.disponibile = disponibile;
	}

	@Override
	public String toString() {

		return idProdotti + " | " +
				dataInserimento + " | " +
				marca + " | " +
				nome + " | " +
				prezzo + " | " +
				disponibilita() + "\n";
	}

	public String toStringCompleto() {

		return idProdotti + ";" +
				dataInserimento + ";" +
				marca + ";" +
				nome + ";" +
				prezzo;
	}

}