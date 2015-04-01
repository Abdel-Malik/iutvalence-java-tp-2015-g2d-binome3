package fr.iut.valence.td2d.projet.abalone;

/**Représentation d'un plateau. 
 * 
 * @author blouinm et bouhassa
 * @version 1.0
 */
public class Plateau {
	public final static int TAILLE_PLATEAU = 9;
	private final Case[][] plateau;
	
	/**Création d'un plateau
	 * 
	 */
	public Plateau(){
		this.plateau = new Case[TAILLE_PLATEAU][TAILLE_PLATEAU];
		this.initialisationPlateau();
	}
	
	/**Déplacer une boule.
	 * 
	 * @param depart la case de départ
	 * @param arrivee la case d'arrivée
	 */
	public void deplacerBoule(Case depart, Case arrivee){
		arrivee.poserBoule(depart.obtenirBoule());
		depart.enleverBoule();
	}
	
	/**Initialise un Plateau. 
	 * Rempli un plateau avec des cases
	 */
	private void initialisationPlateau(){
		for(int numeroDeLigne=0; numeroDeLigne < TAILLE_PLATEAU; numeroDeLigne++){
			for(int numeroDeColonne=0; numeroDeColonne < TAILLE_PLATEAU; numeroDeColonne++){
				this.plateau[numeroDeLigne][numeroDeColonne] = new Case(new Position(numeroDeLigne,numeroDeColonne));
			}
		}
	}
}
