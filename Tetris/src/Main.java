/*
 * 	Tetris
 * 	Softwaretechnik WS 12/13
 * 
 * @Author: Thomas Lim
 * 			Andreas Hummelsberger
 * 
 * Main.java
 */
import controller.Game;

final class Main {
	public static void main(String[] args) {

		
		

		

		Game g = Game.getInstance();

		boolean exit = false;
		while (!exit) {
			exit = g.run();
			
		}
		System.exit(0);
	}
}