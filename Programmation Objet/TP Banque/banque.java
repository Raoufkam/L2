package Banque;

public class banque {
	
	private int nbClients;
	private Client[] tableauClients ;
	
	/**
	 * @param nbClients
	 * @param tableauClients
	 */
	
	public banque() {
		super();
		this.nbClients = 0;
		this.tableauClients = new Client[100];
	}
	
	
	
	public Client getTableauClients(int numClient){
		return tableauClients[numClient-1];
	}


	void ajouterClient(Client compte) {
		tableauClients[nbClients]=compte;
		nbClients++;
		
	}
	
	void bilanBanque() {
		for(int i=1 ; i<=nbClients;i++) {
			tableauClients[i-1].afficherBilan();
		}
	}
	
	
}
