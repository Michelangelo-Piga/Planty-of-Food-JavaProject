package com.pof.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.TreeMap;

import com.pof.models.Prodotti;
import com.pof.models.Utenti;
import com.pof.models.Vendite;

public class gestioneFiles {

	private TreeMap<Integer, Prodotti> prodottiMap;
	private TreeMap<Integer, Utenti> utentiMap;
	private TreeMap<Integer, Vendite> venditeMap;

	public gestioneFiles() {
		prodottiMap = new TreeMap<>();
		utentiMap = new TreeMap<>();
		venditeMap = new TreeMap<>();
	}

	public TreeMap<Integer, Prodotti> getProdottiMap() {
		return prodottiMap;
	}

	public void setProdottiMap(TreeMap<Integer, Prodotti> prodottiMap) {
		this.prodottiMap = prodottiMap;
	}

	public TreeMap<Integer, Utenti> getUtentiMap() {
		return utentiMap;
	}

	public void setUtentiMap(TreeMap<Integer, Utenti> utentiMap) {
		this.utentiMap = utentiMap;
	}

	public TreeMap<Integer, Vendite> getVenditeMap() {
		return venditeMap;
	}

	public void setVenditeMap(TreeMap<Integer, Vendite> venditeMap) {
		this.venditeMap = venditeMap;
	}

	public void importaFiles() {
		// import dei prodotti dal CSV
		try {

			InputStream ioStream = this.getClass().getClassLoader().getResourceAsStream("prodotti.csv");
			if (ioStream == null) {
				throw new IllegalArgumentException("prodtti.csv" + " is not found");
			}

			BufferedReader reader = new BufferedReader(new InputStreamReader(ioStream));
			String line = "";

			line = reader.readLine();
			while ((line = reader.readLine()) != null) {
				String[] row = line.split(";");

				Prodotti prodotto = new Prodotti(Integer.parseInt(row[0]), row[1], row[2], row[3], row[4], row[5]);

				prodottiMap.put(Integer.parseInt(row[0]), prodotto);
			}
			reader.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		// import degli Utenti dal CSV
		try {

			InputStream ioStream = this.getClass().getClassLoader().getResourceAsStream("utenti.csv");
			if (ioStream == null) {
				throw new IllegalArgumentException("utenti.csv" + " is not found");
			}

			BufferedReader reader = new BufferedReader(new InputStreamReader(ioStream));
			String line = "";

			line = reader.readLine();
			while ((line = reader.readLine()) != null) {
				String[] row = line.split(";");
				Utenti utente = new Utenti(Integer.parseInt(row[0]), row[1], row[2], row[3], row[4], row[5]);

				utentiMap.put(Integer.parseInt(row[0]), utente);
			}
			reader.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		// import delle Vendite dal CSV
		try {

			InputStream ioStream = this.getClass().getClassLoader().getResourceAsStream("vendite.csv");
			if (ioStream == null) {
				throw new IllegalArgumentException("vendite.csv" + " is not found");
			}

			BufferedReader reader = new BufferedReader(new InputStreamReader(ioStream));
			String line = "";

			line = reader.readLine();
			while ((line = reader.readLine()) != null) {
				String[] row = line.split(";");
				Vendite vendita = new Vendite(Integer.parseInt(row[0]), prodottiMap.get(Integer.parseInt(row[1])),
						utentiMap.get(Integer.parseInt(row[2])));

				venditeMap.put(Integer.parseInt(row[0]), vendita);
			}
			reader.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void riempiMappe() {
		importaFiles();
	}

	public Collection<Prodotti> getProdottiCollection() {
		return this.prodottiMap.values();
	}

	public Collection<Utenti> getUtentiCollection() {
		return this.utentiMap.values();
	}

	public Collection<Vendite> getVenditeCollection() {
		return this.venditeMap.values();
	}

	public boolean contieneUtente(Integer i) {

		if (utentiMap.containsKey(i)) {
			return true;
		} else {
			return false;
		}
	}

	public void aggiungiUtente(Utenti u) {

		utentiMap.put(u.getIdUtenti(), u);
	}

	public TreeMap<Integer, Utenti> getUtentisMap() {
		return this.utentiMap;
	}

	public TreeMap<Integer, Prodotti> getProdottisMap() {
		return this.prodottiMap;
	}

	public TreeMap<Integer, Vendite> getVenditesMap() {
		return this.venditeMap;
	}

	public void aggiungiVendita(Vendite v) {

		venditeMap.put(venditeMap.size() + 1, v);
	}

	public void rimuozioneVendita(int id) {
		venditeMap.remove(id);
	}

}
