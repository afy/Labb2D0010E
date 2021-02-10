
package lab2.level;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings( "deprecation" ) // added bc of Observer
public class LevelGUI implements Observer {

	private Level lv;
	private Display d;
	
	public LevelGUI(Level level, String name) {
		
		this.lv = level;
		
		// add LevelGUI (this) as an observer of level
		level.addObserver(this);
		
		JFrame frame = new JFrame(name);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// TODO: You should change 200 to a value 
		// depending on the size of the level
		d = new Display(lv,200,200);
		
		frame.getContentPane().add(d);
		frame.pack();
		frame.setLocation(0,0);
		frame.setVisible(true);
	}
	
	
	public void update(Observable arg0, Object arg1) {
		// to paint on update, simply call repaint on display
		d.repaint();
	}
	
	private class Display extends JPanel {
			
		public Display(Level fp, int x, int y) {		
			addKeyListener(new Listener());	
			setBackground(Color.black);
			setPreferredSize(new Dimension(x+20,y+20));
			setFocusable(true);
		}
	
			
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			// draw rooms
			Room l = lv.current; // for cleaner code
			
			for (Room r : lv.rooms) 
			{
				// draw the room itself
				g.setColor(r.color.darker());
				g.fillRect(r.x, r.y, r.dx, r.dy);
				
				// draw all corridors from this room
				for (Room[] c : r.corridors) 
				{
					DrawCorridor(g, c);
				}
			}
			
			// draw current room border
			g.setColor(Color.white);
			g.drawRect(l.x, l.y,l.dx, l.dy);
		}
		
		public void DrawCorridor(Graphics g, Room[] corridor)
		{
			// unpack rooms from given corridor (looks better)
			Room rFrom = corridor[0];
			Room rTo = corridor[1];

			g.setColor(rTo.color);
			int n = 5; // shift line from block
			int m = 10; // limit length; remove n px from each side
						   // of line 
				
			// for corridors north of block
			// the position logic is too hard to explain here
			// but is in theory pretty simple
			if (rTo.y < rFrom.y) { 
				g.drawLine(rFrom.x+m, rFrom.y-n, 
						rFrom.x+rFrom.dx-m, rFrom.y-n);
				
			}
			
			// for corridors east of block
			else if (rTo.x > rFrom.x) {
				g.drawLine(rFrom.x+rFrom.dx+n, rFrom.y+m, 
						rFrom.x+rFrom.dx+n, rFrom.y+rFrom.dy-m);
			}
			
			// for corridors south of block
			else if (rTo.y > rFrom.y) { // south
				g.drawLine(rFrom.x+m, rFrom.y+rFrom.dy+n, 
						rFrom.x+rFrom.dx-m, rFrom.y+rFrom.dy+n);
			}
				
			// for corridors west of block
			else if (rTo.x < rFrom.x) { // west
				g.drawLine(rFrom.x-n, rFrom.y+m, 
						rFrom.x-n, rFrom.y+rFrom.dy-m);
			}
		}

	 	private class Listener implements KeyListener {

	 		
	 		public void keyPressed(KeyEvent arg0)
	 		{
	 			// the keycodes look arbirtrary 
	 			// but are simply expanded from the library 
	 			// they come from, making it look a bit better
	 			switch(arg0.getKeyCode()) 
	 			{
	 			case 0x57: // keycode for w; move north
	 				lv.move(lv.current.rNorth);
	 				break;
	 			
	 			case 0x44: // keycode for d; move east 
	 				lv.move(lv.current.rEast);
	 				break;
	 				
	 			case 0x53: // keycode for s; move south
	 				lv.move(lv.current.rSouth);
	 				break;
	 				
	 			case 0x41: // keycode for a; move west
	 				lv.move(lv.current.rWest);
	 				break;
	 			}
	 		}

	 		public void keyReleased(KeyEvent arg0) {
	 		}

	 		public void keyTyped(KeyEvent event) {
	 		}
	 	}

	}
	
}