/**
 * 
 */
package Banque;

/**
 * @author KMM3543A
 * 
 *
 */
public class Client {
	
	private String nom ;
	private Date dateNaissance ;
	private int nombreComptes;
	private Compte[] tableauComptes = new Compte[100];
	
	/**
	 * @param nom
	 * @param dateNaissance
	 * @param nombreComptes
	 * @param tableauComptes
	 */
	public Client(String nom, Date dateNaissance) {
		super();
		this.nom = nom;
		this.dateNaissance = dateNaissance;
		this.nombreComptes = 1 ;
		this.tableauComptes[0]=new Compte();
		//this.tableauComptes = new Compte[100];
	}
	
	String getNom() {
		return nom;
	}
	
	Date getDate() {
		return dateNaissance;
	}
	
	Compte getCompte(int numero) {
		return tableauComptes[numero-1];
	}
	
	void afficherBilan() {
		for(int i=1;i<=this.nombreComptes;i++) {
			System.out.println("Compte numero "+i+" de "+this.nom+" :");
			tableauComptes[i-1].afficherSolde();
		}
	}
	
	float soldeTotal() {
		float somme = 0 ;
		for(int i=1;i<=this.nombreComptes;i++) {
			somme = tableauComptes[i-1].getSolde()+somme;
		}
		return somme;
	}
	
	void afficherSolde() {
		System.out.println(this.nom+" Votre solde total est :"+soldeTotal());
	}
	
	
	int ajouterCompte() {
		tableauComptes[nombreComptes]=new Compte();
		nombreComptes++;
		return nombreComptes;
	}
		
}

