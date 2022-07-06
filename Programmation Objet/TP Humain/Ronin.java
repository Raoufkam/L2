package package1;

public class Ronin extends Humain{
	
	private int nb_honneur = 1 ;

	public Ronin(String nom, String boisson, int argent) {
		super(nom, boisson, argent);
	}
	
	public void donner(int montant , Commercant commercant) {
		if(montant<=getArgent()) {
			parler("Tiens "+commercant.getNom()+" Voila "+montant+" sous.");
			commercant.recevoir(montant);
			perdreArgent(montant);
		}
		else {
			System.out.println("//Erreur: Ronin.donner: 'Montant donner en argument est "
					+ "superieure au l'argent de poche du donnateur'");
		}
	}
	
	public void provoquer(Yakuza yakuza) {
		if((nb_honneur*2)>yakuza.getReputation()) {
			ajouterArgent(yakuza.getArgent());
			yakuza.perdre();
			parler(" La victoire est pour moi petit yakuza haha !");
		}
		else
		{
			yakuza.gagner();
			nb_honneur--;
			parler(" C'est pas possible ! j'ai perdu");
		}
	}
	
	
	
	
}
