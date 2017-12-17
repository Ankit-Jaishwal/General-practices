import java.util.HashSet;
import java.util.Iterator;


public class Test123 {
	
	
	private Test123() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	final public static void main(String[] args) {
		// TODO Auto-generated method stub
//		strictfp is a keyword
		
		String[] s = new String[12];
		System.out.println(s[2]+"sfds");
		
		
		String str = "aabcccaaacdeffffffghij";
		Object obj = new Object() 
	    {
	        public int hashCode() 
	        {
	            return 42;
	        }
	    }; 
		HashSet<Integer> hashSet = new HashSet<Integer>();

	    hashSet.add(2);
	    hashSet.add(5);
	    hashSet.add(1);
	 hashSet.add(null); // will throw null pointer 
	    hashSet.add(999);
	    hashSet.add(10);
	    hashSet.add(10);
	    hashSet.add(11);
	    hashSet.add(9);
	    hashSet.add(10);
	    hashSet.add(000);
	    hashSet.add(999);
	    hashSet.add(0);

	    Iterator<Integer> it = hashSet.iterator();
	    while(it.hasNext()){
	        Integer i = it.next();
	        System.out.print(i+" ");
	    }
	}

}


//class A11 extends Test123 {
////	public A11() {
////		super();
////		// TODO Auto-generated constructor stub
////	}
//}