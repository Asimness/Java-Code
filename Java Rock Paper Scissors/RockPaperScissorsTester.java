import javax.swing.JOptionPane;
import java.io.*;
import java.util.*;

/**
 * A class to test the RockPaperScissors class
 */
public class RockPaperScissorsTester
{
    /**
     * Tests methods of the RockPaperScissors class
     * @param args not used
     */
    public static void main(String[] args)
    {        
        System.out.println("Play Rock Paper Scissors:");
        
        // Make a Scanner object, so you can get keyboard input
        Scanner in = new Scanner(System.in);
        
        // Prompt the user by displaying this prompt:  Enter your play: R, P, or S ==> 
        System.out.print("Enter your play: R, P, or S ==> ");
        
        // read the typed play into a String variable
        String play = in.next();
        
        // Make a RockPaperScissors object, sending it the entered play.  
        // Don't worry about case sensitivity here (r or R).  That is the constructor's job
        RockPaperScissors rps = new RockPaperScissors(play);
    
        // Print the computer's play with a label using the getComputerPlay() method
        System.out.println(rps.getComputerPlay());
        
        // Print the user's play with a label using the getPersonPlay() method
        System.out.println(rps.getPersonPlay());
    
        // Print the winner statement using the getWinner() method
        System.out.println(rps.getWinner());
    }
}