package controller;

import static org.junit.Assert.*;

import java.awt.Robot;
import model.Brick;

import org.junit.*;

public class TestGame {

	Robot robo;
	Game game;
	Brick brick;
	
	@Before
	public void setUpBefore() throws Exception {
		robo = new Robot();
		game = new Game();
		brick = Brick.getInstance();
	}

	@Test
	public void testGame() {
		assertNotNull(game);
	}

	@Test
	public void testInit() {
		assertTrue(game.init());
	}

	@Test
	public void testUpdate() {
		assertTrue(true);
	}

	@Test
	public void testPrint() {
		assertTrue(true);
	}

	@Test
	public void testPrintMenu() {
		assertTrue(true);
	}

	@Test
	public void testRun() {
		assertTrue(true);
	}
	

	



}
