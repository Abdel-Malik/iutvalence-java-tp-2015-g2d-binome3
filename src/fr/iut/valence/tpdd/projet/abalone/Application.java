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
        //Position testD = new Position(0,0);
        //Position testA = new Position(5,5);
        //first.moveBall(testD, testA);
        //first.getBoard().getCase(testD).removeBall();
        /*while(true){
        first.selectBall();*/
    	
        Player p1 = new Player(1,Color.WHITE);
        Player p2 = new Player(2,Color.BLACK);
        Game first = new Game(p1,p2);
		first.launchGame();
		
    }
}
