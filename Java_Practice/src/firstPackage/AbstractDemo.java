/*
1. There are two ways to achieve abstraction in java
	Abstract class (0 to 100%)
	Interface (100%)
2. An abstract class must be declared with an abstract keyword.
3. It can have abstract and non-abstract methods.
4. It cannot be instantiated.
5. It can have constructors and static methods also.
6. It can have final methods which will force the subclass not to change the body of the method.
*/
package firstPackage;

public class AbstractDemo {

	public static void main(String[] args) {
		PhonePhaseOne obj = new PhonePhaseThree(); // cannot instantiate the abstract class
		obj.call();
		obj.voiceAssistant();
		obj.wirelessCharging();
		obj.zenmode();
	}
}

abstract class PhonePhaseOne { // abstract class
	public void call() {
		System.out.println("Calling...");
	}

	public abstract void voiceAssistant(); // abstract methods

	public abstract void wirelessCharging();

	public abstract void zenmode();
}

abstract class PhonePhaseTwo extends PhonePhaseOne {
	public void voiceAssistant() {
		System.out.println("Voice Assistant....");
	}
}

class PhonePhaseThree extends PhonePhaseTwo { // Concrete class
	public void wirelessCharging() {
		System.out.println("Wireless Charging...");
	}

	public void zenmode() {
		System.out.println("Zen Mode...");
	}
}
