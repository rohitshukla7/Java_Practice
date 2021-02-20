package firstPackage;

public class StaticDemo {
	
	static int empid;
	static String empname;
	private static double salary = 20000;
	
	static {
		empid = 123;
		empname = "Rohit";
		System.out.println("in static block");
		//System.exit(0);
	}
	
	static class innerClass{
		void salary() {
			System.out.println("Salary of employee "+empname+" is "+salary);
		}
	}

	public static void main(String[] args) {
		System.out.println("Employee ID:"+empid);
		System.out.println("Employee Name:"+empname);
		
		show(); //calling static method
		
		StaticDemo.innerClass obj = new StaticDemo.innerClass();
		obj.salary();

	}
	
	static void show() {
		System.out.println("Static method");
	}

}
