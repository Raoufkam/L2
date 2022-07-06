package package1;

public class MonHistoire {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//------- Partie 4 Une belle histoire pour tester -------------//
		System.out.println("\n -- Une belle histoire pour tester -- \n");		
		
		//**Creation classe Humain**
		Humain humain = new Humain("Prof","Porto",10);

		humain.direBonjour ();
		humain.boire ();
		
		//**Creation classe Commercant**
		Commercant commercant = new Commercant("Marchand", 35);

		commercant.direBonjour ();
		
		//**Creation classe Yakuza**
		Yakuza yakusa = new Yakuza("Yaku_le_noir",
		                        "biere",42, "WarSong");

		yakusa.direBonjour();
		yakusa.extorquer(commercant);

		//**Creation classe Ronin**
		Ronin ronin = new Ronin("Roro","sake",61);

		ronin.donner (10, commercant );
		ronin.provoquer(yakusa);
		ronin.direBonjour ();
		
		//**Creation classe Traitre**
		Traitre Najla = new Traitre("Najla","Oasis",100,"HarryPoter");
		
		Najla.direBonjourTraitre();
		Najla.faireGentil(90, commercant);
		Najla.extorquer(commercant);
		System.out.println("Maintenant j'ai : "+Najla.getArgent()+" sous");
		
		//-------Partie 5.2 les grand-mères---------------//
		System.out.println("\n -- Test de la parties des grand meres -- \n");
		
		//**Creation classe GrandMere**
		GrandMere mami = new GrandMere("Fatima","Tisane",20);
		mami.direBonjour();
		
		//**Faire des connaisance**
		mami.faireConnaissanceAvec(commercant);
		mami.faireConnaissanceAvec(yakusa);
		mami.faireConnaissanceAvec(ronin);
		mami.faireConnaissanceAvec(Najla);
		//**Partie Ragoter de la grandMere
		mami.ragoter();
		
	}

}
