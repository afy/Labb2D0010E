
package lab2.level;

import java.awt.Color;


public class Room 
{ 
	int x, y, dx, dy = 0;
	Color color;
	Room rNorth, rEast, rSouth, rWest = null;
	
	public Room(int dx, int dy, Color color)
	{
		this.dx = dx;
		this.dy = dy;
		this.color = color;
		
		System.out.println("Room dimensions: ("+this.dx+", "+this.dy+"),"
				+ " color: "+this.color);
	}

	public void connectNorthTo(Room r) { rNorth = r; }
	public void connectEastTo(Room r)  { rEast = r; }
	public void connectSouthTo(Room r) { rSouth = r; }
	public void connectWestTo(Room r)  { rWest = r; }
}