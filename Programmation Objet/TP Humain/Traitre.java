package package1;

public class Traitre extends Samourai{
	
	private int traitrise = 0 ;

	public Traitre(String nom, String boisson, int argent, String seigneur) {
		super(nom, boisson, argent, seigneur);
	}
	
	public void direBonjourTraitre() {
		direBonjour();
		parler("Mon niveau de traitrise est : "+traitrise);
	}
	
	public void faireGentil(int montant,Humain humain) {
		if(montant<=getArgent()) {
			parler("Tiens "+humain.getNom()+" je te fait ce don de "+montant+
					" entre ami-ami t'inquiete !");
			perdreArgent(montant);
			humain.ajouterArgent(montant);
			if (traitrise>0) {
				traitrise--;
			}
		}
		else {
			System.out.println("// Erreur: Traitre.faireGentil: 'Montant donner en argument est "
					+ "superieure a l'argent de poche du donnateur'");
		}
	}
	
	public void extorquer(Commercant commercant) {
		if(traitrise==3) {
			parler("Mais je suis pas un traitre moi, je suis quelqu'un de gentil !");
		}
		ajouterArgent(commercant.getArgent());
		commercant.seFaireExtorquer();
		traitrise++;
		parler("Oups je suis desole pour toi "+commercant.getNom()+", Haha !");
		
	}
	
	
}
