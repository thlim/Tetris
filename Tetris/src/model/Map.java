package model;

public class Map
{
	private static Map instance = null;

	public static Map getInstance()
	{
		if(instance == null)
		{
			return instance = new Map();
		}
		return instance;
	}

	private static boolean map[][];
	
	private Map()
	{
		map = new boolean[10][18];
		for(int y = 0; y < 18; ++y)
		{
			for(int x = 0; x < 10; ++x)
			{
				map[x][y] = false;
			}
		}
	}
	
	public void addBrick(Brick b)
	{
		for(int y = 0; y < 4; ++y)
		{
			for(int x = 0; x < 4; ++x)
			{
				if(b.form[x][y] == true && (b.posY + y) < 18 && (b.posX + x) < 10)
				{
					map[b.posX + x][b.posY + y] = true;
				}
			}
		}
	}
	
	public void set(int x, int y, boolean value)
	{
		map[x][y] = value;
	}
	
	public boolean get(int x, int y)
	{
		return map[x][y];
	}
}