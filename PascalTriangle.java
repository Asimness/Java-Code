
import java.util.*;
import java.io.*;

public class PascalTriangle{
	
	public static void main(String args[])throws Exception {
    	
    	BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
    	System.out.println ("Enter the length of pascals triangle");
    	String input = keyboard.readLine();
    	int in = Integer.parseInt(input);
    	
    	PT(in);
    }
	                             
	public static void PT(int n)
	{                           
		int[][] pt = new int[n][];
		
		for(int i = 0; i < n; i++)
		{
			pt[i] = new int[i+1];
			pt[i][0] = 1;
			for(int j = 1; j < i; j++)
			{
				pt[i][j] = pt[i - 1][j - 1] + pt[i-1][j];
			}
			pt[i][i] = 1;
		}
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < pt[i].length; j++){
				System.out.print(pt[i][j]);
			}
			System.out.println ();
		}
	}	
}