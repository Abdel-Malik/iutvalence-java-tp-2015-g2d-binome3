package fr.iut.valence.tpdd.projet.abalone;

/**
 * Launcher.
 *
 * @author blouinm and bouhassa
 * @version 1.0
 */
public class Application {
    /**
     * The 
     * @param args
     */
    public static void main(String[] args) {
    	Board board1 = new Board();
        System.out.println(board1);
        Player p1 = new Player(1,Color.BLACK,board1);
        p1.moveBall();
        
        
    }
}
