import java.util.Random;
import javax.swing.JOptionPane;

/**
 * Represents a game of Nim, where players take turns removing marbles from a pile.  
 * The player that takes the last marble loses the game.
 */
public class Nim
{
	public static final int COMPUTER = 0;
	public static final int HUMAN = 1;
	public static final int SMART = 2;
	
	private Player computer;
	private Player human;
	private Player smart; 
	private int marbleCount;
	private int turn;  			// whose turn it is
	private int winner;			
	
	/**
	 * Constructs a Nim game.  There are two players, one is the computer and the other is human.  
	 * The player who gets to go first is chosen at random.  The number of marbles in the pile is 
	 * generated randomly between 10 and 100.  A message is displayed showing how many marbles the
	 * starts with.  The contructor calls the play() method to start the game.
	 */ 
	public Nim()
	{
		Random rand = new Random();
		// assign values for all instance fields before play() is called
		String mode = JOptionPane.showInputDialog("Pick a mode [Smart or Normal]");
		if(mode.equalsIgnoreCase("smart"))
		{
			computer = new Player (SMART);
			human = new Player (HUMAN);
		}else 
		{
			computer = new Player (COMPUTER);
			human = new Player (HUMAN);
		}
		 
		turn = rand.nextInt(2);
	
		
		marbleCount = rand.nextInt(91) + 10;
		JOptionPane.showMessageDialog(null, "The game starts with " + marbleCount + " marbles.");
		
		winner = COMPUTER;
		
		play();
	}
	
	/**
	 * The play method continues game play until the pile is reduced to 0.  Whoever takes the last marble
	 * loses the game.  At the beginning of each play, the number of marbles left is displayed.  The player
	 * whose turn it is calls the Player play method, sending it the number of marbles left.  When the player
	 * takes marbles, the marbleCount is decreased.  When the marbles are gone, the winner of the game is 
	 * displayed.
	 */
	public void play()
	{
	
		while (marbleCount != 0)
		{
			if (turn == COMPUTER)
			{
				marbleCount -= computer.play(marbleCount);
				turn = HUMAN;
			}	else 
			{
				marbleCount -= human.play(marbleCount);
				turn = COMPUTER;
			}
			
		}
			if(turn == HUMAN)
			{
				winner = HUMAN;
			}
			else 
			{
				winner = COMPUTER;
			}
		
			
		// At the end of play (when the loop exits), the winner is displayed.  
		// Feel free to change the message to be more creative, but be nice!
		if (winner == COMPUTER)
			JOptionPane.showMessageDialog(null,"Computer wins!");
		else
			JOptionPane.showMessageDialog(null,"Human wins!");
	}
	
}