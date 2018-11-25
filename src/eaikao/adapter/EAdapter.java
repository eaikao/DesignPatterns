package eaikao.adapter;

interface IThreeHoleSocket {
	public void connectThreeHole();
}

interface ITwoHolePowerCord {
	public void connectTwoHole();
}

class EThreeHoleSocket implements IThreeHoleSocket {
	public void connectThreeHole() {
		System.out.println("Successful connection to the three-hole power cord!");
	}
}

class ETwoHolePowerCord implements ITwoHolePowerCord {
	public void connectTwoHole() {
		System.out.println("Successful connection to the two-hole socket!");
	}
}

class EThreeHoleClassAdapter extends EThreeHoleSocket implements ITwoHolePowerCord {
	public void connectTwoHole() {
		connectThreeHole();
	}
}

class EThreeHoleObjectAdapter implements ITwoHolePowerCord {
	private EThreeHoleSocket threeHoleSocket;
	
	public EThreeHoleObjectAdapter(EThreeHoleSocket threeHoleSocket) {
		this.threeHoleSocket = threeHoleSocket;
	}
	
	public void connectTwoHole() {
		threeHoleSocket.connectThreeHole();
	}
}

interface IDriver {
	void funcA();
	void funcB();
	void funcC();
	void funcD();
}

abstract class EDriver implements IDriver {
	public void funcA() {}
	public void funcB() {}
	public void funcC() {}
	public void funcD() {}
}

class ESimDriver extends EDriver {
	public void funcB() {
		System.out.println("this is Sim funcB!");
	}
	
	public void funcC() {
		System.out.println("this is Sim funcC!");
	}
}

class ERealDriver extends EDriver {
	
	public void funcA() {
		System.out.println("this is Real funcA!");
	}
	
	public void funcB() {
		System.out.println("this is Real funcB!");
	}
	
	public void funcC() {
		System.out.println("this is Real funcC!");
	}
	
	public void funcD() {
		System.out.println("this is Real funcD!");
	}
}

public class EAdapter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ITwoHolePowerCord threeHoleClassAdapter = new EThreeHoleClassAdapter();
		threeHoleClassAdapter.connectTwoHole();
		
		EThreeHoleSocket threeHoleSocket = new EThreeHoleSocket(); 
		ITwoHolePowerCord threeHoleObjectAdapter = new EThreeHoleObjectAdapter(threeHoleSocket);
		threeHoleObjectAdapter.connectTwoHole();
		
		IDriver simDriver = new ESimDriver();
		simDriver.funcA();
		simDriver.funcB();
		simDriver.funcC();
		simDriver.funcD();
		
		IDriver realDriver = new ERealDriver();
		realDriver.funcA();
		realDriver.funcB();
		realDriver.funcC();
		realDriver.funcD();
	}
}
