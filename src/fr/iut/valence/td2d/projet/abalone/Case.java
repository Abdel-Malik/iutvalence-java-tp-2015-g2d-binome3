package fr.iut.valence.td2d.projet.abalone;

/**Modélisation des cases du plateau. 
 * @author blouinm et bouhassa
 * @version 1.0
 */
public class Case {
	
	private final Position positionCase;
	private Couleur couleurDeCase;
	
	/**Constructeur de cases.
	 * 
	 * @param position
	 */
	public Case(Position position){
		this.positionCase = position;
	}
	
	/**Poser une boule.
	 * 
	 * @param couleur = couleur de la boule
	 */
	public void poserBoule(Couleur couleur){
		this.couleurDeCase = couleur;
	}
	
	/**Enlever une boule. 
	 * 
	 */
	public void enleverBoule(){
		this.couleurDeCase = Couleur.AUTRE;
	}
	
	/**Renvoie la boule de la case.
	 * 
	 * @return la boule contenu par la case
	 */
	public Couleur obtenirBoule(){
		return this.couleurDeCase;
	}
	
	/**Renvoie la position de la case.
	 * 
	 * @return la position de la case
	 */
	public Position obtenirPosition(){
		return this.positionCase;
	}
}
