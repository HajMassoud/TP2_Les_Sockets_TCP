import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws Exception, IOException {
	    Socket soc = new Socket("127.0.0.1",5000);
		BufferedReader in_soc = new BufferedReader(new InputStreamReader(soc.getInputStream()));
	    PrintWriter out_soc = new PrintWriter(soc.getOutputStream(),true);
	    BufferedReader in_clavier = new BufferedReader(new InputStreamReader(System.in));
	    while(true) {
	    	String msg = in_clavier.readLine();
	        out_soc.println(msg);
	        
	        String msg2 = in_soc.readLine();
	        System.out.println(msg2);
	    }
	    
		}
}
