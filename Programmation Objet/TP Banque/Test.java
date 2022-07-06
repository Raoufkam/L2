package Banque;

public class Test {
	/*Ici on trouvera des test qui m'ont aidé a 
	vérifier le fonctionnemt de mon projet */
	/*Author : KAMICHE MOHAMED
	 * Date de modification : 02/03/2022
	 * TP1&2 POO L2 INFO - 2021/2022	
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.out.println("Hello World !");

		//System.out.println(new Date(14,02,2007));
		Date d1 = new Date(10, 02, 2022);
		Date pere = new Date(11,05,1999);
		Date mere = new Date(9,07,1962);
		//System.out.println(d1);
		/*System.out.println(d1.toString());*/
		//Compte[] tab = null ;
		//tab[0].depot(250);
		Client moi = new Client("Raouf",d1);
		Client papa = new Client("Smain",pere);
		Client madre = new Client("Thouraya",mere);
		
		Compte lcl = moi.getCompte(1);
		moi.ajouterCompte();
		Compte bnp = moi.getCompte(2);
		
		Compte padre1 = papa.getCompte(1);
		papa.ajouterCompte();
		Compte padre2 = papa.getCompte(2);
		
		Compte madre1 = madre.getCompte(1);
		madre.ajouterCompte();
		Compte madre2 = madre.getCompte(2);
		madre.ajouterCompte();
		Compte madre3 = madre.getCompte(3);
		
		lcl.depot(150);
		lcl.virer(66, padre1);
		bnp.depot(50);
		bnp.virer(25,padre2);
		madre1.depot(400.0f);
		madre1.virer(200.0f, madre2);
		madre2.retrait(10);
		madre3.depot(180);

		moi.afficherBilan();
		moi.afficherSolde();
		
		//Compte raouf = new Compte();
		Compte maison = madre.getCompte(1);
		maison.depot(150f);
		Compte etude = moi.getCompte(1);
		etude.depot(200f);
		
		banque cag = new banque();
		cag.ajouterClient(moi);
		cag.ajouterClient(madre);
				
		int[] ca = {1,2,5,4} ; // Pour Tester Comme un deuxieme code
		int[] ce = {6,8,7,8} ;
		
		Carte c1 = new Carte(ce,2,1,cag,d1);
		
		c1.codeValide(ca);
		
		Date DateJour = new Date(02,03,2022);
		
		Terminal verf = new Terminal(c1,DateJour);
		
		verf.genererAutorisation(c1, 950);
		
		
		/*c1.codeValide(cb);
		c1.codeValide(cc);
		c1.codeValide(ca);*/
		
		/*madre.afficherBilan();
		moi.afficherBilan();
		c1.payer(cag, 1, 1, 10f);
		madre.afficherBilan();
		moi.afficherBilan();*/
		
		 //System.out.println("La date de expiration est :"  + c1.getDateValide().toString());
		

	}

}