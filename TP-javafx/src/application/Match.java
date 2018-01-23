package application;

public class Match {

	String phase;
	String adversaire;
	String composition[];
	String sRes = " ";
	

	public Match(String phase, String adversaire,String[] composition) {

		this.phase = phase;
		this.adversaire = adversaire;
		this.composition = composition;
		
			
		}
	

	public String getPhase() {
		return phase;
	}

	public String getAdversaire() {
		return adversaire;
	}

	public String getComposition() {
		for (String s : composition) {
			 sRes += "-"+s;
		}
		return sRes;
	}
	

}
