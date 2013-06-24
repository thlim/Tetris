package controller;

import com.google.inject.Guice;
import com.google.inject.Injector;

import model.IModel;

public class Collision {

	private IModel model;
	private int[] distances;
	private boolean collisionAhead;
	private static Collision instance = null;
	
	private Collision(){
		Injector injector = Guice.createInjector();
		model = injector.getInstance(IModel.class);
	}
	
	public static Collision getInstance()
	{
		if(instance == null)
		{
			instance = new Collision();
			return instance;
		}
		return instance;
	}
	
	protected boolean checkBrickCollision()
	{
		int left = 4;
		int right = -1;
		int bottom = -1;
		
		for(int x = 0; x < 4 ; ++x)
		{
			for(int y = 0; y < 4; ++y)
			{
				if(model.getBrickvalue(x, y))
				{
					if(x < left)
					{
						model.setMostLeftX(x);
						model.setMostLeftY(y);
						left = x;
					}
					if(x > right)
					{
						model.setMostRightX(x);
						model.setMostRightY(y);
						right = x;
					}
					if(y > bottom)
					{
						model.setMostBottomX(x);
						model.setMostBottomY(y);
						bottom = y;
					}
					
					if(left + model.getPosX() < 0)
					{
						model.setPosX(0 - model.getMostLeftX());
					}
					
					if(right + model.getPosX() > 9)
					{
						model.setPosX(5 + model.getMostRightX());
						
					}
				}
			}
		}
		return true;
	}
	
	protected int[] getDistances()
	{
		distances = new int[4];
		for(int i = 0; i < distances.length; ++i)
		{
			distances[i] = -1;
		}
		
		for(int x = 0; x < 4; ++x)
		{
			for(int y = 3; y >= 0; --y)
			{
				if(model.getBrickvalue(x, y) && distances[x] == -1)
				{
					while(model.getPosY()+ y + distances[x] < 17
							&& !model.getMapValue(model.getPosX() + x, model.getPosY() + y + distances[x]) )
					{
						++distances[x];
					}
					break;
				}
			}
		}
		
		if(distances[0] == 0 || distances[1] == 0
				|| distances[2] == 0 || distances[3] == 0)
		{
			collisionAhead = true;
		}
		else
		{
			collisionAhead = false;
		}
		return distances;
	}

	/**
	 * @return the collisionAhead
	 */
	protected boolean isCollisionAhead() {
		return collisionAhead;
	}
	
}
