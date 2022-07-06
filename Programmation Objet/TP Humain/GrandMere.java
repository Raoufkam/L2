package package1;
import java.util.Random;

public class GrandMere extends Humain{
	
	private Humain[] memoire = new Humain[30];
	private String message ;
	private int nb = 0;
	
	

	
	public GrandMere(String nom, String boisson, int argent) {
		super(nom, boisson, argent);
	}
	
	public void faireConnaissanceAvec(Humain humain) {
		memoire[nb] = humain ;
		nb++;
	}

	public String humainHasard() {
		Random random = new Random() ;
		int randomNumber = random.nextInt(6);
		
		switch(randomNumber){
		
			case 1:
				message = " Commercant" ;
				break;
			case 2:
				message = " Ronin" ;
				break;
			case 3:
				message = " Yakuza" ;
				break;
			case 4:
				message = " Samourai" ;
				break;
			case 5:
				message = " Traitre" ;
				break ;
			case 6:
				message = " Grande Mere";
		}
		return message;
	}
	
	public void ragoter() {
		parler("Je suis un peu vieille mais je vais essayer de pousser ma memoire");
		for(int i=0;i<nb;i++){
			if(memoire[i] instanceof Traitre) {
				System.out.println("Je sais que "+memoire[i].getNom()+
						" est un traitre!");
			}
			else {
				System.out.println("Je crois que "+memoire[i].getNom()+" est un"
						+humainHasard());
			}
		}
	}
 
}
