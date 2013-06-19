package model;

public class Brick
{
	private static Brick instance = null;
	private boolean form [][];
	public int scene;
	public int posX;
	public int posY;
	
	public int mostLeftX;
	public int mostLeftY;
	public int mostRightX;
	public int mostRightY;
	public int mostBottomX;
	public int mostBottomY;
	
	
	
	private Brick()
	{	resetBrick();
		mostLeftX = 4;
		mostRightX = -1;
		mostBottomY = -1;
	}
	
	public static Brick getInstance()
	{
		if(instance == null)
		{
			return instance = new Brick();
		}
		return instance;
	}
	
	public boolean get(int x, int y)
	{
		return form[x][y];
	}
	

	
	public void resetScene(){
		//scene = rand();
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
			form[2][1] = true;
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
	
	public void turn (){
		boolean temp[][] = new boolean [4][4];
		
		Brick b = getInstance();
		
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
	
	public void resetBrick()
	{
			scene = (int) 	(Math.random() * 7);
			resetScene();
	}
}