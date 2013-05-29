package controller;

import model.Map;
import model.Brick;
import view.GUI;
import view.TUI;

public class Game
{
	private GUI		gui;
	private Map		map;
	private Brick	activeBrick;
	private int 	level;
	private boolean running;
	private long	timer;
	private long	time;
	private boolean guiFlag;
	private boolean tuiFlag;
	private byte	state;
	
	public Game()
	{
		gui 		= new GUI();
		map			= Map.getInstance();
		activeBrick	= Brick.getInstance();
		level 		= 0;
		timer 		= 0;
		time 		= 0;
		state 		= 0;
		running	 	= true;
		guiFlag		= true;
		tuiFlag		= false;
	}
	
	public boolean init()
	{
		timer = System.currentTimeMillis();
		return true;
	}
	
	public void update(long time)
	{
		if(time >= 1000)
		{
			++activeBrick.posY;
			if(activeBrick.posY >= 15)
			{
				map.addBrick(activeBrick);
				activeBrick.posX += 4;
				activeBrick.posY = 0;
				activeBrick.reset();
			}
		}
	}
	
	public void print()
	{
	}
	
	public void printMenu()
	{
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
				if(time >= 1000)
				{
					gui.repaint();
					time = 0;
				}
				break;
			case 1:
				update(time);
				print();
				break;
			}
			time += System.currentTimeMillis() - timer;
		}
	}
}