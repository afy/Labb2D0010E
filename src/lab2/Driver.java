package lab2;

import java.awt.Color;

import lab2.level.Level;

import lab2.level.LevelGUI;
import lab2.level.Room;

public class Driver {

	public void run() 
	{
		// 1:
		//System.out.println("This is a print-out from the driver.");
		
		Level l = new lab2.level.Level();
		Room f = new Room(32, 32, Color.red);
		Room f2 = new Room(32, 32, Color.blue);
		Room f3 = new Room(32, 32, Color.yellow);
		Room f4 = new Room(32, 32, Color.green);
		l.place(f, 0, 0);
		l.place(f2, 64, 0);
		l.place(f3, 128, 0);
		l.place(f4, 64, 64);
		
		f.connectEastTo(f2);
		f2.connectWestTo(f);
		
		f2.connectEastTo(f4);
		f4.connectWestTo(f2);
		
		f2.connectEastTo(f3);
		f3.connectWestTo(f2);
		
		f2.connectSouthTo(f4);
		f4.connectNorthTo(f2);

		l.firstLocation(f);
		lab2.level.LevelGUI lg = new lab2.level.LevelGUI(l, "null");
	}

}