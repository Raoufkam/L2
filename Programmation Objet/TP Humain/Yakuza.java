package package1;

public class Yakuza extends Humain{
	
	private String clan ;
	private int reputation = 0 ;
	
	public Yakuza(String nom, String boisson,int argent, String clan) {
		super(nom, boisson, argent);
		this.clan = clan;
		//this.reputation = reputation;
	}
	
	
	
	public String getClan() {
		return clan;
	}



	public int getReputation() {
		return reputation;
	}

	public void direBonjour() {
		super.direBonjour();
		System.out.println(getNom()+": Je suis du clan "+clan);
	}
	
	public void extorquer(Commercant commercant) {
		ajouterArgent(commercant.getArgent());
		commercant.seFaireExtorquer();
		this.reputation++;
		parler(" Je vient d'extorquer le commercant ''"+commercant.getNom()+"'' ");
	}
	
	public void gagner() {
		parler(" La victoire est pour moi ");
	}
	public int perdre() {
		parler(" J'ai perdu mon duel et mes "+getArgent()+" sous, Mince...");
		perdreArgent(getArgent());
		reputation--;
		return reputation;
	}
}
