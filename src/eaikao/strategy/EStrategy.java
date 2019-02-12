package eaikao.strategy;

interface IArithmetic {
	public int calculate(int a, int b);
}

class EAdd implements IArithmetic {

	@Override
	public int calculate(int a, int b) {
		// TODO Auto-generated method stub
		return a + b;
	}
}

class ESub implements IArithmetic {

	@Override
	public int calculate(int a, int b) {
		// TODO Auto-generated method stub
		return a - b;
	}
}

class EMulti implements IArithmetic {

	@Override
	public int calculate(int a, int b) {
		// TODO Auto-generated method stub
		return a * b;
	}	
}

class EDiv implements IArithmetic {

	@Override
	public int calculate(int a, int b) {
		// TODO Auto-generated method stub
		if (b != 0) {
			return a / b;
		}
		return 0;
	}
}

class EArithmeticContext {
	private IArithmetic arithmetic;
	
	public EArithmeticContext(IArithmetic arithmetic) {
		this.arithmetic = arithmetic;
	}
	
	public  int execArithmetic(int a, int b) {
		return this.arithmetic.calculate(a, b);
	}
	
}

public class EStrategy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EAdd addArithmetic = new EAdd();
		EArithmeticContext contextAdd = new EArithmeticContext(addArithmetic);
		int result = contextAdd.execArithmetic(6, 6);
		System.out.println("add arithmetic result: " + result);
		
		ESub subArithmetic = new ESub();
		EArithmeticContext contextSub = new EArithmeticContext(subArithmetic);
		result = contextSub.execArithmetic(6, 6);
		System.out.println("sub arithmetic result: " + result);
		
		EMulti multiArithmetic = new EMulti();
		EArithmeticContext contextMulti = new EArithmeticContext(multiArithmetic);
		result = contextMulti.execArithmetic(6, 6);
		System.out.println("multi arithmetic result: " + result);
		
		EDiv divArithmetic = new EDiv();
		EArithmeticContext contextDiv = new EArithmeticContext(divArithmetic);
		result = contextDiv.execArithmetic(6, 6);
		System.out.println("div arithmetic result: " + result);
	}

}
