import javax.swing.tree.TreeNode;

import com.sun.corba.se.impl.orbutil.graph.Graph;


public class MultipleInheritenceTest extends aaa{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MultipleInheritenceTest bbb = new MultipleInheritenceTest();
		bbb.a1();
		
		Graph g ; TreeNode
	}

	public void a1() {
		// TODO Auto-generated method stub
		System.out.println("sdf");
	}

}


abstract class aaa{
	abstract void a1();
}

abstract class bb{
	abstract void a1();
}

abstract class cb{
	abstract void a1();
}