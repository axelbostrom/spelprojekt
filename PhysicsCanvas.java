package projekt2;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

public class PhysicsCanvas extends Canvas implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean running;
	private Earth earth;
	private Asteroid asteroid1;
	private Vector vel1 = new Vector(1, 0);
	private Vector acc1 = new Vector(0, 0);

	public PhysicsCanvas() {
		Dimension d = new Dimension(800, 600);
		setPreferredSize(d);
		setMinimumSize(d);
		setMaximumSize(d);

		earth = new Earth(750, 450, 50, 100, 10, Color.GREEN);
		asteroid1 = new Asteroid(550, 350, 20, vel1, acc1, 40, 1, Color.GRAY);
	}

	@Override
	public void run() {
		while (running) {
			update();
			render();

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
				running = false;
			}
		}
	}

	public void start() {
		if (!running) {
			Thread t = new Thread(this);
			createBufferStrategy(3);
			running = true;
			t.start();
		}
	}

	private void render() {
		BufferStrategy strategy = getBufferStrategy();
		Graphics2D g = (Graphics2D) strategy.getDrawGraphics();

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());

		earth.render(g);

		Vector force = earth.attraction(asteroid1);

		asteroid1.applyForce(force);
		asteroid1.update();
		asteroid1.render(g);

		strategy.show();
	}

	private void update() {
		asteroid1.update();
	}

	public static void main(String[] args) {
		JFrame myFrame = new JFrame("My physics canvas");
		PhysicsCanvas physics = new PhysicsCanvas();
		myFrame.add(physics);
		myFrame.pack();
		myFrame.setResizable(false);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setVisible(true);
		physics.start();
		myFrame.setLocationRelativeTo(null);
	}

}