
package lab2.level;

import java.awt.Color;
import java.util.Vector;


public class Room 
{ 
	int x, y, dx, dy = 0;
	Color color;
	
	// adjacent rooms to North, East, South and West (connected by corridor)
	Room rNorth, rEast, rSouth, rWest = null; 
	
	// list of corridors from this room
	// a corridor is defined by a array of rooms
	// where index 0 leads to index 1
	Vector<Room[]> corridors = new Vector<Room[]>();
	
	public Room(int dx, int dy, Color color)
	{
		this.dx = dx;
		this.dy = dy;
		this.color = color;
		
		System.out.println("Room dimensions: ("+this.dx+", "+this.dy+"),"
				+ " color: "+this.color);
	}

	// connect room to the given direction and add the corridor
	// from this room -> given room r
	public void connectNorthTo(Room r) {
		rNorth = r;
		corridors.add(new Room[] {this, r});
	}
	public void connectEastTo(Room r)  {
		rEast = r; 
		corridors.add(new Room[] {this, r});
	}
	public void connectSouthTo(Room r) { 
		rSouth = r;
		corridors.add(new Room[] {this, r});
	}
	public void connectWestTo(Room r)  { 
		rWest = r; 
		corridors.add(new Room[] {this, r});
	}
}