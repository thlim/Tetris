package model;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestModelImpl {
	
	static ModelImpl model;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		model = new ModelImpl();
	}

	@Test
	public void testGetBrickvalue() {
		assertNotNull(model.getBrickvalue(0, 0));
		
	}

	@Test
	public void testGetMostLeftX() {
		assertNotNull(model.getMostLeftX());
	}

	@Test
	public void testSetMostLeftX() {
		model.setMostLeftX(1);
		assertEquals(model.getMostLeftX(), 1);
	}

	@Test
	public void testGetMostLeftY() {
		assertNotNull(model.getMostLeftY());
	}

	@Test
	public void testSetMostLeftY() {
		model.setMostLeftY(1);
		assertEquals(model.getMostLeftY(), 1);
	}

	@Test
	public void testGetMostRightX() {
		assertNotNull(model.getMostRightX());
	}

	@Test
	public void testSetMostRightX() {
		model.setMostRightX(1);
		assertEquals(model.getMostRightX(), 1);
	}

	@Test
	public void testGetMostRightY() {
		assertNotNull(model.getMostRightY());
	}

	@Test
	public void testSetMostRightY() {
		model.setMostRightY(1);
		assertEquals(model.getMostRightY(), 1);
	}

	@Test
	public void testGetMostBottomX() {
		assertNotNull(model.getMostBottomX());
	}

	@Test
	public void testSetMostBottomX() {
		model.setMostBottomX(1);
		assertEquals(model.getMostBottomX(), 1);
	}

	@Test
	public void testGetMostBottomY() {
		assertNotNull(model.getMostBottomY());
	}

	@Test
	public void testSetMostBottomY() {
		model.setMostBottomY(1);
		assertEquals(model.getMostBottomY(), 1);
	}
	@Test
	public void testResetBrick(){
		model.resetBrick(0);
		assertEquals(model.getScene(), 0);
		model.resetBrick(1);
		assertEquals(model.getScene(), 1);
		model.resetBrick(2);
		assertEquals(model.getScene(), 2);
		model.resetBrick(3);
		assertEquals(model.getScene(), 3);
		model.resetBrick(4);
		assertEquals(model.getScene(), 4);
		model.resetBrick(5);
		assertEquals(model.getScene(), 5);
		model.resetBrick(6);
		assertEquals(model.getScene(), 6);
	}

	@Test
	public void testTurn() {
		model.turnBrick();
		assertNotNull(model.getBrickvalue(0, 0));
	}
	
	@Test 
	public void setTest(){
		int expect = 4;
		model.setPosX(expect);
		model.setPosY(expect);
		assertEquals(expect, model.getPosX());
		assertEquals(expect, model.getPosY());
	}
	
	@Test
	public void testAddBrick() {
		model.addBrick();
		for(int y = 0; y < 4; ++y)
		{
			for(int x = 0; x < 4; ++x)
			{
				if(model.getBrickvalue(x, y) == true)
				{
					assertTrue(true);
				}
			}
		}
	}

	@Test
	public void testSet() {
		model.setMapValue(0, 0, true);
		assertTrue(model.getMapValue(0, 0));
	}

	

}
