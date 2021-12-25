
public class Compte {
	
	private int num; 
	private int solde;
	private String  nomclt;
	public static int N=1;
	
	public Compte() {
		super();
	}

	public Compte(int solde, String nomclt) {
		super();
		N++;
		this.num = N;
		this.solde = solde;
		this.nomclt = nomclt;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getSolde() {
		return solde;
	}

	public void setSolde(int solde) {
		this.solde = solde;
	}

	public String getNomclt() {
		return nomclt;
	}

	public void setNomclt(String nomclt) {
		this.nomclt = nomclt;
	}

}
