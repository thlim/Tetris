package controller;

import com.google.inject.Guice;
import com.google.inject.Injector;

import model.IModel;

public final class Collision {

	private IModel model;
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

	protected boolean checkBrickCollisionLeft() {
		for (int dx = 3; dx >= 0; --dx) {
			for (int dy = 0; dy < 4; ++dy) {
				int offsetX = model.getPosX() + dx - 1;
				int offsetY = model.getPosY() + dy;
				if (offsetY < 18
						&& (((offsetX < 0) || model.getMapValue(offsetX, offsetY)) && model
								.getBrickvalue(dx, dy))) {
					System.out.println("checkBrickCollitionLeft = false");
					return false;
				}
			}
		}
		return true;
	}

	protected boolean checkBrickCollisionRight() {
		for (int dx = 0; dx < 4; ++dx) {
			for (int dy = 0; dy < 4; ++dy) {
				int offsetX = model.getPosX() + dx + 1;
				int offsetY = model.getPosY() + dy;
				if (offsetY < 18
						&& (((offsetX > 9) || model.getMapValue(offsetX, offsetY)) && model
								.getBrickvalue(dx, dy))) {
					System.out.println("checkBrickCollitionRight = false");
					return false;
				}
			}
		}
		return true;
	}

	protected boolean checkBrickCollisionDown() {
		for (int dy = 0; dy < 4; ++dy) {
			for (int dx = 0; dx < 4; ++dx) {
				int offsetX = model.getPosX() + dx;
				int offsetY = model.getPosY() + dy + 1;
				if (offsetX >= 0 && offsetX < 10 && offsetY >= 0) {
					if ((offsetY > 17 || model.getMapValue(offsetX, offsetY))
							&& model.getBrickvalue(dx, dy) && !collisionAhead) {
						collisionAhead = true;
						System.out.println("checkBrickCollitionDown = false");
						return false;
					}
				}
			}
		}
		return true;
	}
	
	protected void checkRotationBounds()
	{
		for(int dx = 0; dx < 4; ++dx)
		{
			for(int dy = 0; dy < 4; ++dy)
			{
				if(model.getBrickvalue(dx, dy))
				{
					if(model.getPosX() + dx < 0)
					{
						model.setPosX(model.getPosX() + 1);
						--dx;
						break;
					}
					if(model.getPosX() + dx > 9)
					{
						model.setPosX(model.getPosX() - 1);
						--dx;
						break;
					}
					if(model.getPosY() + dy > 17)
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
