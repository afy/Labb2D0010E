
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
			for (Room r : lv.rooms) 
			{
				g.setColor(r.color);
				g.fillRect(r.x, r.y, r.dx, r.dy);
			}
			
			// draw current room border
			g.setColor(new Color(255-lv.current.color.getRed(),
					255-lv.current.color.getGreen(),
					255-lv.current.color.getBlue())
					);
			g.drawRect(lv.current.x, lv.current.y, 
					lv.current.dx, lv.current.dy);
		}
		

	 	private class Listener implements KeyListener {

	 		
	 		public void keyPressed(KeyEvent arg0)
	 		{
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