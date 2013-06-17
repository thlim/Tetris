package controller;

import model.Map;
import model.Brick;
import view.GUI;
import view.TUI;
import controller.InputHandler;

public class Game
{
	private GUI				gui;
	private TUI				tui;
	private Map				map;
	private Brick			activeBrick;
	private double 			level;
	private boolean			collisionAhead;
	private boolean 		running;
	private long			timer;
	private long			time;
	private boolean			guiFlag;
	private boolean			tuiFlag;
	private byte			state;
	private InputHandler 	inputHandle;
	
	public Game()
	{
		gui 		= GUI.getInstance();
		inputHandle	= InputHandler.getInstance();
		gui.addKeyListener(inputHandle);
		tui			= TUI.getInstance();
		map			= Map.getInstance();
		activeBrick	= Brick.getInstance();
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
		checkBrickCollision(activeBrick);
		if(time >= 1000 * level)
		{
			if(collisionAhead)
			{
				map.addBrick(activeBrick);
				activeBrick.posX += 4;
				activeBrick.posY = 0;
				activeBrick.reset();
			}
			else
			{
				moveBrickDown();
			}
		}
	}
	
	public void moveBrickDown()
	{
		++activeBrick.posY;
	}
	
	boolean checkBrickCollision(Brick b)
	{
		int left = 4;
		int right = -1;
		int bottom = -1;
		
		for(int x = 0; x < 4 ; ++x)
		{
			for(int y = 0; y < 4; ++y)
			{
				if(b.form[x][y] == true)
				{
					if(x < left)
					{
						b.mostLeftX = x;
						b.mostLeftY = y;
						left = x;
					}
					if(x > right)
					{
						b.mostRightX = x;
						b.mostRightY = y;
						right = x;
					}
					if(y > bottom)
					{
						b.mostBottomX = x;
						b.mostBottomY = y;
						bottom = y;
					}
					
					if(left + b.posX < 0)
					{
						b.posX = 0 - b.mostLeftX;
					}
					
					if(right + b.posX > 9)
					{
						b.posX = 5 + b.mostRightX;
					}
					
					if(y == 3 || b.form[x][y+1] == false)
					{
						if(map.get(x + b.posX, y + b.posY) == true)
						{
							collisionAhead = true;
							return true;
						}
						else
						{
							collisionAhead = false;
							return false;
						}
					}
				}
			}
		}
		return true;
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