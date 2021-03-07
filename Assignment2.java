/* 
 * Aaron Czulada, Tesean Ferguson, Carson Perry
 * czuladaa@duq.edu fergusont@duq.edu perryc@duq.edu
 * SoftwareEngineering21 -
 * Assignment2.java
 * March 7. 2021
 * This program looks at Fremat's Theorem and calculates near misses based on the user's input of n and k, and figures out the
 * closest near miss in the range 
 * 
*/
import java.text.DecimalFormat;
import java.util.Scanner;

public class Assignment2 {

	static int x, y, n, k;
	static double z;
	private static DecimalFormat df2 = new DecimalFormat("#.##");

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.println("Fermat's Last Theorem:     x^n + y^n = z^n         n>2        10 <= x <= k        10 <= y <= k ");
		
		while(n < 3 || n > 13) {
			System.out.print("Enter value for n:");
			n = s.nextInt();
		}
		
		System.out.print("Enter value for k:");
		k = s.nextInt();
		
		
		checkFremat(x, y, z, n);
			
	}

	// TESEANS WORK
		// Returns the near miss of z:
	// The smaller value of equations z^n - (x^n + y^n) and (z+1)^n - (x^n + y^n)
	static int getNearMiss(int x, int y, double z, int n) {
		int zLo = (int)Math.abs(Math.pow(z, n) - (Math.pow(x, n) + Math.pow(y, n)));
		int zHi = (int)Math.abs(Math.pow((z + 1), n) - (Math.pow(x, n) + Math.pow(y, n)));
		return zLo < zHi ? zLo : zHi;
	}
	 
	/*
	 * This is the method in which we go through every possibly x y combination and check to see if there is a near miss
	 * The near misses are designated by less than 100, if it is, it outputs the near miss and the details of the numbers
	 * As well as outputs the closest near miss at the end
	 */
	
	public static void checkFremat(int x, int y, double z, int n) {
		int lowestMiss = Integer.MAX_VALUE, currentMiss;
		for (x = 10; x <= k; x++) {
			for (y = 10; y <= k; y++) {
				
				
				int xypower = (int) (Math.pow(x, n) + Math.pow(y, n));
				z = (int) Math.pow(xypower, 1.0 / n);
				
				//Gets the near miss for the x,y,z combination, if lower than the lowest miss, switches them out
				currentMiss = getNearMiss(x,y,z,n);
				
				if(currentMiss < lowestMiss) {
					lowestMiss = currentMiss;
					
				}
				
				//Output for a near miss when found
				if(currentMiss < 100) {
					System.out.println("A near miss was found at x: " + x + " y: " + y  + " z: " + z);
					System.out.println("Actual Miss: " + currentMiss + " Relative miss:" + df2.format(((double)currentMiss / (double)z)));
					System.out.println();
				}
				
				/*
				int zpower = (int) (Math.pow((int) z, n));
				
				if (zpower == xypower) {
					
			        System.out.println("Found an example at" + x + "^" + n + " + " + y + "^" + n + " = " + z + "^" + n);
					System.out.println("                                        " + xypower + " = " + zpower);
					return;
				}*/
			}
		}
		
		if(lowestMiss > 100) {
			System.out.println("There were no close near miss found.");
		}
		System.out.println("The lowest near miss is " + lowestMiss);
	}
}