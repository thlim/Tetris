package view;

import java.io.PrintStream;

public class TUI
{
	private static TUI instance = null;
	private PrintStream console;
	
	public static TUI getInstance()
	{
		if(instance == null)
		{
			return instance = new TUI();
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
