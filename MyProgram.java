import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MyProgram 
{
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
    public static void throwit() throws RuntimeException 
    {
        throw new RuntimeException();
    }
    
    static <T> void a(Collection<T> dc, T t){
    	dc.add(t);
    }
    public static void main(String args[])
    {
    	List<Object> l = new LinkedList<Object>();
    	a(l,"hello");
    	
    	String a = new String("a");
    	String b = a;
//    	b = "a";
    			
    	//b = "b";
    	System.out.println(a.hashCode()+"---"+b.hashCode() + "--"+ (a == b));
    	
//        try 
//        {
//            System.out.println("Hello world ");
//            throwit();
//            System.out.println("Done with try block ");
//        }
//        finally 
//        {
//            System.out.println("Finally executing ");
//        }
    }
    
     native void a();
    
    
	public int findSecondHighest(List<Integer> list) {
		int highest = list.get(0);
		int secondHighest = list.get(0);

		for (int i = 1; i < list.size(); i++) {
			int item = list.get(i);
			if (item > highest) {
				secondHighest = highest;
				highest = item;
			} else if(item > secondHighest){
				secondHighest = item;
			}
		}
		return secondHighest;
	}
}