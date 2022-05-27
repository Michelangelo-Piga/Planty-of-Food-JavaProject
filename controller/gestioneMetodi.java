package com.pof.controller;

import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.pof.models.Utenti;
import com.pof.models.Vendite;
import com.pof.visual.Visual;


public class gestioneMetodi {

    private static gestioneFiles datiFiles;

    public gestioneMetodi() {
        datiFiles = new gestioneFiles();
        datiFiles.importaFiles();
    }

    public void avvio() {

        // preparazione mappe utenti/prodotti/vendite
        datiFiles.riempiMappe();

        System.out.println("\\______   \\  | _____    _____/  |_ ___.__.   _____/ ____\\\r\n"
                + " |     ___/  | \\__  \\  /    \\   __<   |  |  /  _ \\   __\\ \r\n"
                + " |    |   |  |__/ __ \\|   |  \\  |  \\___  | (  <_> )  |   \r\n"
                + " |____|   |____(____  /___|  /__|  / ____|  \\____/|__|   \r\n"
                + "                    \\/     \\/      \\/                    \r\n"
                + "___________               .___\r\n"
                + "\\_   _____/___   ____   __| _/\r\n"
                + " |  ____)/  _ \\ /  _ \\ / __ | \r\n"
                + " |  |    (  <_> |  <_> ) /_/ | \r\n"
                + "  \\_|     \\____/ \\____/\\____ | \r\n"
                + "                           \\/ ");
         Scanner scanner = new Scanner(System.in);
        int scelta = 0;

        do {

            System.out.println("Scegli un'azione da compiere nel menù pricipale:");
            
            System.out.println("1 ---> Visualizza tutti i prodotti all'interno del sistema");
            System.out.println("2 ---> Comprare un prodotto esistente");
            System.out.println("3 ---> Resituire un prodotto");
            System.out.println("4 ---> Aggiungre un nuovo utente");
            System.out.println("5 ---> Esportare un file con i prodotti disponibili");
            System.out.println("0 ---> Uscire dal programma");

            scelta = Integer.parseInt(scanner.nextLine());

            //check input valido
            if (scelta < 0 || scelta > 5) {
                System.out.println("Si prega di scegliere un numero compreso tra 0 e 5");
                System.out.println("Scegli un'azione da compiere nel menù pricipale:");
                continue;

            }

            switch (scelta) {
                case 0: {
                    System.out.println("Uscita dal programma");
                    System.out.println("\r\n"
                            + "  ________                  .______.                 \r\n"
                            + " /  _____/  ____   ____   __| _/\\_ |__ ___.__. ____  \r\n"
                            + "/   \\  ___ /  _ \\ /  _ \\ / __ |  | __ <   |  |/ __ \\ \r\n"
                            + "\\    \\_\\  (  <_> |  <_> ) /_/ |  | \\_\\ \\___  \\  ___/ \r\n"
                            + " \\______  /\\____/ \\____/\\____ |  |___  / ____|\\___  >\r\n"
                            + "        \\/                   \\/      \\/\\/         \\");

                    break;

                    
                }
                case 1: {
                    System.out.println("Stampa dei prodotti presenti nel sistema...");
                    Visual stampaProdotti = new Visual();
                    stampaProdotti.stampaProdotti();
                    break;

                    

                }
                case 2: {
                    compraUnProdotto(scanner);
                    break;
                    

                }
                case 3: {
                    System.out.println("Cancellazione della prenotazione del prodotto");
                    cancellaPrenotazione(scanner);
                    break;
                   
                }
                case 4: {
                    System.out.println("Creazione di un nuovo utente");
                    aggiungiUtente(scanner);
                    break;
                    
                }
                case 5: {
                    System.out.println("Esportazione dei file dei prodotti disponibili..");
                    esportaFileProdottiDisponibiliCSV();
                    break;
                }
                default:
                    break;
            }

     
        } while (scelta != 0);
      
        scanner.close();
    }

