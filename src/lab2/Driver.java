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
		
		// 2.2
		Level l = new lab2.level.Level();		
		Room f = new Room(32, 32, Color.red);
		Room f2 = new Room(32, 32, Color.blue);
		Room f3 = new Room(32, 32, Color.yellow);
		Room f4 = new Room(32, 32, Color.green);
		Room f5 = new Room(32, 32, Color.cyan);
		Room f6 = new Room(32, 32, Color.orange);
		
		boolean f_placed = l.place(f, 0, 0);
		boolean f2_placed = l.place(f2, 64, 0);
		boolean f3_placed = l.place(f3, 128, 0);
		boolean f4_placed = l.place(f4, 64, 64); 
		boolean f5_placed = l.place(f5, 0, 64);
		boolean f6_placed = l.place(f6, 128, 64);	
		
		System.out.println(f_placed);
		System.out.println(f2_placed);
		System.out.println(f3_placed);
		System.out.println(f4_placed);
		System.out.println(f5_placed);
		System.out.println(f6_placed);

		
		if (f_placed && f2_placed) {
			f.connectEastTo(f2); 
			f2.connectWestTo(f);
		}
		
		if (f2_placed && f4_placed) {
			f2.connectSouthTo(f4);
			f4.connectNorthTo(f2);
		}
		
		if (f2_placed && f3_placed) {
			f2.connectEastTo(f3); 
			f3.connectWestTo(f2);
		}
		
		if (f5_placed && f4_placed) {
			f5.connectEastTo(f4);
			f4.connectWestTo(f5); 
		}
		
		if (f4_placed && f6_placed) {
			f4.connectEastTo(f6);
			f6.connectWestTo(f4);
		}
		
		// set starting location for player and stop
		// any further room placements
		l.firstLocation(f4);
		
		/*
		Level l2 = new lab2.level.Level();		
		Room f = new Room(32, 32, Color.red);
		Room f2 = new Room(32, 32, Color.blue);
		Room f3 = new Room(32, 32, Color.yellow);
		Room f4 = new Room(32, 32, Color.green);
		Room f5 = new Room(32, 32, Color.cyan);
		Room f6 = new Room(32, 32, Color.orange);
		
		boolean f_placed = l2.place(f, 0, 64);
		boolean f2_placed = l2.place(f2, 64, 64);
		boolean f3_placed = l2.place(f3, 128, 64);
		boolean f4_placed = l2.place(f4, 128, 0); 
		boolean f5_placed = l2.place(f5, 200, 64);
		boolean f6_placed = l2.place(f6, 200, 128);	

		
		if (f_placed && f2_placed) {
			f.connectEastTo(f2); 
			f2.connectWestTo(f);
		}
		
		if (f3_placed && f4_placed) {
			f4.connectSouthTo(f3);
			f3.connectNorthTo(f4);
		}
		
		if (f2_placed && f3_placed) {
			f2.connectEastTo(f3); 
			f3.connectWestTo(f2);
		}
		
		if (f5_placed && f6_placed) {
			f5.connectSouthTo(f6);
			f6.connectNorthTo(f5);
		}
		
		if (f3_placed && f5_placed) {
			f3.connectEastTo(f5);
			f5.connectWestTo(f3);
		}
		
		l2.firstLocation(f4);*/
		
		// create GUI from level l, with title Labb2.
		lab2.level.LevelGUI lg = new lab2.level.LevelGUI(l, "Labb2");
	}
}