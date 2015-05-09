package fr.iut.valence.tpdd.projet.abalone;

/**
 * Position (x and y).
 *
 * @author blouinm and bouhassa
 * @version 1.0
 * @see Case
 */
public class Position {

    /** Position in axe-X of the point. */
    private final int abscissa;

    /** Position in axe-Y of the point. */
    private final int ordinate;

    /**Create a new position.
     * 
     * @param x abscissa
     * @param y ordinate
     */
    public Position(int x, int y) {
        this.abscissa = x;
        this.ordinate = y;
    }

    /**
     * Return the abscissa.
     *
     * @return abscissa of the position.
     */
    public int getAbscissa() {
        return this.abscissa;
    }

    /**
     * Return ordinate.
     *
     * @return ordinate of the position.
     */
    public int getOrdinate() {
        return this.ordinate;
    }   
    
    @Override
    public String toString(){
    	String representation ="";
    	representation += "("+(char)(this.getAbscissa()+65)+","+(this.getOrdinate()+1)+") ";
    	return representation;
    }
}
