package projekt2;

import java.lang.Math;

public class Vector {

	double x;
	double y;
	Vector acceleration;

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public Vector(double x2, double y2) {
		x2 = this.x;
		y2 = this.y;
	}

	public static Vector sub(Vector position, Vector position2) {
		return new Vector(position.getX() - position2.getX(), position.getY() - position2.getY());
	}

	public double mag(Vector position, Vector position2) {
		double sumx = position.getX() - position2.getX();
		double sumy = position.getY() - position2.getY();

		double hyp = (double) Math.sqrt((sumx * sumx) + (sumy * sumy));
		return hyp;
	}

	public Vector normalize(Vector position, Vector position2) {

		double dx = position.getX() - position2.getX();
		double dy = position.getY() - position2.getY();

		double length = Math.sqrt(dx * dx + dy * dy);
		if (length != 0) {
			dx = (dx / length);
			dy = (dy / length);
		}

		Vector NormVector = new Vector(dx, dy);

		return NormVector;

	}

	public Vector mult(double strength, Vector force) {
		double x = strength * force.getX();
		double y = strength * force.getY();

		Vector multforce = new Vector(x, y);

		return multforce;
	}

	public static Vector div(Vector force, double mass) {
		double x = force.getX();
		double y = force.getY();

		double nx = x / mass;
		double ny = y / mass;

		Vector nForce = new Vector(nx, ny);
		return nForce;
	}

	public void add(Vector f) {
		setAcceleration(f);

	}

	private void setAcceleration(Vector f) {
		this.acceleration = f;
	}

}
