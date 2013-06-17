package model;

public class ModelImpl implements IModel {

	
	public Brick getBrick() {
		
		return Brick.getInstance();
	}

	
	public void turnBrick() {
		
		Brick.getInstance().turn();

	}

	
	public Map getMap() {
		// TODO Auto-generated method stub
		return Map.getInstance();
	}

	
	public void addBrick(Brick b) {
		Map.getInstance().addBrick(b);
	}


	
	public void resetBrick() {
		Brick.getInstance().rand();
		Brick.getInstance().reset();
		
	}


	@Override
	public boolean getForm(int x, int y) {
		return Brick.getInstance().get(x, y);
		
	}


	@Override
	public int getScene() {
	
		return Brick.getInstance().getScene();
	}

}
