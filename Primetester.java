
import java.util.*;
import java.io.*;


public class Primetester{
	public static void main(String args[]) throws Exception{
    	
    	BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
    	System.out.println ("Enter an int greater than 2 ");
    	String input = keyboard.readLine();
    	int test = Integer.parseInt(input);
    	
    	primeTester(test);	
    	
    }
    
	public static void primeTester(int n)
	{
		boolean[] prime = new boolean[n + 1];
		int i;
		for(i = 2; i <= n; i++)
		{
			prime[i] = true;
			
		}
		
		for(int divisor = 2; divisor * divisor <= n; divisor++)
		{
			if(prime[divisor])
			{
				for(i = 2 * divisor; i <= n; i = i + divisor)
				{
					prime[i] = false; 
				}
			}
			
		}
		
		for (i = 2; i <= n; i++)
			{
				System.out.println (i + " " + prime[i]);
			}
	}
	
}