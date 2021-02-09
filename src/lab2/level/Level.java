
package lab2.level;

import java.util.Observable;
import java.util.Vector;

@SuppressWarnings( "deprecation" ) // added bc of Observer
public class Level extends Observable 
{
	Room current = null;
	boolean finished = false;
	Vector<Room> rooms = new Vector<Room>();
	
	public boolean place(Room r, int x, int y)  
	{
		if (!finished) 
		{
			for (Room room : rooms) 
			{
				if (rectInBoundry(r, room)) { return false; }
			}
			
			// "place" done
			r.x = x;
			r.y = y;
			rooms.add(r);
			return true;
		}
		return false;
	}
	
	public void firstLocation(Room r) 
	{
		current = r;
		finished = true;

	}
	
	public void move(Room moveTo) 
	{
		if (moveTo != null) 
		{ 
			current = moveTo; 
			setChanged();
			notifyObservers();
		}
	};
	
	private boolean rectInBoundry(Room r1, Room r2) 
	{
		return (r1.x < r2.x + r2.dx && r2.x > r1.x + r1.dx &&
				   r1.y < r2.y + r2.dy && r2.y > r1.y + r1.dy);
	}
	
	
}