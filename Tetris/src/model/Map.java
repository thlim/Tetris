package model;

public class Map
{
	private static Map instance = null;

	public Map getInstance()
	{
		if(instance == null)
		{
			return instance = new Map();
		}
		return instance;
	}

	private boolean map[][];
	
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
	
	public void set(int x, int y, boolean value)
	{
		map[x][y] = value;
	}
	
	public boolean get(int x, int y)
	{
		return map[x][y];
	}
}