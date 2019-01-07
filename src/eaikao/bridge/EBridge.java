package eaikao.bridge;

interface IDrink {
	public void doDrink();
}

class ECoffe implements IDrink {
	@Override
	public void doDrink() {
		//do coffe ...
		System.out.print("Coffee is done£¡");
	}
}

class EFruitTea implements IDrink {

	@Override
	public void doDrink() {
		// do fruit tea
		System.out.print("fruit is done!");
	}
}

class EMilk implements IDrink {

	@Override
	public void doDrink() {
		// do milk
		System.out.print("milk is done!");
	}
}

abstract class ECup {
	protected IDrink drink;
	
	public void setDrink(IDrink drink) {
		this.drink = drink;
	}
	
	public abstract void doWrap();
}

class ESmallCup extends ECup {

	@Override
	public void doWrap() {
		// small cup
		this.drink.doDrink();
		System.out.println(" Packing a small cup...");
	}
}

class EMediumCup extends ECup {
	@Override
	public void doWrap() {
		// small cup
		this.drink.doDrink();
		System.out.println(" Packing a medium cup...");
	}
}

class EBigCup extends ECup {
	@Override
	public void doWrap() {
		// small cup
		this.drink.doDrink();
		System.out.println(" Packing a big cup...");
	}
}

public class EBridge {
	public static void main(String[] args) {
		ECup smallCup = new ESmallCup();
		IDrink coffe = new ECoffe();
		smallCup.setDrink(coffe);
		smallCup.doWrap();
		
		ECup bigCup = new EBigCup();
		IDrink milk = new EMilk();
		bigCup.setDrink(milk);
		bigCup.doWrap();
	}
}


