package it.S5L5WP.BE0622WJH;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.S5L5WP.BE0622WJH.DAO.repositories.EdificioRepository;
import it.S5L5WP.BE0622WJH.DAO.repositories.PostazioneRepository;
import it.S5L5WP.BE0622WJH.DAO.repositories.PrenotazioneRepository;
import it.S5L5WP.BE0622WJH.DAO.repositories.UtenteRepository;
import it.S5L5WP.BE0622WJH.DAO.services.EdificioService;
import it.S5L5WP.BE0622WJH.DAO.services.PostazioneService;
import it.S5L5WP.BE0622WJH.DAO.services.PrenotazioneService;
import it.S5L5WP.BE0622WJH.DAO.services.UtenteService;
import it.S5L5WP.BE0622WJH.entity.Edificio;
import it.S5L5WP.BE0622WJH.entity.Postazione;
import it.S5L5WP.BE0622WJH.entity.Prenotazione;
import it.S5L5WP.BE0622WJH.entity.TipoPostazione;
import it.S5L5WP.BE0622WJH.entity.Utente;

@SpringBootApplication
public class Main /*implements CommandLineRunner*/ {
    Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	//-------------------------------Main-------------------------------//
	/*@Override
	public void run(String... args) throws Exception {
		start();
		scan.close();
	}*/
	
	//-------------------------------Initial-------------------------------//
	@Autowired
	EdificioService es;
	@Autowired
	PostazioneService ps;
	@Autowired
	PrenotazioneService prs;
	@Autowired
	UtenteService us;
    //----------//
	@Autowired
	private EdificioRepository eRepo;
	@Autowired
	private PrenotazioneRepository pRepo;
	@Autowired
	private UtenteRepository uRepo;
	@Autowired
	private PostazioneRepository postRepo;
    //----------//
	
	//-------------------------------Scanners-------------------------------//
	public void start() {

		int scelta;

		while (true) {
			System.out.println("Seleziona tra le seguenti opzioni per continuare:");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.println("║ (1) Utente ║ (2) Gestione ║ (0) Termina esecuzione ║");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

			if (scan.hasNextInt()) {
				scelta = scan.nextInt();
				if (scelta == 1 || scelta == 2 || scelta == 0) {
					break;
				} else {
					System.out.println("Scelta non valida. Riprovare.");
					attesa(1);
				}
			} else {
				System.out.println("Inserire un numero intero valido.");
				attesa(1);
				scan.next();
			}
		}

		switch (scelta) {
		case 1:
			opzioniUtente();
			break;
		case 2:
			opzioniGestore();
			break;
		case 0:
			System.out.println("Spegnimento in corso..");
			attesa(3);
			System.out.println("Esecuzione del programma terminata.");
			break;
		}
	}
	
	//--------------------------------------------------------------------------//
	public void opzioniUtente() {
		int sceltaU;

		while (true) {
			System.out.println("Seleziona tra le seguenti opzioni per continuare: \n");

			System.out.println("(1) Registrazione utente \n(2) Crea prenotazione \n(3) Indietro \n");
			
			if (scan.hasNextInt()) {
				sceltaU = scan.nextInt();
				if (sceltaU >= 1 && sceltaU <= 3) {
					break;
				} else {
					System.out.println("Scelta non valida. Riprovare.");
					attesa(1);
				}
			} else {
				System.out.println("Inserire un numero intero valido.");
				attesa(1);
				scan.next();
			}
		}
		switch (sceltaU) {
		case 1:
			creaUtente();
			break;
		case 2:
			creaPrenotazione();
			break;
		case 3:
			// indietro
			start();
			break;
		}
	}
	
