package exercise1;

public class Point2 {
	private double _radius;
	private double _alpha;
	
	//constructor to set x & y in the first quarter 
	public Point2(int x, int y) {
		if (x < 0) {
			x = 0;
		}
		if (y < 0) {
			y = 0;
		}
		calcRadius(x,y);
		calcAlpha(x,y);
	}

	//copy constructor
	public Point2(Point2 other) {
		this._radius = other._radius;
		this._alpha = other._alpha;
	}
	
	//calc alpha by x & y
	private void calcAlpha(int x, int y) {				
		double r = (double) y / x;		
		this._alpha = Math.atan(r) * 180 / Math.PI;		
	}

	//calc radius by x & y
	private void calcRadius(int x, int y) {
		this._radius = Math.hypot(x,y);
	}
	
	//X's getter by radius & alpha
	public int getX() {
		return (int) Math.round((_radius * Math.cos(_alpha / 180 * Math.PI)));
	}
	
	//Y's getter by radius & alpha
	public int getY() {
		return (int) Math.round((_radius * Math.sin(_alpha / 180 * Math.PI)));
	}
	
	//set new x
	public void setX(int x) {
		int y=getY();

		if (x >= 0) {
			calcAlpha(x, y);
			calcRadius(x, y);
		}
	}

	//set new y 
	public void setY(int y) {
		int x = getX();
		
		if (y >= 0) {
			calcAlpha(x, y);
			calcRadius(x, y);		
		}
	}
	
	//check if current point equals to other  point
	public boolean equals(Point2 other) {
		if (this._alpha == other._alpha && this._radius == other._radius) {
			return true;
		}
		return false;
	}
	
	//check if current point is above other point
	public boolean isAbove(Point2 other) {
		if (this.getY() > other.getY()) {
			return true;
		}
		return false;
	}
	
	//check if current point is lower other point
	public boolean isUnder(Point2 other) {
		if (this.getY() == other.getY()) {
			return false;
		}
		return !(isAbove(other));
	}
	
	//check if current point is left than other point
	public boolean isLeft(Point2 other) {
		if (this.getX() < other.getY()) {
			return true;
		}
		return false;
	}
	
	//check if current point is right than other point
	public boolean isRight(Point2 other) {
		if (this.getX() == other.getX()) {
			return false;
		}
		return !(isLeft(other));
		}
	
	//calc distance between current point to other point
	public double distance(Point2 other) {
		return Math.hypot(other.getY() - this.getY(), other.getX() - this.getX());
	}
	
	//move current point 
	public void move(int dX, int dY) {
		int newX, newY;
		
		newX = this.getX() + dX;
		newY = this.getY() + dY;
		
		if ((newX > 0) && (newY > 0)) {
			calcRadius(this.getX() + dX, this.getY() + dY);
			calcAlpha(this.getX() + dX, this.getY() + dY);
		}
	}
	
	//print current point values
	public String toString() {
		return ("(" + this.getX() + "," + this.getY() + ")");
	}
}
