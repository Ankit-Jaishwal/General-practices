import java.text.DateFormat;
import java.util.Date;

class Test1 
{
	public static void main(String [] args) 
    {
		
		
        try 
        {
            //badMethod();  
            System.out.print("A"); 
        }  
        catch (Exception ex) 
        {
            System.out.print("B");  
        } 
        finally 
        {
            System.out.print("C"); 
        } 
        System.out.print("D"); 
    }  
    public static void badMethod() 
    {
        throw new Error(); /* Line 22 */
    } 
}



 class Test 
{ 
    public static void main(String[] args) 
    {
        final StringBuffer a = new StringBuffer(); 
        final StringBuffer b = new StringBuffer(); 

        new Thread() 
        { 
            public void run() 
            {
                System.out.print(a.append("A")); 
                synchronized(b) 
                { 
                    System.out.print(b.append("B")); 
                } 
            } 
        }.start(); 
            
        new Thread() 
        {
            public void run() 
            {
                System.out.print(b.append("C")); 
                synchronized(a) 
                {
                    System.out.print(a.append("D")); 
                } 
            } 
        }.start(); 
    } 
}