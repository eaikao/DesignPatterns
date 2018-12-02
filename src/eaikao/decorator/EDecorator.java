package eaikao.decorator;

interface IPhone {
	void call();
}

class EPhone implements IPhone {
	public void call() {
		System.out.print("this is a mobile phone");
	}
}

class EPhoneDecorator implements IPhone {
	 private IPhone phone;
	 
	 public EPhoneDecorator(IPhone phone) {
		 this.phone = phone;
	 }
	 
	public void call() {
		this.phone.call();
	}
}

class EFilmDecorator extends EPhoneDecorator {
	public EFilmDecorator(IPhone phone) {
		super(phone);
	}
	
	public void call() {
		super.call();
		System.out.print(", It has a cell phone film");
	}
}

class ECasesDecorator extends EPhoneDecorator {
	public ECasesDecorator(IPhone phone) {
		super(phone);
	}
	
	public void call() {
		super.call();
		System.out.print(", It has a protective case");
	}
}

public class EDecorator {

	public static void main(String[] args) {
		//a sample phone
		EPhone ePhone = new EPhone();
		ePhone.call();
		System.out.println("");
		
		//a film phone
		EFilmDecorator eFilmDecorator = new EFilmDecorator(ePhone);
		eFilmDecorator.call();
		System.out.println("");
		
		//a case phone
		ECasesDecorator eCasesDecorator = new ECasesDecorator(ePhone);
		eCasesDecorator.call();
		System.out.println("");
		
		//a film and case phone
		ECasesDecorator eCasesFilmDecorator = new ECasesDecorator(eFilmDecorator);
		eCasesFilmDecorator.call();
	}

}
