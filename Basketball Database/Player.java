

public class Player
{
	private String name;
   	private int age;
   	private int gamesPlayed;
    private double averageMinutes;
    private double averagePoints;
    private double fieldGoal;
    private double threePoint;
    private double freeThrow;
    private double rebounds;
    private double steals; 
	

	public Player(String pName)
	{
		name = pName;
		age = 0;
		gamesPlayed = 0;
		averageMinutes = 0;
		averagePoints = 0;
		fieldGoal = 0;
		threePoint = 0;
		freeThrow = 0;
		rebounds = 0;
		steals = 0;
	}
	
	public Player (String pName, int a, int gp, double am, double ap, double fg, double tp, double ft, double r, double s)
    {
		name = pName;
		age = a;
		gamesPlayed = gp;
		averageMinutes = am;
		averagePoints = ap;
		fieldGoal = fg;
		threePoint = tp;
		freeThrow = ft;
		rebounds = r;
		steals = s;
    }
    
	public Player()
    {
    	name = "";
    	age = 0;
		gamesPlayed = 0;
		averageMinutes = 0;
		averagePoints = 0;
		fieldGoal = 0;
		threePoint = 0;
		freeThrow = 0;
		rebounds = 0;
		steals = 0;
    } 
    	
    public String toString()
    {
    	return String.format("%-31s%2d%23d%26.2f%25.2f%23.2f%22.2f%22.2f%19.2f%15.2f", name, age, gamesPlayed, averageMinutes, averagePoints, fieldGoal, threePoint, freeThrow, rebounds, steals);
    }  
 
 //   	
    public String getName()
    {
    	return name;
    }
    
    public String setName(String Name)
    {
    	return this.name = name;
    }
 //
 //
 	public int getAge()
 	{
 		return age;
 	}  
  
  	public int setAge(int age)
  	{
  		return this.age = age;
  	}
  //
  //
  	public int getGamesPlayed()
  	{
  		return gamesPlayed;
  	}
  	
  	public int setGamesPlayed(int gamesPlayed)
  	{
  		return this.gamesPlayed = gamesPlayed;
  	}
  //
  //
  	public double getAverageMinutes()
  	{
  		return averageMinutes;
  	}
  	
  	public double setAverageMinutes(double averageMinutes)
  	{
  		return this.averageMinutes = averageMinutes;
  	}
  //
  // 
  	public double getAveragePoints()
  	{
  		return averagePoints;
  	}
  	
  	public double setAveragePoints(double averagePoints)
  	{
  		return this.averagePoints = averagePoints;
  	}
  //
  //
  	public double getFieldGoal()
  	{
  		return fieldGoal;
  	}
  	
  	public double setFieldGoal(double fieldGoal)
  	{
  		return this.fieldGoal = fieldGoal; 
  	}
  //
  //
  	public double getThreePoint()
  	{
  		return threePoint;
  	}
  	
  	public double setThreePoint(double threePoint)
  	{
  		return this.threePoint = threePoint;
  	}
  //
  //
  	public double getFreeThrow()
  	{
  		return freeThrow;
  	}
  	
  	public double setFreeThrow(double freeThrow)
  	{
  		return this.freeThrow = freeThrow;
  	}
  //
  //
  	public double getRebounds()
  	{
  		return rebounds;
  	}
  	
  	public double setRebounds(double rebounds)
  	{
  		return this.rebounds = rebounds;
  	}
  //
  //
 	public double getSteals()
 	{
 		return steals;
 	}
 	
 	public double setSteals(double steals)
 	{
 		return this.steals = steals;
 	}
  //
  //
  //
  	public boolean equals(Object o)
  	{
  		Player temp = (Player) o;
  		return this.getName().equalsIgnoreCase(temp.name);
  	}
  //
  //
  	public int compareTo(Object o)
  	{
  		Player temp = (Player) o;
  		return name.compareTo(temp.name);
  	}
  
  }