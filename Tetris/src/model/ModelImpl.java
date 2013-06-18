package model;

public class ModelImpl implements IModel {

	Brick brick = Brick.getInstance();
	Map m = Map.getInstance();
	
	public Brick getBrick() {
		
		return brick;
	}

	
	public void turnBrick() {
		
		brick.turn();

	}

	
	public Map getMap() {
		
		return m;
	}

	
	public void addBrick(Brick b) {
		m.addBrick(b);
	}


	
	public void resetBrick() {
		brick.rand();
		brick.reset();
		
	}


	@Override
	public boolean getForm(int x, int y) {
		return brick.get(x, y);
		
	}


	@Override
	public int getScene() {
	
		return brick.getScene();
	}


	@Override
	public int getBrickPosX() {
		// TODO Auto-generated method stub
		return brick.getPosX();
	}


	@Override
	public int getBrickPosY() {
		// TODO Auto-generated method stub
		return brick.getPosY();
	}


	@Override
	public int getBrickMLX() {
		// TODO Auto-generated method stub
		return brick.getMostLeftX();
	}


	@Override
	public int getBrickMLY() {
		// TODO Auto-generated method stub
		return brick.getMostLeftY();
	}


	@Override
	public int getBrickMRX() {
		// TODO Auto-generated method stub
		return brick.getMostRightX();
	}


	@Override
	public int getBrickMRY() {
		// TODO Auto-generated method stub
		return brick.getMostRightY();
	}


	@Override
	public int getBrickMBX() {
		// TODO Auto-generated method stub
		return brick.getMostBottomtX();
	}


	@Override
	public int getBrickMBY() {
		// TODO Auto-generated method stub
		return brick.getMostBottomtY();
	}


	@Override
	public void setBrickPosX(int x) {
		// TODO Auto-generated method stub
		brick.setPosX(x);
	}


	@Override
	public void setBrickPosY(int y) {
		// TODO Auto-generated method stub
		brick.setPosY(y);
	}


	@Override
	public void setBrickMLX(int mlx) {
		// TODO Auto-generated method stub
		brick.setMostLeftX(mlx);
	}


	@Override
	public void setBrickMLY(int mly) {
		// TODO Auto-generated method stub
		brick.setMostLeftY(mly);
	}


	@Override
	public void setBrickMRX(int mrx) {
		// TODO Auto-generated method stub
		brick.setMostRightX(mrx);
	}


	@Override
	public void setBrickMRY(int mry) {
		// TODO Auto-generated method stub
		brick.setMostRightY(mry);
	}


	@Override
	public void setBrickMBX(int mbx) {
		// TODO Auto-generated method stub
		brick.setMostBottomtX(mbx);
	}


	@Override
	public void setBrickMBY(int mby) {
		// TODO Auto-generated method stub
		brick.setMostBottomtY(mby);
	}


	@Override
	public boolean getMapValue(int x, int y) {
		// TODO Auto-generated method stub
		return m.get(x, y);
	}


	@Override
	public void setMapValue(int x, int y, boolean value) {
		// TODO Auto-generated method stub
		m.set(x, y, value);
	}

}