	//--------------------------------------------------------------------------//
	public void opzioniGestore() {
		int sceltaG;

		while (true) {
			System.out.println("Seleziona tra le seguenti opzioni per continuare: \n ");
			System.out.println("(1) Aggiungi Edificio \n(2) Aggiungi Postazione \n(3) Indietro \n");
			if (scan.hasNextInt()) {
				sceltaG = scan.nextInt();
				if (sceltaG >= 1 && sceltaG <= 3) {
					break;
				} else {
					System.out.println("Scelta non valida. Riprovare.");
					attesa(1);
				}
			} else {
				System.out.println("Inserire un numero intero valido.");
				attesa(1);
				scan.next();
			}
		}

		switch (sceltaG) {
		case 1:
			creaEdificio();
			break;
		case 2:
			creaPostazione();
			break;
		case 3:
			start();
			break;
		}
	}
	//-----------------------------------------[Creazioni]-----------------------------------------//
	//-------Edificio-------//
	public void creaEdificio() {
		Edificio ed = new Edificio();
		Scanner in = new Scanner(System.in);
		
        System.out.println("Inserisci il nome dell'edificio: ");
        ed.setNome(in.nextLine());
        System.out.println("Inserisci l'indirizzo: ");
        ed.setIndirizzo(in.nextLine());
        System.out.println("Inserisci la città situata: ");
        ed.setCitta(in.nextLine());
        es.insert(ed);
        System.out.println("Edificio [" + ed.getId() +"] Impostato con successo");
        attesa(2);
        opzioniGestore();
        in.close();
	}
	//-------Utente-------//
	public void creaUtente() {
		Utente ut = new Utente();
		Scanner in = new Scanner(System.in);
		
		System.out.println("Inserisci un username:");
		ut.setUsername(in.nextLine());
        System.out.println("Inserisci il tuo nome completo:");
        ut.setNome(in.nextLine());
        System.out.println("Inserisci l'email:");
        ut.setEmail(in.nextLine());

        us.insert(ut);
        System.out.println("Creazione in corso..");
        attesa(1);
        System.out.println("Utente Creato con successo");
        attesa(1);
        System.out.println("Ecco il tuo Codice/Id Utente: " + ut.getId() + "\n");
        attesa(2);
        opzioniUtente();
        in.close();
	}
	//-------Postazione-------//
	public void creaPostazione() {
		Postazione po = new Postazione();
		Scanner in = new Scanner(System.in);
		getListaEdificio();
		System.out.println("Quale edificio vuole scegliere per creare la postazione?");
		try {
			po.setEdificio(selezionaEdificio(Integer.parseInt(in.nextLine())));
		} catch (Exception e) {
			System.out.println("Edificio inesistente!");
			attesa(1);
			creaPostazione();
		}
		
		System.out.println("Inserisci una breve descrizione:");
		po.setDesc(in.nextLine());
		while(true) {
			System.out.println("Scegli il tipo di postazione: (1)Privato (2)Open Space (3)Sala Riunioni");
			try {
				po.setTipo(selezionaTipoPostazione(Integer.parseInt(in.nextLine())));
				break;
			} catch (Exception e) {
				System.out.println("Scelta non valida");
				attesa(1);
			}
		}
		while(true) {
			try {
				System.out.println("Inserire il massimo di occupanti:");
				po.setMax(Integer.parseInt(in.nextLine()));
				break;
			} catch (Exception e) {
				System.out.println("Si prega di inserire un numero!");
				attesa(1);
			}
		}
		ps.insert(po);
		System.out.println("Postazione [" + po.getId() + "] dell'edificio " + po.getEdificio().getNome() + " è stata creata con successo!");
		attesa(2);
		opzioniGestore();
		in.close();
	}
	
	public void getListaEdificio() {
		List<Edificio> x = eRepo.findAll();
		if(x.isEmpty()) {
			System.out.println("Nessun edificio trovato! Vai a impostarne uno");
			attesa(1);
			opzioniGestore();
		} else {
			System.out.println("Lista degli edifici disponibili:");
			for(Edificio e : x) {
				System.out.println("Edificio Id: [" + e.getId() + "] || Situato a "+e.getCitta());
			}
		}
	}
	
