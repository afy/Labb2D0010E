
package lab2.level;

import java.util.Observable;
import java.util.Vector;

@SuppressWarnings( "deprecation" ) // added bc of Observer
public class Level extends Observable 
{
	Room current = null;		// room the player is currently in
	boolean finished = false;	// can anymore rooms be placed?
	Vector<Room> rooms = new Vector<Room>();
	
	public boolean place(Room r, int x, int y)  
	{
		if (!finished) 
		{
			r.x = x;
			r.y = y;
			
			// loop through all rooms (so far) and see
			// if they collide
			for (Room room : rooms) 
			{		
				if (rectInBoundry(r, room)) { 
					return false; 
				}
			}
			
			// passed; set position and add room to list
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
	
	// move the player to a given room moveTo
	void move(Room moveTo) 
	{
		if (moveTo != null) 
		{
			current = moveTo; 
			setChanged();
			notifyObservers();
		}
	};
	
	// basic overlapping test between to rectangles
	// from http://www.jeffreythompson.org/collision-detection/rect-rect.php
	private boolean rectInBoundry(Room r1, Room r2) 
	{
		return (r1.x + r1.dx > r2.x &&  
				r1.x < r2.x + r2.dx &&
				r1.y + r1.dy > r2.y && 
				r1.y < r2.y + r2.dy);
	}
	
	
}