    // acquisto di un prodotto con set di avaible a false
    private void compraUnProdotto(Scanner scanner) {

        
        System.out.println("Inserisci l'id del prodotto per prenotare il ritiro, e il tuo id cliente: ");

        System.out.println("Id cliente: \n");
        int idUtente = Integer.parseInt(scanner.nextLine());
        System.out.println("Salve cliente: " + idUtente);

        System.out.println("Id prodotto: \n");
        int idProdotto = Integer.parseInt(scanner.nextLine());

        if ((datiFiles.getProdottiMap().containsKey(idProdotto))
                && (datiFiles.getProdottiMap().get(idProdotto).getDisponibile())
                && (datiFiles.contieneUtente(idUtente))) {

            Vendite vendita = new Vendite(datiFiles.getVenditeCollection().size() + 1,
                    datiFiles.getProdottiMap().get(idProdotto), datiFiles.getUtentiMap().get(idUtente));

            datiFiles.aggiungiVendita(vendita);
            datiFiles.getProdottiMap().get(idProdotto).setDisponibile(false);

            System.out.println("Ordine confermato, la tua prenotazione è andata a buon fine!");
            System.out.println("Codice di prenotazione: \n" + datiFiles.getVenditeCollection().size());

        } else {
            System.out.println("Prenotazione non andata a buon fine, rifare..");
        }
       

    }

    // Cancellazione della prenotazione di un prodotto
    private void cancellaPrenotazione(Scanner scanner) {

        System.out.println("Inserire l'ID della prenotazione che si vuole rimuovere: ");

       
        int prenotazioneId = Integer.parseInt(scanner.nextLine());

        if (datiFiles.getVenditeMap().containsKey(prenotazioneId)) {
            datiFiles.rimuozioneVendita(prenotazioneId);
            System.out.println("Prenotazione del prodotto " + prenotazioneId + " cancellata con successo");
        } else {
            System.out.println("Prenotazione non presente");
        }
        

    }

    // metodo per l'aggiunta di un nuovo utente
    private void aggiungiUtente(Scanner scanner) {

        String[] nuovoUtente = new String[6];
        boolean check = false;
        
        do {
            System.out.println("\nInserire il nuovo ID Utente:");
            nuovoUtente[0] = scanner.nextLine();

            // checking if the user is already in the system
            if (datiFiles.contieneUtente(Integer.parseInt(nuovoUtente[0]))) {

                System.out.println("Questo ID esiste già\n");
                check = false;
            } else {
                check = true;
            }

        } while (check == false);

        System.out.println("Inserire il nome: ");
        nuovoUtente[1] = scanner.nextLine();
        System.out.println("Inserire il cognome: ");
        nuovoUtente[2] = scanner.nextLine();
        System.out.println("Inserire la data di nascita: ");
        nuovoUtente[3] = scanner.nextLine();
        System.out.println("Inserire l'indirizzo: ");
        nuovoUtente[4] = scanner.nextLine();
        System.out.println("Inserire il documentoID: ");
        nuovoUtente[5] = scanner.nextLine();

        datiFiles.aggiungiUtente(new Utenti(Integer.parseInt(nuovoUtente[0]), nuovoUtente[1], nuovoUtente[2],
                nuovoUtente[3], nuovoUtente[4], nuovoUtente[5]));
        System.out.println("Nuovo utente creato: " + datiFiles.getUtentiMap().get(Integer.parseInt(nuovoUtente[0])));

       

    }

    //metodo per l'esportazione dei file con i prodotti ancora disponibili
    public void esportaFileProdottiDisponibiliCSV(){

    List<String> prodottiFiltrati =
    datiFiles.getProdottiCollection().stream().filter(t -> t.getDisponibile())
    .map(t -> t.toStringCompleto()).collect(Collectors.toList());

    FileWriter csvWriter;

    try{
        String nomeFile = new SimpleDateFormat("'prodotti_'dd_MM_yyyy'.csv'").format(new Date());
        csvWriter = new FileWriter(nomeFile);

        csvWriter.append("ID");
        csvWriter.append(";");
        csvWriter.append("Data Inserimento");
        csvWriter.append(";");
        csvWriter.append("Marca");
        csvWriter.append(";");
        csvWriter.append("Nome");
        csvWriter.append(";");
        csvWriter.append("Prezzo");
        csvWriter.append(";");
        csvWriter.append("Disponibile");
        csvWriter.append("\n");

        for(String riga : prodottiFiltrati){
            csvWriter.append(riga);
            csvWriter.append("\n");
        }
        csvWriter.flush();
        csvWriter.close();

        System.out.println("Creato il file nominato" + nomeFile);
    }catch(IOException e){
        e.printStackTrace();
    }
    }
}
