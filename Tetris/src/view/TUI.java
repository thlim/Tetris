package view;

import java.io.Console;

public class TUI
{
	private Console console;
	
	public TUI()
	{
		console = System.console();
	}
	
	public void printMenu()
	{
		console.printf("Tetris\n", 0);
		console.printf("\t1) Start game\n");
		console.printf("\tQ) Exit game\n");
	}
	
	public void print()
	{
	}
}
