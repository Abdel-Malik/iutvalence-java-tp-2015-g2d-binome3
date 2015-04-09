package fr.iut.valence.tpdd.projet.abalone;

/* TODO Why do you introduce this wrapper around Color ? */
/* TODO Translate. */
/**
 * Boule sur le plateau.
 *
 * @author blouinm et bouhassa
 * @version 1.0
 */
/* TODO Translate. */
public class Boule {
    /* TODO JAVADOC. */
    private final Color laCouleur;

    /* TODO Translate. */
    /** Création d'une boule de couleur souhaitée. */
    public Boule(Color laCouleurVoulue) {
        this.laCouleur = laCouleurVoulue;
    }

    /** Renvoie la couleur de la boule. */
    public Color obtenirCouleur() {
        return this.laCouleur;
    }

}
