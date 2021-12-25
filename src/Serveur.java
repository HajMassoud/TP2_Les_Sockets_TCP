import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Serveur {
	static List<Compte> liste ;
	public static void main(String[] args) throws Exception {
		liste = new ArrayList<Compte>();
		ServerSocket soc = new ServerSocket(5000);
		while (true) {
			Socket sc = soc.accept();
			Traitement tr = new Traitement(sc);
			tr.start();

		}

	}

}
