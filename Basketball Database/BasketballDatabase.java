import java.util.Scanner;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.awt.*;
import java.util.ArrayList;



public class BasketballDatabase
{
	public static void main(String args[]) throws IOException 
	{
    	Data myData = new Data();
    }
}


class Data extends JFrame implements ActionListener, MouseListener
{
	
	//window dimensions
	private static final int FRAME_WIDTH = 1350;
	private static final int FRAME_HEIGHT = 800;
	private static final int FRAME_X_ORIGIN = 50;
	private static final int FRAME_Y_ORIGIN = 50;
	
	//database
	private BasketballPlayers basketballList;
	
	//declare GUI elements
	private JLabel title, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve; 
	private JPanel left;
	private JTextArea display;
	private JMenuBar menuBar;
	private JMenu menu, helps;
	private JMenuItem save, load, quit,about;
	private JScrollPane scroller; 
	
	
	//
	public Data()
	{
		basketballList = new BasketballPlayers();
		//set up window
		setTitle("Golden State Warriros Players Database");
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setResizable(true);
		setLocation(FRAME_X_ORIGIN, FRAME_Y_ORIGIN);
		
		
		// set up the main display area and make it scrollable
 		display = new JTextArea();
 		display.setFont(new Font("Courier",Font.BOLD,12));
 		display.setEditable(false);
 		display.setBorder(BorderFactory.createLineBorder(Color.blue));	
 		scroller = new JScrollPane(display);
 		
		//set up the menu items
		title = new JLabel("         Menu:");
		two = new JLabel(" Add new basketball player ");
		three = new JLabel(" Search for a player by name ");
		four = new JLabel(" Show list of all players ");
		five = new JLabel(" Delete a player by name "); //requires a search
		six = new JLabel(" Sort team by age ");
		seven = new JLabel(" Sort team by points ");
		eight = new JLabel(" Points in season ");
		nine = new JLabel(" Average field goal percentage ");
		ten = new JLabel(" Partial Show players above a certain field goal percentage ");
		eleven = new JLabel(" Update Free Throw Percentage ");
		twelve = new JLabel (" Update Age ");
		//set up the menu bar
		

		menuBar = new JMenuBar();
			setJMenuBar(menuBar);	
			save = new JMenuItem("Save");
			load = new JMenuItem("Load");
			quit = new JMenuItem("Quit");	
			save.addActionListener(this);
			load.addActionListener(this);
			quit.addActionListener(this);	
			menu = new JMenu("File");
			menu.add(save);
			menu.add(load);
			menu.add(quit);	
			menuBar.add(menu);
			about = new JMenuItem("About");
			about.addActionListener(this);
			helps = new JMenu("Help");
			helps.add(about);
			menuBar.add(helps);	
			// Make the panel for the menu and add the menu items to it
			
			left = new JPanel();	
			left.add(title);
			left.add(two);
			left.add(three);
			left.add(four);
			left.add(five);
			left.add(six);
			left.add(seven);
			left.add(eight);
			left.add(nine);
			left.add(ten);
			left.add(eleven);
			left.add(twelve);
			
			left.setLayout(new GridLayout(5,2)); // the menu has 6 rows and 1 column
			
			setLayout(new GridLayout(2,1)); // the window has 1 row and two columns
			add(left);
			add(scroller); 
				
			//*** OR

			setLayout(new BorderLayout()); // sets the layout so you can put things in the North, South, East
											// West or Center
			
			add(left, BorderLayout.NORTH); // add the menu to the left
			add(scroller, BorderLayout.CENTER); // add the text area to center, which takes up any unused space
			
			// make all of the menu items listen
			two.addMouseListener(this);
			three.addMouseListener(this);
			four.addMouseListener(this);
			five.addMouseListener(this);
			six.addMouseListener(this);
			seven.addMouseListener(this);
			eight.addMouseListener(this);
			nine.addMouseListener(this);
			ten.addMouseListener(this);
			eleven.addMouseListener(this);
			twelve.addMouseListener(this);
			
			
			// when the user clicks the X in the top right corner, the program will exit
			
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setVisible(true); // make it visible LAST
		}
		/**
		 * required by the MouseListener interface.  Invoked when the mouse is clicked.
		 * @param e the MouseEvent that triggered the method
		 */
		public void mouseClicked(MouseEvent e)
		{
			// nothing needed, but method required by interface
		}
		/**
		 * required by the MouseListener interface.  Invoked when the mouse is released.
		 * @param e the MouseEvent that triggered the method
		 */
		public void mouseReleased(MouseEvent e)
		{
			// nothing needed, but method required by interface
		}
		/**
		 * required by the MouseListener interface.  Invoked when no mouse buttons are clicked and 
		 * the mouse pointer enters a particular gui element.  In this implementation, if the mouse
		 * pointer enters one of the menu labels, the label is set to red.
		 * @param e the MouseEvent that triggered the method
		 */
		public void mouseEntered(MouseEvent e)
		{
			JLabel label = (JLabel) e.getSource();
			label.setForeground(Color.blue);
		}
		/**
		 * required by the MouseListener interface.  Invoked when no mouse buttons are clicked and 
		 * the mouse pointer leaves a particular gui element.  In this implementation, if the mouse
		 * pointer leaves one of the menu labels, the label is set to back to black.
		 * @param e the MouseEvent that triggered the method
		 */
		public void mouseExited(MouseEvent e)
		{
			JLabel label = (JLabel) e.getSource();
			label.setForeground(Color.black);
		}
		
