package view;

import java.io.PrintStream;

public final class TUI
{
	private static TUI instance = null;
	private PrintStream console;
	
	public static TUI getInstance()
	{
		if(instance == null)
		{
			instance = new TUI();
			return instance;
		}
		return instance;
	}
	
	private TUI()
	{
		console = System.out;
	}
	
	public void printMenu()
	{
		console.printf("Tetris\n");
		console.printf("\t1) Start game\n");
		console.printf("\tQ) Exit game\n");
	}
	
	public void printGame()
	{
	}
}
