
public class ReverseNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	System.out.println(reverse(123, 0));
		
		int r = 0;
		int i =123;
		while(i != 0){
			r = r * 10 + i % 10;
			i = i/10;
		}
		
		System.out.println(reverse(5560079));
	}
	
	 static int reverse(int i){
		 if(i == 0){
			 return 0;
		 }
		 int last =  (i % 10 ) ;
		 
		 int rem_num = i/10;
		 int rem = reverse(i/10);
		 int len = length(rem_num);
		 
		 return last  * (int)Math.pow( (double)10.0, (double)len) + rem;
		
	}

	private static int length(int rem_num) {
		if(rem_num == 0) return 0;
		return length(rem_num/10)+1;
	}

}
