package eaikao.singleton;

class ESingleton0 {
	private ESingleton0() {}
	private static ESingleton0 instance = new ESingleton0();
	
	public static ESingleton0 getInstance() {
		return instance;
	}
}

class ESingleton1 {
	private ESingleton1() {}
	private static ESingleton1 instance = null;
	
	static {
		instance = new ESingleton1();
	}
	
	public static ESingleton1 getInstance() {
		return instance;
	}
}

class ESingleton2 {
	private ESingleton2() {}
	private static ESingleton2 instance = null;
	
	public static synchronized ESingleton2 getInstance() {
		if (instance == null) {
			instance = new ESingleton2();
		}
		
		return instance;
	}
}

class ESingleton3 {
	private ESingleton3() {}
	private static ESingleton3 instance = null;
	
	public static ESingleton3 getInstance() {
		if (instance == null) {
			synchronized(ESingleton3.class) {
				if (instance == null) {
					instance = new ESingleton3();
				}
			}	
		}
		
		return instance;
	}
}


class ESingleton4 {
	private ESingleton4() {}
	
	private static class ESingleton {
		private static final ESingleton4 instance = new ESingleton4();
	} 
	
	public static ESingleton4 getInstance() {
		return ESingleton.instance;
	}
}

public class ESingletonMain {
	public static void main(String[] args) {
		ESingleton1 singleton1 = ESingleton1.getInstance();
		ESingleton2 singleton2 = ESingleton2.getInstance();
		ESingleton3 singleton3 = ESingleton3.getInstance();
		ESingleton4 singleton4 = ESingleton4.getInstance();
		System.out.println("singleton completed!");
	}

}
