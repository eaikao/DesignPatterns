package eaikao.templatemethod;

abstract class Algorithm {
	abstract void init();
	abstract void start();
	abstract void end();
	
	public final void process() {
		init();
		start();
		end();
	}
}

class AlgorithmA extends Algorithm {

	@Override
	void init() {
		// TODO Auto-generated method stub
		 System.out.println("init AlgorithmA!");
	}

	@Override
	void start() {
		// TODO Auto-generated method stub
		 System.out.println("start AlgorithmA!");
	}

	@Override
	void end() {
		// TODO Auto-generated method stub
		 System.out.println("end AlgorithmA!");
	}
}

class AlgorithmB extends Algorithm {

	@Override
	void init() {
		// TODO Auto-generated method stub
		 System.out.println("init AlgorithmB!");
	}

	@Override
	void start() {
		// TODO Auto-generated method stub
		 System.out.println("start AlgorithmB!");
	}

	@Override
	void end() {
		// TODO Auto-generated method stub
		 System.out.println("end AlgorithmB!");
	}
	
}

public class ETemplateMethod {
	public static void main(String[] args) {
		Algorithm algorithmA = new AlgorithmA();
		algorithmA.process();
		
		Algorithm algorithmB = new AlgorithmB();
		algorithmB.process();
	}
}
