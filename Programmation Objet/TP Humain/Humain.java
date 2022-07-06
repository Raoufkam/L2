package package1;

public class Humain {
	
	private String nom ;
	private String boisson ;
	private int argent ;
	
	public Humain(String nom, String boisson, int argent) {
		super();
		this.nom = nom;
		this.boisson = boisson;
		this.argent = argent;
	}
	
	public String getNom() {
		return nom;
	}

	public String getBoisson() {
		return boisson;
	}

	public int getArgent() {
		return argent;
	}
	
	public void parler(String texte) {
		System.out.println(nom +": "+texte);
	}
	public void direBonjour() {
		System.out.println(nom+": Bonjour ! Je m'appelle " +nom+", et j'aime boire du "+boisson+" et j'ai "+argent+" sous en poche");
	}

	public void boire() {
		parler(" Mmmm, un bon verre de "+boisson+"! GLOUPS !");
	}

	
	public void ajouterArgent(int montant) {
		argent = argent + montant ;
	}
	public void perdreArgent(int montant) {
		argent = argent - montant ;
	}

	

}
