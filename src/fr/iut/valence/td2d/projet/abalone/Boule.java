package fr.iut.valence.td2d.projet.abalone;

/* TODO Pourquoi cette intermédiaire à Couleur ? */

/**
 * Boule sur le plateau.
 *
 * @author blouinm et bouhassa
 * @version 1.0
 */
public class Boule {
    /* TODO JAVADOC. */
    private final Couleur laCouleur;

    /**
     * Création d'une boule de couleur souhaitée.
     */
    public Boule(Couleur laCouleurVoulue) {
        this.laCouleur = laCouleurVoulue;
    }

    /**
     * Renvoie la couleur de la boule.
     *
     * @return la couleur de la boule
     */
    public Couleur obtenirCouleur() {
        return this.laCouleur;
    }

}
