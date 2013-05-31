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
			form[1][1] = true;
			form[2][1] = true;
			form[1][2] = true;
			form[2][2] = true;
			break;
		
		case 1:
			form[1][0] = true;
			form[1][1] = true;
			form[1][2] = true;
			form[1][3] = true;
			break;
			
		case 2:
			form[1][0] = true;
			form[1][1] = true;
			form[1][2] = true;
			form[2][2] = true;
			break;
			
		case 3:
			form[0][1] = true;
			form[1][1] = true;
			form[2][1] = true;
			form[1][2] = true;
			break;
		
		case 4:
			form[0][1] = true;
			form[1][1] = true;
			form[1][1] = true;
			form[2][2] = true;
			break;
		
		case 5:
			form[1][1] = true;
			form[2][1] = true;
			form[0][2] = true;
			form[1][2] = true;
			break;
			
		case 6:
			form[1][0] = true;
			form[1][1] = true;
			form[1][2] = true;
			form[0][2] = true;
			break;
		
		}
	}
	
	public void turn (Brick b){
		boolean temp[][] = new boolean [4][4];
		
		temp[0][0] = b.form[0][3];
		temp[1][0] = b.form[0][2];
		temp[2][0] = b.form[0][1];
		temp[3][0] = b.form[0][0];
		
		temp[0][1] = b.form[1][3];
		temp[1][1] = b.form[1][2];
		temp[2][1] = b.form[1][1];
		temp[3][1] = b.form[1][0];
		
		temp[0][2] = b.form[2][3];
		temp[1][2] = b.form[2][2];
		temp[2][2] = b.form[2][1];
		temp[3][2] = b.form[2][0];
		
		temp[0][3] = b.form[3][3];
		temp[1][3] = b.form[3][2];
		temp[2][3] = b.form[3][1];
		temp[3][3] = b.form[3][0];
		
		b.form = temp;
		
		
	}
	
	private int rand(){
	
			return (int) 	(Math.random() * 7);	
		
		
		
	}
	
}