package projekt;

import javax.swing.*;
import java.awt.*;

public class test extends JPanel {
	// private int boardSizex = 500;
	// private int boardSizey = 500;

	// temporära variabler astroiden ska bli en egen klass osv
	int x = 0, y = 0, movmentx = 1, movmenty = 1;
	int x1 = 600, y1 = 400;

	private void move() {
		// Lite dumma rörelseregler vill att den ska åka runt i rutan
		if (x < x1) {
			movmentx = 1;
		} else if (x > x1) {
			movmentx = -1;
		} else if (y < y1) {
			movmenty = 1;
		} else if (y > y1) {
			movmenty = -1;
		}
		/*
		 * if(x + movmentx < 0){ movmentx = 1; }else if(x + movmentx > getWidth() -40){
		 * movmentx = -1; }else if(y+movmenty<0){ movmenty = 1; }else if(y+movmenty >
		 * getHeight()-40){ movmenty = -1; }
		 */
		x = x + movmentx;
		y = y + movmenty;
	}

	// Metod som ritar
	public void paint(Graphics g) {
		// Super paint gör att den tidigare utritningen försvinner
		super.paint(g);
		g.fillOval(x, y, 25, 25);
		g.fillOval(x1, y1, 70, 70);
	}

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Fysik väldigt kul");
		test upp = new test();
		frame.add(upp);
		frame.setSize(1200, 1000);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		while (true) {
			upp.move();
			upp.repaint();
			Thread.sleep(4);

		}
	}
}