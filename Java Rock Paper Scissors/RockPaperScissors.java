public class RockPaperScissors
{
    private String personPlay;
    private String computerPlay;
    
    /**
     * constructs a RockPaperScissors object with a specified play for the
     * person playing the game.  If the specified play is invalid, the
     * person's play will default to "R".  Randomly picks a play for the computer.
     * @param person the person's play: R, P or S.
     */
    public RockPaperScissors(String person)
    {
        // Assign personPlay using the parameter.  Convert it to upper case.
        // If person is not a valid play ("R", "P", or "S"), make it "R".
        
        int computerInt = (int)(Math.random() * 3);  // computerInt is randomly 0, 1 or 2  - not tested in this chapter
        // Use a switch statement to assign computerPlay based on the random integer generated above
        // For example, if computerInt is 0, make the computerPlay "R".  1 => "P", 2 => "S"
        personPlay = person.toUpperCase();
        if (!(personPlay.equals("R") || personPlay.equals("S") || personPlay.equals("P")))
            personPlay = "R";
        switch(computerInt)
        {
            case 0:
                computerPlay = "R";
                break;
            case 1:
                computerPlay = "P";
                break;
            case 2:
                computerPlay = "S";
                break;
        }
    }
    
    /**
     * Returns the computer play
     * @return String the computer's play
     */
    public String getComputerPlay()
    {
        if(computerPlay.equals("R"))
            return "Computer plays Rock";
        else if (computerPlay.equals("S"))
            return "Computer plays Scissors";
        else
            return "Computer plays Paper";
    }
    
    /**
     * Returns the person's play
     * @return String the person's play
     */
    public String getPersonPlay()
    {
        if(personPlay.equals("R"))
            return "Person plays Rock";
        else if (personPlay.equals("S"))
            return "Person plays Scissors";
        else
            return "Person plays Paper";
    }
    
    
    /**
     * Returns a phrase describing the winner of the game based on
     * the rules, for instance:
     * "Rock crushes Scissors - computer wins!"
     * @return String the phrase describing the winner
     */
    public String getWinner()   // uses nested if..else
    {
        String winner = "";
        // Use nested if..else here.
        // Refer to the Test Case worksheet for the algorithm
        if(computerPlay.equals(personPlay))
        {
            if(computerPlay.equals("R"))
                winner = "It's a Rock tie!";
            else if (computerPlay.equals("S"))
                winner = "It's a Scissors tie!";
            else
                winner = "It's a Paper tie!";
        }
        else if (computerPlay.equals("R"))
        {
            if (personPlay.equals("S"))
                winner = "Rock crushes Scissors - computer wins!";
            else
                winner = "Paper covers Rock - Person wins!";
        }
        else if (computerPlay.equals("S"))
        {
            if (personPlay.equals("R"))
                winner = "Rock crushes Scissors - Person wins!";
            else
                winner = "Scissors cuts paper - Computer wins!";
        }
        else
        {
            if (personPlay.equals("R"))
                winner = "Paper covers Rock - Computer wins!";
            else
                winner = "Scissors cut Paper - Person wins!";
        }
        
        
        return winner;
    }
}