/*
 * 	Tetris
 * 	Softwaretechnik WS 12/13
 * 
 * @Author: Thomas Lim
 * 			Andreas Hummelsberger
 * 
 * Main.java
 */
import java.util.Scanner;

import controller.Game;

final class Main {
	public static void main(String[] args) {

		boolean console = false;
		boolean consoleOnly = false;
		

		for (int i = 0; i < args.length; ++i) {
			if (args[i].equals("-console")) {
				console = true;
				break;
			}
			if (args[i].equals("-console-only")) {
				consoleOnly = true;
				break;
			}
		}

		Game g = new Game(console, consoleOnly);

		boolean exit = false;
		while (!exit) {
			exit = g.run();
			//System.out.println(scanner.nextInt());
		}
		System.exit(0);
	}
}