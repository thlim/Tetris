package controller;

import com.google.inject.Guice;
import com.google.inject.Injector;

import model.IModel;

public final class Collision {

	private IModel model;
	private boolean collisionAhead;
	private static Collision instance = null;
	
	private static final int MAP_WIDTH = 10;
	private static final int MAP_HEIGHT = 18;
	private static final int BRICK_SIZE = 4;

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

	protected boolean checkBrickCollisionLeft() {
		for (int dx = BRICK_SIZE - 1; dx >= 0; --dx) {
			for (int dy = 0; dy < BRICK_SIZE; ++dy) {
				int offsetX = model.getPosX() + dx - 1;
				int offsetY = model.getPosY() + dy;
				if(model.getBrickvalue(dx, dy))
				{
					if(offsetX + 1 <= 0)
					{
						return false;
					}
					if(offsetY >= 0 && model.getMapValue(offsetX, offsetY))
					{
						return false;
					}
				}
			}
		}
		return true;
	}

	protected boolean checkBrickCollisionRight() {
		for (int dx = 0; dx < BRICK_SIZE; ++dx) {
			for (int dy = 0; dy < BRICK_SIZE; ++dy) {
				int offsetX = model.getPosX() + dx + 1;
				int offsetY = model.getPosY() + dy;
				if(model.getBrickvalue(dx, dy))
				{
					if(offsetX - 1 >= MAP_WIDTH - 1)
					{
						return false;
					}
					if(offsetY >= 0 && model.getMapValue(offsetX, offsetY))
					{
						return false;
					}
				}
			}
		}
		return true;
	}

	protected boolean checkBrickCollisionDown() {
		for (int dy = 0; dy < BRICK_SIZE; ++dy) {
			for (int dx = 0; dx < BRICK_SIZE; ++dx) {
				int offsetX = model.getPosX() + dx;
				int offsetY = model.getPosY() + dy + 1;
				if(model.getBrickvalue(dx, dy))
				{
					if(offsetY - 1 >= MAP_HEIGHT - 1)
					{
						collisionAhead = true;
						return false;
					}
					if(offsetY >= 0 && model.getMapValue(offsetX, offsetY))
					{
						collisionAhead = true;
						return false;
					}
				}
			}
		}
		return true;
	}
	
	protected void checkRotationBounds()
	{
		for(int dx = 0; dx < BRICK_SIZE; ++dx)
		{
			for(int dy = 0; dy < BRICK_SIZE; ++dy)
			{
				if(model.getBrickvalue(dx, dy))
				{
					if(model.getPosX() + dx < 0)
					{
						model.setPosX(model.getPosX() + 1);
						--dx;
						break;
					}
					if(model.getPosX() + dx > MAP_WIDTH - 1)
					{
						model.setPosX(model.getPosX() - 1);
						--dx;
						break;
					}
					if(model.getPosY() + dy > MAP_HEIGHT - 1)
					{
						model.setPosY(model.getPosY() - 1);
						--dy;
						break;
					}
				}
			}
		}
		
	}
	
	/**
	 * @return the collisionAhead
	 */
	protected boolean isCollisionAhead() {
		return collisionAhead;
	}

	protected void resetCollisionAhead() {
		collisionAhead = false;
	}
}
