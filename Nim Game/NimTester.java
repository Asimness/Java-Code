import javax.swing.JOptionPane;

/**
 * A class which uses the Nim class to play a marble game.
 */
public class NimTester
{
	/**
	 * The user is asked if they want to play the game of Nim.  Each time they play, they are asked if
	 * they want to play again, until they enter "no", "NO", "n" or "N".
	 */
	public static void main(String[] args)
	{
		boolean finished = false;
		Nim game;
		
		// There should be 2 different prompts. One before the while loop for the initial play (and they may not want to play at all).
		// Another in the loop for playing "again".
		
		String start = JOptionPane.showInputDialog("Would you like to play Nim? [yes or no]");
	//	String mode = JOptionPane.showInputDialog("Pick a mode [Smart or Normal]");	
		finished = start.equalsIgnoreCase("N") || start.equalsIgnoreCase("NO");
		
		while(!finished)
		{
			//if (mode.equalsIgnoreCase(SMART))
			game = new Nim();
			String playAgain = JOptionPane.showInputDialog("Would you like to play Nim again? [yes or no]");
			finished = 	playAgain.equalsIgnoreCase("N") || playAgain.equalsIgnoreCase("NO");
		}
		
		
		
		// After the loop exits, a farewell message is displayed:	
		JOptionPane.showMessageDialog(null,"Thanks for playing!");
	}
}