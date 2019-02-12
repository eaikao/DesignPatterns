package eaikao.flyweight;

import java.util.HashMap;

interface IImage {
	void draw();
}

class EImage implements IImage {
	
	private String strImageType;
	private int nPosX;
	private int nPosY;
	private int nWidth;
	private int nHeight;
	
	public EImage(String strImageType) {
		this.strImageType = strImageType;
	}
	
	public void SetImage(int nPosX, int nPosY, int nWidth, int nHeight) {
		this.nPosX = nPosX;
		this.nPosY = nPosY;
		this.nWidth = nWidth;
		this.nHeight = nHeight;
	}
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("this image type is" + this.strImageType 
				+ "image size: " + nWidth + "¡¢" + nHeight + ","
				+ "display position: " + nPosX + "¡¢" + nPosY + ".");
	}
	
}

class EImageFactory {
	private static HashMap<String, IImage> imageMap = new HashMap<>();
	
	public static IImage getImage(String strImageType) {
		EImage image = (EImage)imageMap.get(strImageType);
		
		if (image == null) {
			image = new EImage(strImageType);
			imageMap.put(strImageType, image);	
		}
		
		return image;
	}
}

public class EFlyweight {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EImage image1D = (EImage)EImageFactory.getImage("1D");
		image1D.SetImage(0, 0, 1, 10);
		image1D.draw();
		
		EImage image2D = (EImage)EImageFactory.getImage("2D");
		image2D.SetImage(0, 5, 10, 10);
		image2D.draw();
		
		EImage image2D1 = (EImage)EImageFactory.getImage("2D");
		image2D1.SetImage(5, 5, 20, 10);
		image2D1.draw();
	}
}
