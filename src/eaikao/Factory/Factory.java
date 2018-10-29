package eaikao.Factory;

interface IMessage {
	 public void sendMsg();
}

class RequsetMessage implements IMessage {
	public void sendMsg() {
		System.out.println("this is request message!");
	}
}

class ResponseMessage implements IMessage {
	public void sendMsg() {
		System.out.println("this is reponse message!");
	}
}

// Simple factory
class MessageFactory {
	public static IMessage getMessage(int nMessageType) {
		IMessage message = null;
		switch (nMessageType) {
		case 0:
			message = new RequsetMessage();
			break;
		case 1:
			message = new ResponseMessage();
			break;
		default:
			break;
		}
		return message;
	}
}

// Factory method
interface IMessageFactory {
	public IMessage createMessage();
}

class RequestMessageFactory implements IMessageFactory {
	public IMessage createMessage() {
		return new RequsetMessage();
	}
}

class ResponseMessageFactory implements IMessageFactory {
	public IMessage createMessage() {
		return new ResponseMessage();
	}
}

// Abstract factory
interface IPencil {
	public void write();
}

interface IRubber {
	public void erase();
}

class StarPencil implements IPencil {
	public void write() {
		System.out.println("This is the pencil of the Star product line.");
	}
}

class StarRubber implements IRubber {
	public void erase() {
		System.out.println("This is the rubber of the Star product line.");
	}
}

class YouthPencil implements IPencil {
	public void write() {
		System.out.println("This is the pencil of the Youth product line.");
	}
}

class YouthRubber implements IRubber {
	public void erase() {
		System.out.println("This is the rubber of the Youth product line.");
	}
}

interface IStationeryFactory {
	public IPencil createPencil();
	public IRubber createRubber();
}

class StarStationeryFactory implements IStationeryFactory {
	public IPencil createPencil() {
		return new StarPencil();
	}
	
	public IRubber createRubber() {
		return new StarRubber();
	}
}

class YouthStationeryFactory implements IStationeryFactory {
	public IPencil createPencil() {
		return new YouthPencil();
	}
	
	public IRubber createRubber() {
		return new YouthRubber();
	}
}

public class Factory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IMessage sampleMessage = MessageFactory.getMessage(0);
		sampleMessage.sendMsg();
		
		IMessageFactory messageFactory = new ResponseMessageFactory();
		IMessage methodMessage = messageFactory.createMessage();
		methodMessage.sendMsg();
		
		IStationeryFactory stationeryFactory = new StarStationeryFactory();
		IPencil abstractPencil = stationeryFactory.createPencil();
		abstractPencil.write();
		IRubber abstractRubber = stationeryFactory.createRubber();
		abstractRubber.erase();
	}

}