	public Edificio selezionaEdificio(int x) throws Exception {
		Edificio result = eRepo.findById(x);
		 if(result != null) {
			return result;
		} else {
			throw new Exception();
		}
	}
	
	public TipoPostazione selezionaTipoPostazione(int scelta) throws Exception {
		switch(scelta) {
		case 1:
			return TipoPostazione.PRIVATO;
		case 2:
			return TipoPostazione.OPEN_SPACE;
		case 3:
			return TipoPostazione.SALA_RIUNIONI;
		default:
			throw new Exception();
		}
	}
	//-------Prenotazione-------//
	public void creaPrenotazione() {
		Scanner in = new Scanner(System.in);
		Prenotazione pr = new Prenotazione();
		
		System.out.println("Inserire il codice utente:");
		String user = in.nextLine();
        try {
            pr.setUtente(trovaUtente((int)Integer.parseInt(user)));
        } catch (Exception e) {
            System.out.println("Utente non trovato!");
            creaPrenotazione();
        }

		while(true) {
			System.out.println("Che giorno vuoi prenotare? formato 'YYYY-MM-DD':");
			try {
				pr.setData(convertiData(in.nextLine(), trovaUtente((int)Integer.parseInt(user))));
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				attesa(1);
			}
		}
		getListaPostazioni();
		while(true) {
			System.out.println("Inserire il codice Postazione:");
			try {
				pr.setPostazione(selezionaPostazione(Integer.parseInt(in.nextLine())));
				break;
			} catch(NullPointerException e) {
				System.out.println("codice Postazione errata!");
				attesa(1);
			} catch(Exception e) {
				System.out.println("codice Postazione errata!");
				attesa(1);
			}

		}

		prs.insert(pr);
		System.out.println("Registrando la prenotazione in corso...");
		attesa(2);
		System.out.println("Prenotazione di " + pr.getUtente().getNome() +" del " + pr.getData() + " a " + pr.getPostazione().getEdificio().getIndirizzo() + " creata con successo!");
		attesa(3);
		opzioniUtente();
		in.close();

	}
	
	public LocalDate convertiData(String s, Utente user) throws Exception {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate data = LocalDate.parse(s, formatter);
			LocalDate dataOra = LocalDate.now();
			List<Prenotazione> lista = pRepo.findByUser(user.getUsername());
			if (data.isBefore(dataOra)) {
				throw new Exception("Errore: la data è gia passata.");
			}
			for(Prenotazione p : lista) {
				if (p.getData().equals(data)) {
					throw new Exception("Hai già una prenotazione in corso!");
				}
			}
			return data;
		} catch (DateTimeParseException e) {
			System.out.println("Errore: La data inserita non è nel formato corretto!");
			attesa(1);
			throw new Exception("");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			attesa(1);
			throw new Exception("");
		}
	}
	
	public Utente trovaUtente(int u) throws Exception {
        Utente user = uRepo.findById(u);
        if(user != null) {
            return user;
        } else {
        	throw new Exception("Codice utente non valido");
        }
    }
	
	public void getListaPostazioni() {
		List<Postazione> x = postRepo.findAll();
		if(x.isEmpty()) {
			System.out.println("Nessuna postazione disponibile! Vai a impostarne uno");
			attesa(1);
			opzioniGestore();
		} else {
			System.out.println("Lista delle postazioni disponibili:");
			for(Postazione e : x) {
				System.out.println("Postazione Id: ["+ e.getId() +"] || Tipologia: " + e.getTipo() +" || Situato a "+e.getEdificio().getCitta());
			}
		}
	}
	public Postazione selezionaPostazione(int p) throws Exception {
        Postazione post = postRepo.findById(p);
        if(post != null) {
            return post;
        } else {
        	throw new Exception("Postazione non valida");
        }
	}
	
	//attesa thread
	public static void attesa(int sec) {
		int millisec = sec * 1000;
		try {
			Thread.sleep(millisec);
		} catch (InterruptedException e) {
			System.out.println("Errore Attesa");
		}
	}
}