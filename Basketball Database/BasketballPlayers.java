
 import java.util.ArrayList;
 import java.io.*;
 import java.util.Scanner;
 import javax.swing.JFileChooser;
 import javax.swing.*;
 
 public class BasketballPlayers
 {
 	private ArrayList <Player> database;
 	//
 	
 	public BasketballPlayers()
 	{
 		database = new ArrayList <Player>();
 	}
 	//
 	
 	public void emptyDatabase(){database.clear();}
 	//
 	
 	public void addPlayer(Player name)
 	{
 		database.add(name);
 	}
 	//
 	
 	public String toString()
 	{
 		String out = "";
 		for(Player i: database)
 			out += i + "\n";
 			return out;
 	}
 	//
 	
 	public Player findPlayer(Player name)
 	{
 		int index = database.indexOf(name);
 		if(index == -1)
 			return null;
 			else 
 			return database.get(index);
 	}
 	//
 	
 	public boolean removePlayer(Player name)
 	{
 		int index = database.indexOf(name);
 		if(index == -1)
 			return false;
 		else {
 			database.remove(index);
 			return true;
 		}
 	}
 	//
 	
 	public void saveToFile()
 	{
 		String fileName = JOptionPane.showInputDialog("Enter the file name");
    	try
    	{
    		PrintWriter out = new PrintWriter(fileName);
	    	for(Player p: database)
	    	{
	    		out.println(p.getName());
	    		out.println(p.getAge());
	    		out.println(p.getGamesPlayed());
	    		out.println(p.getAverageMinutes());
	    		out.println(p.getAveragePoints());
	    		out.println(p.getFieldGoal());
	    		out.println(p.getFreeThrow());
	    		out.println(p.getRebounds());
	    		out.println(p.getSteals());
	    		out.println(p.getThreePoint());
	    	}
	    	out.close();
    	}
    	catch(IOException exception)
    	{
    		System.out.println("File problem - could not save");
    	}
 		
 	}
 	//
 	
 	public void loadFromFile() throws IOException
 	{
 		emptyDatabase();
    	JFileChooser chooser = new JFileChooser();
    	chooser.requestFocus();
    	File infile = null;
    	if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
	   	  {
	   	  	infile = chooser.getSelectedFile();
	   	  	
	   	  }
	   	Scanner in = new Scanner(infile);
	   	while(in.hasNext())
	   	{
	   		String name = in.nextLine();
	   		int age = in.nextInt();
	   		int gamesPlayed = in.nextInt();
	   		double avgMin = in.nextDouble();
	   		double avgPts = in.nextDouble();
	   		double FG = in.nextDouble();
	   		double FT = in.nextDouble();
	   		double Reb = in.nextDouble();
	   		double Steals = in.nextDouble();
	   		double TP = in.nextDouble();
	   		addPlayer(new Player(name, age, gamesPlayed, avgMin, avgPts, FG, TP, FT, Reb, Steals));
	   		in.nextLine();

	   	}
	   	in.close();
 	}
 	//
 	
 	public BasketballPlayers showAll()
 	{
 		BasketballPlayers tempList = new BasketballPlayers();
 		for(Player i: database)
 		{
 				tempList.addPlayer(i);	
 		}
 		return tempList;
 	}
 	//
 	
 	public BasketballPlayers showFieldGoals(double fg)
 	{
 		BasketballPlayers tempList = new BasketballPlayers();
 		for(Player i: database)
 		{
 			if(i.getFieldGoal() > fg)
 			{
 				tempList.addPlayer(i);
 			}
 		}
 		return tempList;
 	}
 	//
 	
 	public void sortPoints()
 	{
 		boolean sorted = false;
 		int p = 1;
 		while(!sorted)
 		{
 			sorted = true;
 			for(int index = 0; index < database.size()-p; index++)
 			{
 				if(database.get(index).getAveragePoints() < database.get(index + 1).getAveragePoints())
 				{
 					sorted = false;
 					Player temp = database.get(index);
 					database.set(index, database.get(index +1));
 					database.set(index + 1, temp);
 				}
 			}
 		}
 		
 	}
 	//
 	
 	public void sortAge()
 	{
 		boolean sorted = false;
 		int p = 1;
 		while(!sorted)
 		{
 			sorted = true;
 			for(int index = 0; index < database.size()-p; index++)
 			{
 				if(database.get(index).getAge() > database.get(index + 1).getAge())
 				{
 					sorted = false;
 					Player temp = database.get(index);
 					database.set(index, database.get(index +1));
 					database.set(index + 1, temp);
 				}
 			}
 		}
 	}
 	//
 	
// 	public int pointsInSeason()
// 	{
// 		int result = 0;
// 		for(Player i: database)
// 			result += (int) (i.getGamesPlayed() * i.getAveragePoints());
// 		return result;
// 	}
 	//
 	
 	public void updateFreeThrowPercentage(Player name, double freeThrowPercentage)
 	{
 	//	database.findPlayer(name).setFreeThrow(freeThrowPercentage);
 	}
 	//
 	
// 	public double averageFieldGoalPercentage()
// 	{
// 		double temp = 0;
// 		for(Player i: database)
// 		{
// 			temp += i.getFieldGoal();
// 		}	
// 		return temp/ database.size();
// 	}
 	//
 	
 	public void updateAgeOfPlayer(Player name, int newAge)
 	{
 		//
 	}
 	
 	public ArrayList<Player> getList()
 	{
 		return database;
 	}	
 		
 		
 		
 		
 }