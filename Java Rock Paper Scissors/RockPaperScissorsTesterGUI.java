import javax.swing.JOptionPane;
import java.io.*;
import java.util.*;

/**
 * A class to test the RockPaperScissors class
 */
public class RockPaperScissorsTesterGUI
{
    /**
     * Tests methods of the RockPaperScissors class
     * @param args not used
     */
    public static void main(String[] args)
    {        
        boolean finished = false;
        while(!finished) {
            String userPlay = JOptionPane.showInputDialog("Rock, paper, or scissors?");
            if (userPlay.toUpperCase().equals("Q"))
                break;
            RockPaperScissors rps = new RockPaperScissors(userPlay);
            JOptionPane.showMessageDialog(null, rps.getComputerPlay() + "\n" + rps.getPersonPlay() + "\n" + rps.getWinner());
            rps.dealloc();
        }
        JOptionPane.showMessageDialog(null, "Thanks for playing!");
    }
}