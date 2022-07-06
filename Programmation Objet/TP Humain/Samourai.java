package package1;

public class Samourai extends Ronin {
	
	private String seigneur ;

	public Samourai(String nom, String boisson, int argent, String seigneur) {
		super(nom, boisson, argent);
		this.seigneur = seigneur;
	}
	
	public void sePresenter() {
		direBonjour();
		parler("Je suis sert le seigneur "+seigneur);
	}
	
	public void boire(String boisson) {
		parler(" :Mmmm, un bon verre de "+boisson+"! GLOUPS !");
	}
	
	

}
