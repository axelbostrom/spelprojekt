package projekt2;

import java.awt.Color;

public class Asteroid extends Particle {

	double x;
	double y;
	Vector position;
	Vector velocity;
	Vector acceleration;
	double mass;
	double gravity;
	double radian;

	public Asteroid(double x, double y, double radian, Vector velocity, Vector acceleration, double mass, double gravity, Color color) {
		super(x, y, radian, mass, gravity, color);
		position = new Vector(x,y);
		this.radian = radian;
		this.x = x;
		this.y = y;
		this.mass = mass;
		this.gravity = gravity;

		}
	
	public void applyForce(Vector force) throws NullPointerException {
		Vector f = Vector.div(force,mass);
		try  {
			acceleration.add(f);
		} catch (NullPointerException e) {
			
		}
	}

	public void update() {
		try {
		velocity.add(acceleration);
		position.add(velocity);
		
		double dx = position.getX();
		double dy = position.getY();
		
		x += dx;
		y += dy;

		if (x < radian)
			dx *= -1;
		if (y < radian)
			dy *= -1;

		
		} catch (NullPointerException e) {
			
		}
	}

}
