package model;
import java.math.*;

public class Brick
{
	
	private boolean form [][];
	private int fieldcount;
	private int last[];
	
	public Brick(){
		
		form = new boolean [4][4];
		fieldcount = 0;
		last = new int[2];
		
		for(int y = 0; y<4; y++){
			for(int x = 0; x<4; x++){
				
				
				//erstes Element
				if(fieldcount == 0){
					form[x][y] = rand();
					if (form[x][y] == false){
						continue;	
					}
					else fieldcount++;
					last[0] = x;
					last[1] = y;
					continue;
				}
				if(fieldcount <= 4){
					form[x][y] = rand();
					if(form[x][y] == true){
						
						if (last[1] == y && last[0] <= (x - 2)){
							form[x][y] = false;
							continue;
						}
						else if(last[0] == x && last[1] <= (y - 2)){
							form[x][y] = false;
							continue;
							
						}
						else fieldcount++;
						last[0] = x;
						last[1] = y;
						continue;
					}
				}
				else form[x][y] = false;
				continue;
				
				
			}
		}
		
		
		
	}
	private boolean rand(){
		int a = (int) (Math.random() * (2 - 1) + 1);
		if(a == 1){
			return false;	
		}
		return true;
		
		
	}
	
}