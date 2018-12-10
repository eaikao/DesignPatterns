package eaikao.facade;

class ESubModule1 {
	public void process() {
		System.out.println("ESubModule1 process!");
	}
}

class ESubModule2 {
	public void process() {
		System.out.println("ESubModule2 process!");
	}
}

class ESubModule3 {
	public void process() {
		System.out.println("ESubModule3 process!");
	}
}

class ESystemFacade {
	private ESubModule1 subModule1;
	private ESubModule2 subModule2;
	private ESubModule3 subModule3;
	
	public ESystemFacade() {
		subModule1 = new ESubModule1();
		subModule2 = new ESubModule2();
		subModule3 = new ESubModule3();
	}
	
	public void process() {
		subModule1.process();
		subModule2.process();
		subModule3.process();
	}
}


public class EFacade {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ESystemFacade systemFacade = new ESystemFacade();
		systemFacade.process();
	}

}
