package firstPackage;

public class EncapsulationDemo {

	public static void main(String[] args) {
		Employee e = new Employee();
		e.setEmpId(123);
		System.out.println("Employee ID:" + e.getEmpId());

	}

}

class Employee {
	private int empid;	// private access modifier provides data binding due to which empid variable
						// cannot be accessed outside this class

	public void setEmpId(int eid) {// setter
		empid = eid;
	}

	public int getEmpId() {	// getter
		return empid;
	}
}
