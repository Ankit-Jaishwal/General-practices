import java.io.IOException;

public class SqrtExample 
{
    public static void main(String [] args) 
    {
        double value = -9.0;
        //int [] a = {23,22,21,20,19};
        int a [] = new int[5];

        System.out.println( Math.sqrt(value));
        try {
			throw new IOException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
    
   static void a() throws IOException{
    	throw new IOException();
    }
}