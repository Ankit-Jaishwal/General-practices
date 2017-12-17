class A {
	public A() {
	}

	public A(int x) {
	}
	
	public void A1(int x) {
		System.out.println("A1");
	}
}

class B extends A {
	public void A2(int x) {
		System.out.println("A2");
	}
}

public class test {
	public static void main(String args[]) {
		A a = new A();
		B b = (B)a;
		//System.out.println("complete");
		b.A1(0);

		System.out.println(b.getClass().equals(B.class));
	}
}