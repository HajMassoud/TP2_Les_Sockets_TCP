import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Traitement extends Thread {
	private Socket sc;

	public Traitement(Socket sc) {
		super();
		this.sc = sc;
	}

	public void run() {
		try {
			BufferedReader in_soc = new BufferedReader(new InputStreamReader(sc.getInputStream()));
			PrintWriter out_soc = new PrintWriter(new BufferedWriter(new OutputStreamWriter(sc.getOutputStream())),
					true);
			while (true) {
				String msg = in_soc.readLine();
				boolean test = false;
				if (msg.startsWith("CREATION")) {
					msg = msg.substring(9);
					for (Compte c : Serveur.liste) {
						if (c.getNomclt().equals(msg)) {
							test = true;
						}
					}
					if (test == true) {

						out_soc.println("Compte bancaire existe deja !! ");
					} else {
						Compte cp = new Compte(0, msg);
						Serveur.liste.add(cp);
						out_soc.println("Compte est ajouté avec succes");
						while (true) {
							msg = in_soc.readLine();
							if (msg.startsWith("CREDIT")) {
								msg = msg.substring(7);
								int m = Integer.parseInt(msg);
								cp.setSolde(cp.getSolde() + m);
								out_soc.println("Compte crédité avec succés");

							} else if (msg.startsWith("DEBIT")) {
								msg = msg.substring(6);
								int m = Integer.parseInt(msg);
								if (m < cp.getSolde()) {
									cp.setSolde(cp.getSolde() - m);
									out_soc.println("Compte debité avec succés");
								} else {
									out_soc.println("Solde insuffisant !!!!!! ");
								}

							} else if (msg.startsWith("SOLDE")) {
								out_soc.println("Votre solde est  " + cp.getSolde());

							}
						}
					}
				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
