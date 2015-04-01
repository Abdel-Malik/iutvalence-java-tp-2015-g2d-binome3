package fr.iut.valence.td2d.projet.abalone;

/**Modélisation des boules. 
 * 
 * @author blouinm et bouhassa
 * @version 1.0
 */
public class Boule {
	private final Couleur laCouleur;
	
	/**Création d'une boule de couleur souhaité. 
	 * 
	 * @param laCouleurVoulue
	 */
	public Boule(Couleur laCouleurVoulue){
		this.laCouleur=laCouleurVoulue;
	}
	/**Renvoie la couleur de la boule. 
	 * 
	 * @return la couleur de la boule
	 */
	public Couleur obtenirCouleur(){
		return this.laCouleur;
	}

}