		//	
		/**
		 * required by the MouseListener interface.  Invoked when the left mouse button is pressed.
		 * In this implementation, if the mouse is pressed on a particular labels, that menu item
		 * is invoked.
		 * @param e the MouseEvent that triggered the method
		 */
		public void mousePressed(MouseEvent e) 
		{
	    	String name;
    		int age;
    		int gamesPlayed;
   		    double averageMinutes;
    		double averagePoints;
   		    double fieldGoal;
    		double threePoint;
   		    double freeThrow;
    		double rebounds;
    		double steals; 
					
			JLabel label = (JLabel) e.getSource();
			
			if (label.equals(two)) // Add a player to the database
			{
					display.setText(""); // optional.. empties out the text area
					name = JOptionPane.showInputDialog("Enter the name of the player");
					age = Integer.parseInt(JOptionPane.showInputDialog("Enter the player's Age"));
					gamesPlayed = Integer.parseInt(JOptionPane.showInputDialog("Enter the amount of games the Player played"));
					averageMinutes = Double.parseDouble(JOptionPane.showInputDialog("Enter the player's average minutes per game"));
					averagePoints = Double.parseDouble(JOptionPane.showInputDialog("Enter the player's average points per game"));
					fieldGoal = Double.parseDouble(JOptionPane.showInputDialog("Enter the player's field goal percentage"));
					threePoint = Double.parseDouble(JOptionPane.showInputDialog("Enter the player's three point percentage"));
					freeThrow = Double.parseDouble(JOptionPane.showInputDialog("Enter the player's free throw percentage"));
					rebounds = Double.parseDouble(JOptionPane.showInputDialog("Enter the player's rebounds per game"));
					steals = Double.parseDouble(JOptionPane.showInputDialog("Enter the player's steals per game"));
			
					// *** create a new player and add it to the database
					basketballList.addPlayer(new Player(name, age, gamesPlayed, averageMinutes, averagePoints, fieldGoal, threePoint, freeThrow, rebounds, steals));
					showList(); // updates the window with the contents of the whole database			
			}
			else if (label.equals(three)) // Find a player.
			{
					name = JOptionPane.showInputDialog("Player you are looking for");
					Player i = basketballList.findPlayer(new Player(name));
					if(i == null)
					{
						showList();
						JOptionPane.showMessageDialog(null,"" + name + " does not exist in the database. ");
					}
						
					else
						showItem(i);
			}
			else if (label.equals(four)) // Display the database contents.
			{
				showList();
			}
			else if (label.equals(five)) // Remove an item
			{
				name = JOptionPane.showInputDialog("Player to remove");
				if (basketballList.removePlayer(new Player(name)))
					JOptionPane.showMessageDialog(null,name + " has been removed from your database.");
				else
					JOptionPane.showMessageDialog(null,"" + name + " does not exist.");
				showList();
			}
			else if (label.equals(six))  // sort alphabetically
			{				
				basketballList.sortAge();
				showList();
			}
			else if (label.equals(seven))
			{
				basketballList.sortPoints();
				showList();
			}
			else if (label.equals(eight))
			{
			
					int result = 0;
 					for(int i = 0; i < basketballList.getList().size() || i == 0; i++)
 					result += (int) (basketballList.getList().get(i).getGamesPlayed() * basketballList.getList().get(i).getAveragePoints());
					JOptionPane.showMessageDialog(null," Teams point's in season: " + result);
					
			}
			else if(label.equals(nine))
			{
				double temp = 0;
 					for(Player i: basketballList.getList())
 						{
 							temp += i.getFieldGoal();
 						}	
 				double op = temp/basketballList.getList().size();
 				String output = String.format("%.2f", op);
 				JOptionPane.showMessageDialog(null," The teams point's field goal percentage: " + output + "%");
				
			}
			else if(label.equals(ten))
			{
				double fieldGoalPercentage = Double.parseDouble(JOptionPane.showInputDialog("Enter a field goal percentage"));
				if(basketballList.showFieldGoals(fieldGoalPercentage).toString() != "")
					showFieldGoalList(basketballList.showFieldGoals(fieldGoalPercentage));
				else{
					display.setText("");
					JOptionPane.showMessageDialog(null, "There are no players that have a higher field goal percentage.");
				}
				
			}
			else if(label.equals(eleven))//ft%
			{
				
					name = JOptionPane.showInputDialog("Player you are looking for");
					Player i = basketballList.findPlayer(new Player(name));
					if(i == null)
					{
						showList();
						JOptionPane.showMessageDialog(null,"" + name + " does not exist in the database. ");
					}
					else
					{
						double newFreeThrow = Double.parseDouble(JOptionPane.showInputDialog("New FT%?"));
						basketballList.findPlayer(i).setFreeThrow(newFreeThrow);
					}
					//showItem(i);
					showList();
			}
			else if (label.equals(twelve))//age
			{
		
					name = JOptionPane.showInputDialog("Player you are looking for");
					Player i = basketballList.findPlayer(new Player(name));
					if(i == null)
					{
						showList();
						JOptionPane.showMessageDialog(null,"" + name + " does not exist in the database. ");
					}
						
					else
					{
							int newAge = Integer.parseInt(JOptionPane.showInputDialog("New Age?"));
							basketballList.findPlayer(i).setAge(newAge);
					}
					//	showItem(i);
					showList();
			}	    
		}
		
