package controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import model.IModel;
import model.ModelImpl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCollision {
	
	Collision coll;
	IModel model;

	@Before
	public void setUp() throws Exception {
		coll = null;
		model = null;
		coll = Collision.getInstance();
		model = new ModelImpl();
		model.resetBrick(1);
		coll.resetCollisionAhead();
	}

	@After
	public void tearDown() throws Exception {
		
		coll = null;
		model = null;
	}

	@Test
	public void testCheckBrickCollisionLeftFalse() {
		model.setPosX(-1);
		
		assertFalse(coll.checkBrickCollisionLeft());
	}
	
	@Test
	public void testCheckBrickCollisionLeftFalse2() {
		model.resetBrick(0);
		model.setPosX(0);
		model.setPosY(0);
		model.setMapValue(0, 1, true);
		assertFalse(coll.checkBrickCollisionLeft());
	}
	
	@Test
	public void testCheckBrickCollisionLeftTrue() {
		model.resetBrick(0);
		
		assertTrue(coll.checkBrickCollisionLeft());
	}

	@Test
	public void testCheckBrickCollisionRightFalse() {
		model.setPosX(8);
		assertFalse(coll.checkBrickCollisionRight());
	}
	@Test
	public void testCheckBrickCollisionRightFalse2() {
		model.resetBrick(0);
		model.setPosX(0);
		model.setPosY(0);
		model.setMapValue(2, 1, true);
		assertFalse(coll.checkBrickCollisionRight());
	}
	@Test
	public void testCheckBrickCollisionRightTrue() {
		model.resetBrick(0);
		assertTrue(coll.checkBrickCollisionRight());
	}

	@Test
	public void testCheckBrickCollisionDownFalse() {
		model.setPosX(1);
		model.setPosY(16);
		assertFalse(coll.checkBrickCollisionDown());
	}
	@Test
	public void testCheckBrickCollisionDownFalse2() {
		model.resetBrick(0);
		model.setPosX(0);
		model.setPosY(0);
		model.setMapValue(1, 2, true);
		assertFalse(coll.checkBrickCollisionDown());
	}
	@Test
	public void testCheckBrickCollisionDownTrue() {
		model.resetBrick(0);
		assertTrue(coll.checkBrickCollisionDown());
	}

	@Test
	public void testCheckRotationBounds1() {
		model.resetBrick(0);
		model.setPosX(10);
		coll.checkRotationBounds();
		assertEquals(model.getPosX(), 7);
	}
	@Test
	public void testCheckRotationBounds2() {
		model.resetBrick(0);
		model.setPosX(-4);
		coll.checkRotationBounds();
		assertEquals(model.getPosX(), -1);
	}
	
	@Test
	public void testCheckRotationBounds3() {
		model.setPosY(16);
		coll.checkRotationBounds();
		assertEquals(model.getPosY(), 15);
	}

	

	@Test
	public void testResetCollisionAhead() {
		coll.resetCollisionAhead();
		assertFalse(coll.isCollisionAhead());
	}

}
