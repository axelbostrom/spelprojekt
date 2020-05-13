package projekt2;

import java.awt.Color;

public class Earth extends Particle {

	static double x;
	static double y;
	static Vector position = new Vector(x, y);
	double mass;
	double gravity;
	double radian;

	public Earth(double x, double y, double radian, double mass, double gravity, Color color) {
		super(x, y, radian, mass, gravity, color);
	}

	public Vector attraction(Asteroid a) {
		Vector force = Vector.sub(position, a.position);
		double distance = force.mag(position, a.position);
		// d = constrain(d,5,25);
		force.normalize(position, Earth.position);
		double strength = (gravity * mass * mass) / (distance * distance);
		return force.mult(strength, force);
	}

}
