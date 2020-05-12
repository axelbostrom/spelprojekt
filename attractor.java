package projekt;

class Earth {

	float mass;
	float G;
	Vector position;
	float width;
	float height;
	boolean dragging;
	boolean rollover;
	Vector dragOffset;
	
	
	Earth() {
		position = new Vector(width/2,height/2);
		mass = 20;
		G = 1;
		dragOffset = new Vector(0,0);
	}
	
	Vector attract(Earth m) {
		Vector force = Vector.sub(position,m.position);
		float d = force.mag(position,m.position);
		//d = constrain(d,5,25);
		force.normalize();
		float strength = (G * mass * m.mass) / (d * d);
		
		return dragOffset;
		
	}
	
	
}
