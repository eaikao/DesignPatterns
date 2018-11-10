package eaikao.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.accessibility.AccessibleState;

/*
class EInvoice implements Cloneable {
	private String strName;
	private String strCompanyName;
	private String strId;
	private String strDate;
	private float  fAmount;
	
	public EInvoice clone() {
		EInvoice invoice = null;
		
		try {
			invoice = (EInvoice)super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return invoice;
	}
	
	public String getName() {
		return this.strName;
	}
	
	public void setName(String strName) {
		this.strName = strName;
	}
}
*/

/*
// Shallow cloning
class EInvoiceCollection implements Cloneable {
	private ArrayList<EInvoice> invoiceList;
	
	public EInvoiceCollection() {
		invoiceList = new ArrayList<EInvoice>();
	}
	
	public void addInvoice(EInvoice invoice) {
		invoiceList.add(invoice);
	}
	
	public EInvoiceCollection clone() {
		EInvoiceCollection invoiceCollection = null;
		
		try {
			invoiceCollection = (EInvoiceCollection)super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return invoiceCollection;
	}
	
	public void printAllInvoiceName() {
		if (this.invoiceList == null) {
			return;
		}
		
		int nSize = this.invoiceList.size();
		for (int i = 0; i < nSize; i++) {
			String strName = this.invoiceList.get(i).getName();
			System.out.println(strName);
		}
	}
}
*/

/*
// Deep cloning
class EInvoiceCollection implements Cloneable {
	ArrayList<EInvoice> invoiceList;
	
	public EInvoiceCollection() {
		invoiceList = new ArrayList<EInvoice>();
	}
	
	public void addInvoice(EInvoice invoice) {
		invoiceList.add(invoice);
	}
	
	public EInvoiceCollection clone() {
		EInvoiceCollection invoiceCollection = null;
		
		try {
			invoiceCollection = (EInvoiceCollection)super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		invoiceCollection.invoiceList = (ArrayList<EInvoice>) this.invoiceList.clone();
		return invoiceCollection;
	}
	
	public void printAllInvoiceName() {
		if (this.invoiceList == null) {
			return;
		}
		
		int nSize = this.invoiceList.size();
		for (int i = 0; i < nSize; i++) {
			String strName = this.invoiceList.get(i).getName();
			System.out.println(strName);
		}
	}
}
*/

interface ECloneable extends Cloneable, Serializable {
	
}

class EInvoice implements ECloneable {
	private String strName;
	private String strCompanyName;
	private String strId;
	private String strDate;
	private float  fAmount;
	
	public EInvoice clone() {
		EInvoice invoice = null;
		
		try {
			invoice = (EInvoice)super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return invoice;
	}
	
	public String getName() {
		return this.strName;
	}
	
	public void setName(String strName) {
		this.strName = strName;
	}
}

class EInvoiceCollection implements ECloneable {
	ArrayList<EInvoice> invoiceList;
	
	public EInvoiceCollection() {
		invoiceList = new ArrayList<EInvoice>();
	}
	
	public void addInvoice(EInvoice invoice) {
		invoiceList.add(invoice);
	}
	
	public EInvoiceCollection clone() {
		EInvoiceCollection invoiceCollection = null;
		ByteArrayOutputStream byteOS = new ByteArrayOutputStream();
		ObjectOutputStream objectOS;
		try {
			objectOS = new ObjectOutputStream(byteOS);
			objectOS.writeObject(this);
		} catch (IOException e) {
			e.printStackTrace();
		}  
		
		ByteArrayInputStream byteIS = new ByteArrayInputStream(byteOS.toByteArray()); 
		ObjectInputStream objectIS;
		try {
			objectIS = new ObjectInputStream(byteIS);
			invoiceCollection = (EInvoiceCollection) objectIS.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return invoiceCollection;
	}
	
	public void printAllInvoiceName() {
		if (this.invoiceList == null) {
			return;
		}
		
		int nSize = this.invoiceList.size();
		for (int i = 0; i < nSize; i++) {
			String strName = this.invoiceList.get(i).getName();
			System.out.println(strName);
		}
	}
}


public class EPrototype {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EInvoice invoice= new EInvoice();
		invoice.setName("张三");
		EInvoice invoiceClone = invoice.clone();
		System.out.println(invoiceClone.getName());
		
		EInvoiceCollection invoiceCollection = new EInvoiceCollection();
		for (int i = 0; i < 3; i++) {
			invoiceCollection.addInvoice(invoice.clone());
		}
		
		EInvoiceCollection invoiceCollClone = invoiceCollection.clone();
		invoiceClone.setName("李四");
		invoiceCollClone.addInvoice(invoiceClone);
		
		System.out.println("原型发票集合：");
		invoiceCollection.printAllInvoiceName();
		
		System.out.println("浅拷贝后发票集合：");
		invoiceCollClone.printAllInvoiceName();
	}

}
