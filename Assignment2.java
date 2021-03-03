/* 
 * Aaron Czulada, Tesean Ferguson, Carson Perry
 * SoftwareEngineering21 -
 * Assignment2.java
 * 
*/
import java.util.Scanner;

public class Assignment2 {

	static int x, y, n, k;
	static double z;

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.println("Fermat's Last Theorem:     x^n + y^n = z^n         n>2        10 <= x <= k        10 <= y <= k ");
		System.out.print("Enter value for n:");
		n = s.nextInt();
		System.out.print("Enter value for k:");
		k = s.nextInt();

		if (n < 3)
			return;
		else
			checkFremat(x, y, z, n);
			
	}

	/* TESEANS WORK
		// Returns the near miss of z:
	// The smaller value of equations z^n - (x^n + y^n) and (z+1)^n - (x^n + y^n)
		static int getNearMiss(int x, int y, double z, int n) {
		int zLo = abs(Math.pow(z, n) - (Math.pow(x, n) + Math.pow(y, n)));
		int zHi = abs(Math.pow((z + 1), n) - (Math.pow(x, n) + Math.pow(y, n)));
		return zLo < zHi ? zLo : zHi;
	}
	 */
	
	public static void checkFremat(int x, int y, double z, int n) {
		
		for (x = 10; x <= k; x++) {
			for (y = 10; y <= k; y++) {
				int xypower = (int) (Math.pow(x, n) + Math.pow(y, n));

				
				z = (int) Math.pow(xypower, 1.0 / n);

				
				int zpower = (int) (Math.pow((int) z, n));

				if (zpower == xypower) {
					
			        //System.out.println("Found an example at" + x + "^" + n + " + " + y + "^" + n + " = " + z + "^" + n);
					//System.out.println("                                        " + xypower + " = " + zpower);
					return;
				}
			}
		}
		System.out.println("No example found witihin the given range");
	}
}
