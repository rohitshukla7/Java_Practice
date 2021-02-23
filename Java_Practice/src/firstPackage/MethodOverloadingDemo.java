package firstPackage;

public class MethodOverloadingDemo {

	public static void main(String[] args) {
		System.out.println(Adder.add(11, 11));
		System.out.println(Adder.add(11, 11, 11));

		System.out.println(Multiplier.add(11, 11));
		System.out.println(Multiplier.add(11, 11, 11));

		System.out.println("main with String[]");
	}

	public static void main(String args) { // we can have any number of main methods in a class by method overloading
											// but JVM calls main method which receives string array as arguments only
		System.out.println("main with String");
	}

	public static void main() {
		System.out.println("main without arguments");
	}
}

class Adder {
	static int add(int a, int b) {
		return a + b;
	}

	static double add(double a, double b) {
		return a + b;
	} // by changing data types of arguments
//static double add(int a,int b) {return a+b;} // method overloading cannot be achieved by changing return data type

	static int add(int a, int b, int c) {
		return a + b + c;
	} // method overloading by changing number of arguments
}

class Multiplier {
	static int add(int a, int b) {
		return a * b;
	}

	static int add(int a, int b, int c) {
		return a * b * c;
	}
}
