package controller;

import view.GUI;
import view.TUI;

public class Game
{
	private GUI		gui;
	private int 	level;
	private boolean running;
	private long	timer;
	private long	time;
	private boolean guiFlag;
	private boolean tuiFlag;
	private byte	state;
	
	public Game()
	{
		gui = new GUI();
		level 	= 0;
		timer 	= 0;
		time 	= 0;
		state 	= 0;
		running = true;
		guiFlag = true;
		tuiFlag = false;
	}
	
	public boolean init()
	{
		timer = System.currentTimeMillis();
		return true;
	}
	
	public void update(long time)
	{
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
				if(time > 1000)
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