package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestBrick {
	
	Brick testbrick;
	boolean s[];

	@Before
	public void setUp() throws Exception {
		testbrick = Brick.getInstance();
		s = new boolean[7];
		
		
	}
	
	@Test
	public void testGetInstance() {
		assertNotNull(testbrick);
	}
	
	
	
	
	@Test
	public void testResetBrick(){
		testbrick.resetBrick();
		assertNotNull(testbrick.getScene());
	}

	@Test
	public void testTurn() {
		testbrick.turn();
		assertNotNull(testbrick.get(0,0));
	}
	
	@Test 
	public void setTest(){
		int expect = 4;
		testbrick.setPosX(expect);
		testbrick.setPosY(expect);
		assertEquals(expect, testbrick.getPosX());
		assertEquals(expect, testbrick.getPosY());
	}
}
