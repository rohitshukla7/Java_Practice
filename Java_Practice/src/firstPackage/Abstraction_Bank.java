package firstPackage;

public class Abstraction_Bank {

	public static void main(String[] args) {
		Bank s = new SBI();
		System.out.println("SBI Interest:" + s.getBankInterest());
		Bank h = new HDFC();
		System.out.println(h.getBankInterest());
	}

}

abstract class Bank {
	abstract int getBankInterest();
}

class SBI extends Bank {
	int getBankInterest() {
		return 7;
	}
}

class HDFC extends Bank {
	int getBankInterest() {
		System.out.print("HDFC Interest:");
		return 8;
	}
}