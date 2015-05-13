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
    	
        Player p1 = new Player(1,Color.BLACK);
        Player p2 = new Player(2,Color.WHITE);
        Game first = new Game(p1,p2);
        System.out.println(first.getBoard());
        while(true){
        	System.out.println("\nTurn : "+(first.getNbTurn()+1)+"\nPlayer "+first.getCurrentPlayer().getPlayerNumber());
        	first.increaseNbTurn();
        	try{
        		first.nbBall();
        	} catch (WrongBallSelectedException e) {
				System.out.println("Wrong ball selected, retry...");
				continue;
			}
        	System.out.println(first.getBoard());
        	first.changeCurrentPlayer();
        }
    }
}
