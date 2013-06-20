package controller;

import com.google.inject.Guice;
import com.google.inject.Injector;

import model.IModel;
import model.Map;
import model.Brick;
import view.GUI;
import view.TUI;
import controller.InputHandler;

public class Game
{
	private GUI				gui;
	private TUI				tui;
	//private Map				map;
	//private Brick			activeBrick;
	private double 			level;
	private boolean			collisionAhead;
	private boolean 		running;
	private long			timer;
	private long			time;
	private boolean			guiFlag;
	private boolean			tuiFlag;
	private byte			state;
	private InputHandler 	inputHandle;
	private int[]			distances;
	private IModel model;
	
	public Game()
	{
		Injector injector = Guice.createInjector();
		model = injector.getInstance(IModel.class);
		gui 		= GUI.getInstance();
		inputHandle	= InputHandler.getInstance();
		gui.addKeyListener(inputHandle);
		tui			= TUI.getInstance();
		//map			= Map.getInstance();
		//activeBrick	= Brick.getInstance();
		level 		= 1.0;
		timer 		= 0;
		time 		= 0;
		state 		= 0;
		running	 	= true;
		guiFlag		= true;
		tuiFlag		= false;
		collisionAhead = false;
	}
	
	public boolean init()
	{
		timer = System.currentTimeMillis();
		return true;
	}
	
	public void update(long time)
	{
		checkBrickCollision();
		getDistances();
		if(time >= 1000 * level)
		{
			System.out.println(distances[0] + ", " + distances[1] + ", "
					+ distances[2] + ", " + distances[3] + ", " + collisionAhead);
			if(collisionAhead)
			{
				model.addBrick();
				model.setPosX(model.getPosX() + 4);
				model.setPosY(0);
				model.resetBrick();
			}
			else
			{
				moveBrickDown();
			}
		}
	}
	
	public void moveBrickDown()
	{
		model.setPosY(model.getPosY() +1);
	}
	
	boolean checkBrickCollision()
	{
		int left = 4;
		int right = -1;
		int bottom = -1;
		
		for(int x = 0; x < 4 ; ++x)
		{
			for(int y = 0; y < 4; ++y)
			{
				if(model.getBrickvalue(x, y) == true)
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
						//b.posX = 5 + b.mostRightX;
					}
				}
			}
		}
		return true;
	}
	
	void getDistances()
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
				if(model.getBrickvalue(x, y) == true && distances[x] == -1)
				{
					while(model.getPosY()+ y + distances[x] < 17
							&& model.getMapValue(model.getPosX() + x, model.getPosY() + y + distances[x]) == false)
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
	}
	
	public void run()
	{
		while(running)
		{
			timer = System.currentTimeMillis();
			switch(state)
			{
			case 0:
				update(time);
				if(time >= 1000 * level)
				{
					gui.repaint();
					//tui.printMenu();
					time = 0;
				}
				break;
			case 1:
				update(time);
				break;
			}
			time += System.currentTimeMillis() - timer;
		}
	}
}