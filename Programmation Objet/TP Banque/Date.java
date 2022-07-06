package Banque;

public class Date {
	
	private int jour ;
	private int mois ;
	private int an ;
	private int heure ;
	private int minute ;
	private int seconde ;
	

	/**
	 * @param jour
	 * @param mois
	 * @param an
	 */
	
	public Date(int jour, int mois, int an) {
		super();
		this.jour = jour;
		this.mois = mois;
		this.an = an;
	}


	/**
	 * @return the jour
	 */
	public int getJour() {
		return jour;
	}


	/**
	 * @return the mois
	 */
	public int getMois() {
		return mois;
	}


	/**
	 * @return the an
	 */
	public int getAn() {
		return an;
	}



	/**
	 * @return the heure
	 */
	public int getHeure() {
		return heure;
	}

	/**
	 * @return the minute
	 */
	public int getMinute() {
		return minute;
	}

	/**
	 * @return the seconde
	 */
	public int getSeconde() {
		return seconde;
	}

	@Override
	public String toString() {
		return "[" + heure + ":" + minute + ":" + seconde + " " + jour + "/" + mois
				+ "/" + an + "]";
	}

}