package controller;

import com.google.inject.Guice;
import com.google.inject.Injector;

import model.IModel;

public final class Collision {

	private IModel model;
	private int[] distances;
	private boolean collisionAhead;
	private static Collision instance = null;

	private Collision() {
		Injector injector = Guice.createInjector();
		model = injector.getInstance(IModel.class);
	}

	public static Collision getInstance() {
		if (instance == null) {
			instance = new Collision();
			return instance;
		}
		return instance;
	}

	protected boolean checkBrickCollision() {
		
		
		return true;
	}

	protected boolean checkBrickCollisionLeft()
	{
		for(int dx = 3; dx >= 0; --dx)
		{
			for(int dy = 0; dy < 4; ++dy)
			{
				int offsetX = model.getPosX() + dx - 1;
				int offsetY = model.getPosY() + dy;
				if(offsetY < 18 && ((offsetX < 0
						|| model.getMapValue(offsetX, offsetY))
						&& model.getBrickvalue(dx, dy)))
				{
					return false;
				}
			}
		}
		return true;
	}
	
	protected boolean checkBrickCollisionRight()
	{
		for(int dx = 0; dx < 4; ++dx)
		{
			for(int dy = 0; dy < 4; ++dy)
			{
				int offsetX = model.getPosX() + dx + 1;
				int offsetY = model.getPosY() + dy;
				if(offsetY < 18 && ((offsetX > 9
						|| model.getMapValue(offsetX, offsetY))
						&&	model.getBrickvalue(dx, dy)))
				{
					return false;
				}
			}
		}
		return true;
	}
	
	protected boolean checkBrickCollisionDown()
	{
		for(int dy = 0; dy < 4; ++dy)
		{
			for(int dx = 0; dx < 4; ++dx)
			{
				int offsetX = model.getPosX() + dx;
				int offsetY = model.getPosY() + dy + 1;
				if(offsetX >= 0 && offsetX < 10)
				{
					if((offsetY > 17
						|| model.getMapValue(offsetX, offsetY))
						&& model.getBrickvalue(dx, dy))
					{
						collisionAhead = true;
						return false;
					}
				}
			}
		}
		return true;
	}
	
	protected void getDistances() {
		resetDistances();

		for (int x = 0; x < 4; ++x) {
			for (int y = 3; y >= 0; --y) {
				if (model.getBrickvalue(x, y) && distances[x] == -1) {
					while (model.getPosY() + y + distances[x] < 17
							&& model.getPosX() < 10
							&& !model.getMapValue(model.getPosX() + x,
									model.getPosY() + y + distances[x])) {
						++distances[x];
					}
					break;
				}
			}
		}

		if (distances[0] == 0 || distances[1] == 0 || distances[2] == 0
				|| distances[3] == 0) {
			collisionAhead = true;
		} else {
			collisionAhead = false;
		}

		
	}

	/**
	 * @return the collisionAhead
	 */
	protected boolean isCollisionAhead() {
		return collisionAhead;
	}

	protected void resetCollisionAhead()
	{
		collisionAhead = false;
	}
	
	private void resetDistances(){
		distances = new int[4];
		for (int i = 0; i < distances.length; ++i) {
			distances[i] = -1;
		}
		
	}
}
