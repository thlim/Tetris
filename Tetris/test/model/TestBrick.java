package model;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import model.Brick;

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
	public void testReset0() {
		testbrick.scene = 0;
		testbrick.reset();
		assertNotNull(testbrick.get(0,0));
		
	}
	
	@Test
	public void testReset1() {
		testbrick.scene = 1;
		testbrick.reset();
		assertNotNull(testbrick.get(0,0));
		
	}
	
	@Test
	public void testReset2() {
		testbrick.scene = 2;
		testbrick.reset();
		assertNotNull(testbrick.get(0,0));
		
	}
	
	@Test
	public void testReset3() {
		testbrick.scene = 3;
		testbrick.reset();
		assertNotNull(testbrick.get(0,0));
		
	}
	
	@Test
	public void testReset4() {
		testbrick.scene = 4;
		testbrick.reset();
		assertNotNull(testbrick.get(0,0));
		
	}
	
	@Test
	public void testReset5() {
		testbrick.scene = 5;
		testbrick.reset();
		assertNotNull(testbrick.get(0,0));
		
	}
	
	@Test
	public void testReset6() {
		testbrick.scene = 6;
		testbrick.reset();
		assertNotNull(testbrick.get(0,0));
		
	}
	
	

	@Test
	public void testTurn() {
		testbrick.turn();
		assertNotNull(testbrick.get(0,0));
	}
	
	@Test
	public void testGet(){
		assertNotNull(testbrick.get(0, 0));
	}

}
