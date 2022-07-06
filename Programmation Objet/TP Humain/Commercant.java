package package1;

public class Commercant extends Humain{
	
	public Commercant(String nom , int argent) {
		super(nom, "the", argent);
	}
	
	public void seFaireExtorquer() {
		super.perdreArgent(getArgent());
		super.parler("J'ai tout perdu! Le monde est vraiment injuste...");
		
	}
	
	public void recevoir(int argent) {
		super.ajouterArgent(argent);
		super.parler("Merci beaucoup pour le don !");
		
	}
	

}