		/**
		 * actionPerformed is required by the ActionListener interface.  
		 * It is invoked whenever one of the menu items is selected.
		 * The possible menu items that can be activated are quit, save and load.
		 * @param e the ActionEvent that triggered the method
		 */
		public void actionPerformed(ActionEvent e)
		{
			String menuName = e.getActionCommand();
			
			if (menuName.equals("Quit"))
				System.exit(0);
			else if (menuName.equals("Save"))
			{
				basketballList.saveToFile();
			}
			else if (menuName.equals("Load"))
			{
				display.setText("");// clear the display window
				try
				{
						basketballList.loadFromFile();
				}
				catch(IOException a){}
				showList();
			}
			else if (menuName.equals("About"))
			{
				display.setText("About:\n\n  This program allows the user to maintain a database pertaining to several basketball statistics of the players on the Golden State Warriors. \n  It keeps track of the current roster of players on the Golden State Warriors and data about their play.\n  The database keeps track of the players of the Golden State Warriors by name. \n  Each record contains the following information: \n  Player Name, Age, Games Played, Average Minutes per Game, Points per Game, Field Goal %, Three Point %, Free Throw %, Rebounds, and Steals.\n\n Basic:\n\n  Basic functions include adding a new player to the database, deleting a player and all his statistics, searching for a player by name, \n  updating the free throw percentage or age of a player, and displaying a list of all players in the database including all their statistics and information listed above. \n  In addition to this a user may load and save databases. \n\n Sorts: \n\n  The Basketball Player Database also has two sort functions. The program is able to sort the database by age (ascending) \n  and it is able to sort the database by average points per game (descending).\n\n Calculations: \n\n  The database is also capable of two kinds of calculations. One of the calculations allows a user to calculate the total number of points scored by the team. \n  The other calculation determines the average field goal percentage of the team.\n\n Partial Show:\n\n  The Basketball Player Database also allows a user to display a partial list of players who have above a certain field goal percentage");
			}
		}
		
		
		/**
		 * displays the cart contents in the display pane
		 */
		 private void showList()
		{
			display.setText("Database Contents:\n" + 
					String.format("%-30s%-14s%-23s%-26s%-25s%-21s%-23s%-23s%-17s%-15s\n","Full Name", "Age", "Games Played", "Average Minutes", "Average Points", "Field Goal %", "Three Point %", "Free Throw %", "Rebounds", "Steals")+
    				basketballList.toString());
		}
		
		private void showItem(Player i)
		{
			display.setText("Found Item:\n" + 
					String.format("%-30s%-14s%-23s%-26s%-25s%-21s%-23s%-23s%-17s%-15s\n","Full Name", "Age", "Games Played", "Average Minutes", "Average Points", "Field Goal %", "Three Point %", "Free Throw %", "Rebounds", "Steals")+
    				i.toString());
		}
		private void showFieldGoalList(BasketballPlayers p)
		{
			display.setText("Found Country:\n" + 
					String.format("%-30s%-14s%-23s%-26s%-25s%-21s%-23s%-23s%-17s%-15s\n","Full Name", "Age", "Games Played", "Average Minutes", "Average Points", "Field Goal %", "Three Point %", "Free Throw %", "Rebounds", "Steals")+
    				p.toString());
    	}
		
		
	//need this one 		
	}
	
	
