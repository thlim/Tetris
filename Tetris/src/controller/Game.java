package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.TUI;

public class Game implements ActionListener
{
	private TUI		tui;
	private int 	level;
	private boolean running;
	private long	timer;
	private long	time;
	private boolean guiFlag;
	private boolean tuiFlag;
	private byte	state;
	
	public Game()
	{
		tui = new TUI();
		level 	= 0;
		timer 	= 0;
		time 	= 0;
		state 	= 0;
		running = true;
		guiFlag = false;
		tuiFlag = true;
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
		tui.printMenu();
	}
	
	public void run()
	{
		while(running)
		{
			timer = System.currentTimeMillis();
			switch(state)
			{
			case 0:
				printMenu();
				break;
			case 1:
				update(time);
				print();
				break;
			}
			time = System.currentTimeMillis() - timer;
		}
	}

	public void actionPerformed(ActionEvent e)
	{
	}
}