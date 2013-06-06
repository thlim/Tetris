package model;

public class ModelImpl implements IModel {

	
	public Brick getBrick() {
		
		return Brick.getInstance();
	}

	
	public void turnBrick(Brick b) {
		
		b.turn();

	}

	
	public Map getMap() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void addBrick(Brick b) {
		// TODO Auto-generated method stub

	}

}
