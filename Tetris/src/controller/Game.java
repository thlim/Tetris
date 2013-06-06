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
		level 		= 0.2;
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
		if(time >= 1000 * level)
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
				if(time >= 1000 * level)
				{
					gui.repaint();
					tui.printMenu();
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