class Super 
{ 
    public int getLength() 
    {
        return new Integer(4); 
    } 
} 

public class Sub extends Super 
{ 
    public int getLength() 
    {
        return (5); 
    } 

    public static void main(String[] args) 
    { 
//        Super sooper = new Super(); 
//        Sub sub = new Sub(); 
//        System.out.println( 
//        sooper.getLength().toString() + "," + sub.getLength().toString() ); 
        int i = 1, j = -1; 
        switch (i) 
        {
            case  1: j = 1; /* Line 4 */
            case 2: j = 2; 
            default: j = 0; 
        } 
        System.out.println("j = " + j);
        int xi = (int) Math.random();
        System.out.println("xi = "+xi);
        
        boolean bool = true; 
        if(bool = false) /* Line 2 */
        {
            System.out.println("a"); 
        } 
        else if(bool) /* Line 6 */
        {
            System.out.println("b"); 
        } 
        else if(!bool) /* Line 10 */
        {
            System.out.println("c"); /* Line 12 */
        } 
        else 
        {
            System.out.println("d"); 
        }
    } 
}