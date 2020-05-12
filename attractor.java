package projekt;

import java.awt.Graphics;

class Earth {

	float mass;
	float G;
	Vector position;
	float width;
	float height;
	boolean dragging = false;
	boolean rollover = false;
	int x = 600;
	int y = 400;

	public Earth() {
		position = new Vector(width / 2, height / 2);
		mass = 20;
		G = 1;
		// dragOffset = new Vector(0,0);
	}

	public Vector attract(Earth m) {
		Vector force = Vector.sub(position, m.position);
		float distance = force.mag(position, m.position);
		// d = constrain(d,5,25);
		force.normalize(position, m.position);
		float strength = (G * mass * m.mass) / (distance * distance);
		return force.mult(strength, force);
	}

	public void display(Graphics g) {
		g.fillOval(x, y, 100, 100);
	}

}
