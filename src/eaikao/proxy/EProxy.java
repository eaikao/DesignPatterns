package eaikao.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface ILawsuit {
	void sue();
	void wirteLawsuit();
}

class EDelegator implements ILawsuit {
	public EDelegator() {
	}
	
	public void sue() {
		System.out.println("Delegator start sue");
	}
	
	public void wirteLawsuit() {
		System.out.println("Delegator start oral lawsuit");
	}
}

class ELawyer implements ILawsuit {
	private EDelegator delegator;
	
	public ELawyer(EDelegator delegator) {
		this.delegator = delegator;
	}
	
	public void sue() {
		System.out.println("do some work before sue");
		this.delegator.sue();
		System.out.println("do some work after sue");
	}
	
	public void wirteLawsuit() {
		System.out.println("do some work before write lawsuit");
		this.delegator.sue();
		System.out.println("do some work after write lawsuit");
	}
}

class DynamicProxyHandler implements InvocationHandler {
	private Object delegator;
	
	public DynamicProxyHandler(Object delegator) {
		this.delegator = delegator;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("do some work before proxy");
		Object invokeObj = method.invoke(delegator, args);
		System.out.println("do some work after proxy");
		return invokeObj;
	}
}

public class EProxy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EDelegator delegator = new EDelegator();
		ELawyer lawyer = new ELawyer(delegator);
		lawyer.wirteLawsuit();
		lawyer.sue();
		
		System.out.println("====================");
		
		ILawsuit lawsuitProxy = (ILawsuit)Proxy.newProxyInstance(
				ILawsuit.class.getClassLoader(), 
				new Class[] {ILawsuit.class}, 
				new DynamicProxyHandler(delegator));
		
		lawsuitProxy.wirteLawsuit();
		lawsuitProxy.sue();
	}
}
