
public class T1 extends Thread{
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//super.run();
		System.out.println("run");
		foo();
	}
	
	private void foo() {
		// TODO Auto-generated method stub
		System.out.println("foo");
		
	}

	public static void main(String[] args) {
		T1 t1 = new T1();
		//T1 t2 = new T1();
		
		//t1.stop();
		t1.start();
		//t2.start();
		t1.run();
		
		
	}

}


