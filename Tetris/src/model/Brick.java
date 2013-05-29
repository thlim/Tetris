package model;
import java.math.*;

public class Brick
{
	private static Brick instance = null;
	public boolean form [][];
	public int scene;
	public int posX;
	public int posY;
	public int style;
	
	private Brick(){
		
		reset();	
		
	}
	
	public static Brick getInstance()
	{
		if(instance == null)
		{
			return instance = new Brick();
		}
		return instance;
	}
	
	public void reset(){
		scene = rand();
		form = new boolean [4][4];
		posX = 4;
		posY = 0;
		
		switch(scene){
		
		case 0:
			form[0][0] = true;
			form[1][0] = true;
			form[0][1] = true;
			form[1][1] = true;
			break;
		
		case 1:
			form[0][0] = true;
			form[0][1] = true;
			form[0][2] = true;
			form[0][3] = true;
			break;
			
		case 2:
			form[0][0] = true;
			form[0][1] = true;
			form[0][2] = true;
			form[1][2] = true;
			break;
			
		case 3:
			form[0][0] = true;
			form[1][0] = true;
			form[2][0] = true;
			form[1][1] = true;
			break;
		
		case 4:
			form[0][0] = true;
			form[1][0] = true;
			form[1][1] = true;
			form[2][1] = true;
			break;
		
		case 5:
			form[1][0] = true;
			form[2][0] = true;
			form[0][1] = true;
			form[1][1] = true;
			break;
			
		case 6:
			form[1][0] = true;
			form[1][1] = true;
			form[1][2] = true;
			form[0][2] = true;
			break;
		
		}
	}
	
	private int rand(){
	
			return (int) 	(Math.random() * 7);	
		
		
		
	}
	
}