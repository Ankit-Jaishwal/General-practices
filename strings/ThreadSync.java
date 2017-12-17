package com.ankit.strings;

class TestClass{
	public static synchronized void printNum() {
		
		for (int i = 0; i < 1000; i++) {
			System.out.println(Thread.currentThread().getName() + ":\t" + i);
		/*	if(i  == 5){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
			//}
		}
	}
}

class PrintThread extends Thread{
	private final TestClass tc;
	
	public PrintThread(TestClass tc) {
		// TODO Auto-generated constructor stub
		this.tc = tc;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		tc.printNum();
	}
}

public class ThreadSync {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestClass obj1 = new TestClass();
		TestClass obj2 = new TestClass();
		
		Thread t1 = new PrintThread(obj1);
		Thread t2 = new PrintThread(obj2);
		
		t1.start();
		t2.start();
	}

}
