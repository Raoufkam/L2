package Banque;
public class Carte {
	
	private int[] code ;
	private int numClient ;
	private int numCompte ;
	private banque banque ;
	private Date DateValide ;
	private int nbEssais = 3 ;	
	
	
	
	public Carte(int[] code, int numClient, int numCompte, banque banque, Date DateValide) {
		super();
		this.code = code;
		this.numClient = numClient;
		this.numCompte = numCompte;
		this.banque = banque;
		this.DateValide = DateValide;
	}
	
	
	
	public banque getBanque() {
		return banque;
	}
	
	

	public Date getDateValide() {
		return DateValide;
	}
	
	public int[] getCode() {
		return code ;
	}
	
	
	public int getNumClient() {
		return numClient;
	}



	public int getNumCompte() {
		return numCompte;
	}



	public boolean codeValide(int[] code){	
		if (this.code == code && this.nbEssais>0){
			System.out.println("Code bon !");
			this.nbEssais = 3 ;
			return true ;
		}
		if(this.nbEssais<=1) {
			System.out.println("Carte verouille : vous avez plus d'essaies !");
			this.nbEssais--;
			return false ;
		}
		System.out.println("Code faux");
		this.nbEssais--;
		return false;
	}
	
	public void payer(banque b,int numClient,int numCompte,float montant) {	
		
		Client recepteur = b.getTableauClients(numClient);
		Compte compte_reception= recepteur.getCompte(numCompte);
		
		Client emetteur = this.banque.getTableauClients(this.numClient);
		Compte compte_emetteur= emetteur.getCompte(this.numCompte);
		compte_emetteur.virer(montant,compte_reception);

	}

	
	
}
