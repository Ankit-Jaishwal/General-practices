import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import sun.net.www.content.audio.basic;
import sun.org.mozilla.javascript.internal.ObjArray;


 class ClazzTest {
	
//	E e;
//	P p;
	void say (List<String> s){
		System.out.println("parent");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Base> l1 = new ArrayList<Base>();
		l1.add(new Base());
		l1.add(new Child());
		todo(l1);
		
		List<Base> l2 = new ArrayList<Child>();
		l2.add(new Base());
		l2.add(new Child());
		
		List<Object> l3 = new ArrayList<Object>();
		l3.add(new Base());
		l3.add(new Child());
		todo(l3);
		
		List<? > l4 = new ArrayList<Base>();
		todo(l4);
//		l4.add(new Object());
//		l4.add(new Child());
		
		
	}
	
	static void todo(List<Base> list){
		
	}
	
	
static void todo1(List<?> list){
		Number n = null;
		list  = new ArrayList<Integer>();
		//list.add(new Number());
		list.add(Integer.valueOf(10));
		list.add(Float.valueOf(10));
		Number n1 = list.get(0);
		Object o = list.get(0);
		
		
	}
}

class Base extends Number {

	@Override
	public int intValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long longValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float floatValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double doubleValue() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

class Child extends Base{
	
}