package projekt;

public class Asteroid {

	Vector position;
	Vector hastighet;
	Vector acceleration;
	float massa;

	Asteroid() {
		position = new Vector(400, 50);
		hastighet = new Vector(1, 0);
		acceleration = new Vector(0, 0);
		massa = 1;

	}

	public void force(Vector force) {
		Vector f = Vector.div(force, massa);
		acceleration.add(f);
	}
}
