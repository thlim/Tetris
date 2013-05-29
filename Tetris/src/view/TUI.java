package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;

public class TUI implements ActionListener
{
	private PrintStream console;
	
	public TUI()
	{
		console = System.out;
	}
	
	public void printMenu()
	{
		console.printf("Tetris\n");
		console.printf("\t1) Start game\n");
		console.printf("\tQ) Exit game\n");
	}
	
	public void print()
	{
	}

	public void actionPerformed(ActionEvent e)
	{
		console.printf("Action performed.\n");
	}
}
