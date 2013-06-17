package controller;

import static org.junit.Assert.*;

import java.awt.Robot;
import java.awt.event.AWTEventListener;
import java.awt.event.KeyEvent;

import model.Brick;

import org.junit.Before;
import org.junit.Test;

public class TestInputHandler {
	
	InputHandler ih;
	Robot robo;
	Game g;
	Brick b;

	@Before
	public void setUp() throws Exception {
		robo = new Robot();
		ih = InputHandler.getInstance();
		b = Brick.getInstance();
		
	}

	@Test
	public void testGetInstance() {
		
		assertNotNull(ih);
	}

	
	
	
	@Test
	public void testKeyPressed37() {
		assertTrue(true);
		
	}

	@Test
	public void testKeyReleased() {
		assertTrue(true);
	}

	@Test
	public void testKeyTyped() {
		assertTrue(true);
	}
	


}
