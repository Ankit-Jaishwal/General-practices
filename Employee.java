
public class Employee implements Comparable<Employee> {

	private int id;
	private String name;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Employee o) {
		// Comparing first based on ID, then on name
		if(this.id != o.id){
			return ((this.id < o.id) ? -1 : 1);
		} 
		return this.name.compareTo(o.name);
	}
	
	public static void main(String[] args) {
		Employee employee1 = new Employee(1, "A");
		Employee employee2 = new Employee(1, "B");
		Employee employee3 = new Employee(1, "A");
		
		System.out.println("Employee 1 hashcode : "+employee1.hashCode()+"");
		System.out.println("Employee 2 hashcode : "+employee2.hashCode()+"");
		System.out.println("Employee 3 hashcode : "+employee3.hashCode()+"");
		
		System.out.println(employee1.equals(employee2)+"---"+employee1.compareTo(employee2));
		System.out.println(employee1.equals(employee3)+"---"+employee1.compareTo(employee3));
		
		Employee emp = new Employee();
		ITEmployee employee = (ITEmployee) emp;
		employee.a();
		
		
	}
	

}

class ITEmployee extends Employee {
	void a(){
		
	}
}
