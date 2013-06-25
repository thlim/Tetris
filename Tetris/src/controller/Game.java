package controller;

import model.IModel;
import view.IView;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Game
{

	protected double 			level;
	private long			timer;
	private long			time;
	private byte			state;
	private IModel model;
	private IView view;
	private Collision coll;
	
	public Game()
	{
		Injector injector = Guice.createInjector();
		model = injector.getInstance(IModel.class);
		
		coll = Collision.getInstance();
		view = injector.getInstance(IView.class);
		view.getGui().addKeyListener(InputHandler.getInstance());
		level 		= 1.0;
		timer 		= 0;
		time 		= 0;
		state 		= 0;
	}
	
	
	
	private void update(long time)
	{
		
		coll.checkBrickCollision();
		coll.getDistances();
		if(time >= 1000 * level)
		{
			
			if(coll.isCollisionAhead())
			{
				model.addBrick();
				model.setPosX(model.getPosX() + 4);
				model.setPosY(0);
				model.resetBrick((int)(Math.random() * 7));
			}
			else
			{
				model.setPosY(model.getPosY() +1);
				
			}
		}
	}
	
	
	
	
	
	
	
	public boolean run()
	{
		
			timer = System.currentTimeMillis();
			switch(state)
			{
			case 0:
				update(time);
				if(time >= 1000 * level)
				{
					view.update();
					
					time = 0;
				}
				break;
//			case 1:
//				update(time);
//				break;
			}
			time += System.currentTimeMillis() - timer;
		
		return InputHandler.getInstance().exit;
	}
}