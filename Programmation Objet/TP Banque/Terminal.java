package Banque;

public class Terminal extends Carte {
	
	private boolean codeV ;
	private banque banque_pm ;
	private Date dateAjour ;
	private float montant_max = 1000 ;
	private String message ;
	
	
	public Terminal(Carte carte,Date dateAJour) {
		super(carte.getCode(), carte.getNumClient(),carte.getNumCompte(),carte.getBanque(),carte.getDateValide());
		
		this.dateAjour = dateAJour ;
	}

	public banque getBanque() {
		banque_pm = super.getBanque() ;
		return banque_pm ;
	}
	
	public boolean verifCode(int[] code) {
		codeV = super.codeValide(code);
		return codeV ;
	}
	
	public String genererAutorisation(Carte carte , float montant) {
		if (codeV==false){
			message = "Erreur : code entrer est invalide" ;
			System.out.println(message);
			return message ; 
		}
		if(montant > montant_max) {
			message = "Erreur : montant depasse le max autorise" ;
			System.out.println(message);
			return message ; 
		}
		if(carte.getDateValide().getAn()<this.dateAjour.getAn()) {
			//En prenant que l'expiration compte que pour les années//
			message = "Erreur : Carte expire" ;
			System.out.println(message);
			return message ;
		}
		else
			message = "Le paiement est autorise" ;
			System.out.println(message);
		return message ;
	}
	
}
