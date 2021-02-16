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
		InterfaceDemo obj2 = new InterfaceDemo();
		obj2.show();
		obj.display();

	}

}

interface I1{
	void show();	//all methods are by default public abstract in interface & cannot have body
}

interface I2{
	void display();
}