package Banque;

public class Compte {
	

	private float soldeCompte ;
	
	/**
	 * @param soldeCompte
	 */
	public Compte() {
		super();
		this.soldeCompte = 0 ;
	}
	
	void depot(float valeur) {
		soldeCompte+=valeur;
	}
	
	void retrait(float valeur) {
		soldeCompte-=valeur;
	}
	
	float getSolde() {
		return soldeCompte ;
	}
	
	void afficherSolde () {
		System.out.println("Votre solde est : "+soldeCompte);
	}
	
	void virer(float valeur,Compte destinataire) {
		this.retrait(valeur); 
		destinataire.depot(valeur);
	}
	

}