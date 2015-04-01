package fr.iut.valence.td2d.projet.abalone;

/**
 * Plateau d'Abalone.
 *
 * @author blouinm et bouhassa
 * @version 1.0
 */
public class Plateau {
    /* TODO JAVADOC. */
    public static final int TAILLE_PLATEAU = 9;
    /* TODO JAVADOC. */
    private final Case[][] plateau;

    /** Création d'un plateau vide. */
    public Plateau() {
        this.plateau = new Case[TAILLE_PLATEAU][TAILLE_PLATEAU];
        this.initialisationPlateau();
    }

    /* TODO La méthode pourrait être "static" ce qui nous interroge sur la pertinence de la forme de cette méthode. */

    /**
     * Déplacer une boule.
     *
     * @param depart  Case de départ
     * @param arrivee Case d'arrivée
     */
    public void deplacerBoule(Case depart, Case arrivee) {
        arrivee.poserBoule(depart.obtenirBoule());
        depart.enleverBoule();
    }

    /**
     * Initialise un Plateau en le remplissant de cases.
     *
     * @see Case
     * @see Position
     */
    private void initialisationPlateau() {
        for (int numeroDeLigne = 0; numeroDeLigne < TAILLE_PLATEAU; numeroDeLigne++) {
            for (int numeroDeColonne = 0; numeroDeColonne < TAILLE_PLATEAU; numeroDeColonne++) {
                this.plateau[numeroDeLigne][numeroDeColonne] = new Case(new Position(numeroDeLigne, numeroDeColonne));
            }
        }
    }
}
