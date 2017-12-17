import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;



class GenerelTesting {
	
	public static void main(String[] args) throws ParseException {
		System.out.println("inte");
		//getDate("2017", "11", "20", 15);
		System.out.println(getDayFromDateString("2017-11-19"));
		
	}

	public static void getDate(String yr, String month, String day, int daysToAdd){
		DateFormat dateFormat= new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, Integer.valueOf(day));
		cal.set(Calendar.MONTH, Integer.valueOf(month)-1);
		cal.set(Calendar.YEAR, Integer.valueOf(yr));
		cal.set(Calendar.HOUR_OF_DAY, 15);
		System.out.println(dateFormat.format(cal.getTime()));
		cal.add(Calendar.DATE, daysToAdd);
		System.out.println(dateFormat.format(cal.getTime()));
		
		
	}
	
	public static String getDayFromDateString(String date) throws ParseException {
		String[] arr = date.split("-");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, Integer.valueOf(arr[2]));
		cal.set(Calendar.MONTH, Integer.valueOf(arr[1])-1);
		cal.set(Calendar.YEAR, Integer.valueOf(arr[0]));
		int day = cal.getTime().getDay();
		if (day == 0) {
			day = 7;
		}
		return String.valueOf(day);
	}
	public static void main(Integer[] args) {
		// TODO Auto-generated method stub
		List<A> list = new ArrayList<A>();
		//A b = list.get(0);
		byte b = 1;
		short s = 1;
		int i = 1;
		long l = 1;
		double d= 1;
		a(5,5);
		
		Object x = new Object();
		int[] y = new int[6];

		y = (int[])x;
		
//		if(null == null)
//			System.out.println();
//		 
//		 short s = 0;
//		 int x = 07;
//		 int y = 07;
//		 int z = 123456;
//		 s+=z;
//		System.out.println( x+ y+"");
//		
//		System.out.println("try catch" + aaa());
		
	}

	static int aaa(){
		try {
			System.out.println("aaa");
			return 10;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("catch");
		}
		finally {
			System.out.println("finally");
			return 11;
		}
	}
	static void a(String d) {
		System.out.println("byte");
	}
	static void a(Integer d) {
		System.out.println("short");
	}
//	static void a(int d) {
//		System.out.println("int");
//	}
//	static void a(long s) {
//		System.out.println("long");
//	}
//	static void a(double s) {
//		System.out.println("double");
//	}
	static void a(int i, long l) {
		System.out.println("int");
	}
	
//	static void a(long i, int l) {
//		System.out.println("long");
//	}
	
}

//class A {
//	
//}
//
//class B extends A {
//	
//}
