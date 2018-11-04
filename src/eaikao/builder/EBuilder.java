package eaikao.builder;

import eaikao.builder.EHighVersionPhoneBuilder;
import eaikao.builder.EPhone;
import eaikao.builder.EPhoneDirector;
import eaikao.builder.IPhoneBuilder;

class EPhone {
	private String cpu;
	private String ram;
	private String rom;
	private String battery;
	private String screen;
	private String system;
	
	public EPhone() {
		this.cpu = "";
		this.ram = "";
		this.rom = "";
		this.battery = "";
		this.screen = "";
		this.system = "";
	}
	
	public void setCpu(String strCpu) {
		this.cpu = strCpu;
	}
	
	public void setRam(String strRam) {
		this.ram = strRam;
	}
	
	public void setRom(String strRom) {
		this.rom = strRom;
	}
	
	public  void setBattery(String strBattery) {
		this.battery = strBattery;
	}
	
	public void setScreen(String strScreen) {
		this.screen = strScreen;
	}
	
	public void setSystem(String strSystem) {
		this.system = strSystem;
	}
	
	public String getSystem() {
		return this.system;
	}
	//...
}

interface IPhoneBuilder {
	public void buildCpu();
	public void buildRam();
	public void buildRom();
	public void buildBattery();
	public void buildScreen();
	public void buildSystem();
	public EPhone createPhone();
}

class EHighVersionPhoneBuilder implements IPhoneBuilder {
	private EPhone highPhone = null;
	
	public EHighVersionPhoneBuilder() {
		highPhone = new EPhone();
	}
	
	public void buildCpu() {
		highPhone.setCpu("Use Qualcomm Snapdragon 845");
	}
	
	public void buildRam() {
		highPhone.setRam("Use 8GB RAM");
	}
	
	public void buildRom() {
		highPhone.setRom("Use 64GB ROM");
	}
	
	public void buildBattery() {
		highPhone.setBattery("Use 3400 mAh battery");
	}
	
	public void buildScreen() {
		highPhone.setScreen("Use Corning Gorilla Sixth Generation Screen");
	}
	
	public void buildSystem() {
		highPhone.setSystem("Use android8.1 operating system");
	}
	
	public EPhone createPhone() {
		return highPhone;
	}
}

class EPhoneDirector {
	public static EPhone createPhone(IPhoneBuilder phoneBuilder) {
		if (phoneBuilder != null) {
			phoneBuilder.buildCpu();
			phoneBuilder.buildRam();
			phoneBuilder.buildRom();
			phoneBuilder.buildBattery();
			phoneBuilder.buildScreen();
			phoneBuilder.buildSystem();
				
			return phoneBuilder.createPhone();
		}
		return null;
	}
}

public class EBuilder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EHighVersionPhoneBuilder highVersionPhoneBuilder = new EHighVersionPhoneBuilder();
		EPhone highPhone = EPhoneDirector.createPhone(highVersionPhoneBuilder);
		System.out.println(highPhone.getSystem()); 
	}

}
