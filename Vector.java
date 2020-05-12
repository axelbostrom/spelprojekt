package projekt;

import java.lang.Math;

public class Vector {
	
	float x;
	float y;
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public Vector(float x, float y) {
		x = this.x;
		y = this.y;
	}

	public static Vector sub(Vector position, Vector position2) {
		return new Vector(position.getX() - position2.getX(), position.getY() - position2.getY());
	}

	public float mag(Vector position, Vector position2) {
		float sumx = position.getX() - position2.getX();
		float sumy = position.getY() - position2.getY();
		
		float hyp = (float) Math.sqrt((sumx*sumx) + (sumy*sumy));
		return hyp;
	}

	public void normalize() {
		
		
	}

}
