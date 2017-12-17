import java.util.Scanner;



public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        int r=5;//scan.nextInt();
		System.out.println("Numver of Points="+countPoints(r));
		
	}
	
	static int countPoints(int r)
	{
	    if (r <= 0)
	        return 0; 
	 
	    // Initialize result as 4 for (r, 0), (-r. 0),
	    // (0, r) and (0, -r)
	    int result = 4;
	 
	    // Check every value that can be potential x
	    for (int x=1; x<r; x++)
	    {
	        // Find a potential y
	        int ySquare = r*r - x*x;
	        int y = (int) Math.sqrt((double)ySquare);
	 
	        // checking whether square root is an integer
	        // or not. Count increments by 4 for four 
	        // different quadrant values
	        if (y*y == ySquare)
	            result += 4;
	    }
	 
	    return result;
	}

}
