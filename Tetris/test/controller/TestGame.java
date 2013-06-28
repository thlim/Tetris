package controller;

import static org.junit.Assert.*;

import java.awt.Robot;

import model.IModel;
import model.ModelImpl;

import org.junit.*;

public class TestGame {

	Robot robo;
	Game game;
	Collision coll;
	IModel model;

	@Before
	public void setUpBefore() throws Exception {
		game = Game.getInstance();
		coll = Collision.getInstance();
		model = new ModelImpl();
	}

	@Test
	public void testRun() {
		assertFalse(game.run());

	}
	
	@Test
	public void testRun2(){
		model.togglePause();
		assertFalse(game.run());
		
	}

	@After
	public void afterTest() {
		game = null;
		coll = null;
	}

}
