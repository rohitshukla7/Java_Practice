package firstPackage;

public class InterfaceDemo implements I1, I2 {
	
	public void show() {	//cannot reduce the visibility of the inherited method from interface
		System.out.println("In show...");	//concrete method requires body
	};		
	
	public void display() {
		System.out.println("In display...");
	}

	public static void main(String[] args) {
		//I1 obj = new InterfaceDemo(); //this will also works
		InterfaceDemo obj = new InterfaceDemo();
		obj.show();
		obj.display();
		I1.testStatic();  //static method belongs to class and to object
		obj.testDefault();

	}

}

interface I1{
	void show();	//all methods are by default public abstract in interface & cannot have body
	
	static void testStatic() {	//method with body can be defined in interface with static keyword
		System.out.println("calling static method");
	}
}

interface I2{
	void display();
	
	default void testDefault() {	//method with body can be defined in interface with default keyword
		System.out.println("calling default method");
	}
}


