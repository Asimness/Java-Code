import java.util.Random;
import javax.swing.JOptionPane;

/**
 * Represents a player in the game of Nim.  The player is either human or computer.  
 * Humans are prompted for their plays. The computer plays randomly.
 */
public class Player
{
	public static final int COMPUTER = 0;
	public static final int HUMAN = 1;
	public static final int SMART = 2;
	
	private int type; // computer or human or smart 
	
	/**
	 * Constructs a player of type playerType.  0 is COMPUTER, 1 is HUMAN.  
	 * If playerType is not 0 or 1, type will be set to HUMAN.
	 * @param playerType type of player
	 */
	public Player(int playerType)
	{ 
		if (playerType == COMPUTER)
			type = COMPUTER;
		else if (playerType == SMART)
			type = SMART;
		else 
			type = HUMAN; 
	}
	
	/**
	 * Determines how many marbles are taken, and returns that number.  
	 * Human player will be asked how many marbles they want to take.  
	 * If the move is illegal, they will be asked again until they select a legal move.  
	 * The computer will take a random number of marbles between 1 and pileSize/2.
	 * @param pileSize the number of marbles in the pile
	 * @return the number of marbles taken by the player
	 */
	public int play(int pileSize)
	{
		Random r = new Random();
		int taken = 0;
		if (type == COMPUTER)
		{
			if (pileSize == 1)
			{
				taken = 1; 
			}
			else 
			{
				taken = r.nextInt(pileSize/2) + 1;
			}
			JOptionPane.showMessageDialog(null, "The computer took " + taken + " marbles.");
		}
		 else if(type == SMART)
		{	
			if (pileSize == 1)
			{
				taken = 1; 
			}
			else if(((pileSize+1) & ((pileSize+1) - 1)) == 0)
			{
				taken = r.nextInt(pileSize/2) + 1;
			}
			else 
			{
				int pwr = 0;
				int pwrs = 0;
				while(Math.pow(2,pwr) <= pileSize)
				{
					pwrs = (int) Math.pow(2,pwr);
					pwr++;
				}
				taken =  pileSize - (pwrs-1);	
			}	
			JOptionPane.showMessageDialog(null, "The computer took " + taken + " marbles.");
		}else 
		{
			boolean valid = false;
			
			do
			{
				String input = JOptionPane.showInputDialog("There are " + pileSize + " marbles left \nhow many will you take?");
				valid = Integer.parseInt(input) == 1 || Integer.parseInt(input) >=1 && Integer.parseInt(input) <= pileSize/2;
				if (valid)
				{
					taken = Integer.parseInt(input);
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "You must take between 1 and " + pileSize/2 + " marbles!"); 
				}
				
			}
			while (!valid);
		} 
		return taken; 
	}
}