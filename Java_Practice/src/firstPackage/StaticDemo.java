package firstPackage;

public class StaticDemo {
	
	static int empid;
	static String empname;
	
	static {
		empid = 123;
		empname = "Rohit";
		System.out.println("in static block");
		//System.exit(0);
	}

	public static void main(String[] args) {
		System.out.println("Employee ID:"+empid);
		System.out.println("Employee Name:"+empname);
		
		show(); //calling static method

	}
	
	static void show() {
		System.out.println("Static method");
	}

}
