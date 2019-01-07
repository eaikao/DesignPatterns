package eaikao.composite;

import java.util.ArrayList;

// transparent composite
abstract class IImageView {
	protected String strName;
	
	public IImageView(String strName) {
		this.strName = strName;
	}
	
	public String getName() {
		return this.strName;
	}
	
	public void add(IImageView imageView) {
		System.out.println("Can't add this view!");
	}
	
	public void remove(IImageView imageView) {
		System.out.println("Can't remove this view!");
	}
	
	public abstract void show();
}

class E2DImageView extends IImageView {
	
	public E2DImageView(String strName) {
		super(strName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("Shows a 2d image, this 2d image name is: " + this.strName);
	}
}

class E3DImageView extends IImageView {
	public E3DImageView(String strName) {
		super(strName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("Shows a 3d image, this 3d image name is: " + this.strName);
	}
}

class EImageView extends IImageView {
	private ArrayList<IImageView> arrayImageList;
	
	public EImageView(String strName) {
		super(strName);
		// TODO Auto-generated constructor stub
		arrayImageList = new ArrayList<IImageView>();
	}

	public void add(IImageView imageView) {
		arrayImageList.add(imageView);
		System.out.println("Added a view, view name is: " + imageView.getName());
	}
	
	public void remove(IImageView imageView) {
		arrayImageList.remove(imageView);
		System.out.println("Deleted a view, view name is: " + imageView.getName());
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("Start showing images in views: ");
        for(Object obj : arrayImageList) {  
            ((IImageView)obj).show();  
        }  
	}
	
}

public class EComposite {
	public static void main(String[] args) {
		IImageView image2DView1 = new E2DImageView("2d_1");
		IImageView image2DView2 = new E2DImageView("2d_2");
		
		IImageView image3DView1 = new E2DImageView("3d_1");
		IImageView image3DView2 = new E2DImageView("3d_2");
		
		IImageView imgView = new EImageView("views");
		
		imgView.add(image2DView1);
		imgView.add(image2DView2);
		imgView.add(image3DView1);
		imgView.add(image3DView2);
		
		imgView.show();
		
		imgView.remove(image2DView1);
		imgView.remove(image2DView2);
		imgView.remove(image3DView1);
		imgView.remove(image3DView2);
	}

}
