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
	private int[]			distances;
	
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
		getDistances(activeBrick);
		if(time >= 1000 * level)
		{
			System.out.println(distances[0] + ", " + distances[1] + ", "
					+ distances[2] + ", " + distances[3] + ", " + collisionAhead);
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
				if(b.get(x, y) == true)
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
				}
			}
		}
		return true;
	}
	
	void getDistances(Brick b)
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
				if(b.get(x, y) == true && distances[x] == -1)
				{
					while(b.posY + y + distances[x] < 17
							&& map.get(b.posX + x, b.posY + y + distances[x]) == false)
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