package exercise1;

public class Point1 {
	
	private int _x;
	private int _y;
	
	public Point1 (int x, int y) {
		
		if(x<0) _x=0;
		else _x=x;
		if(y<0) _y=0;
		else _y=y;		
	}
	
	public Point1 (Point1 other) {
		setX(other.getX());
		setY(other.getY());
	}
	
	public int getX() {
		return _x;
	}
	public int getY() {
		return _y;
	}
	
	public void setX(int num) {
		if(num>=0) _x=num;
	}
	
	
	public void setY (int num) {
		if(num>=0) _y=num;
	}
	
	public String toString() {
		return "("+getX()+","+getY()+")";
	}

	public boolean equals (Point1 other) {
		if(this.getX()==other.getX() && this.getY()==other.getY() ) return true;
		return false;
	}
	
	public boolean isAbove(Point1 other) {
		if(this.getY()>other.getY())return true;
		return false;
	}

	public boolean isUnder(Point1 other) {
		if (this.getY()==other.getY())return false;
		return !(isAbove(other));
	}

	public boolean isLeft(Point1 other) {
		if(this.getX()<other.getX()) return true;
		return false;
	}
	
	public boolean isRight(Point1 other) {
		if(this.getX()==other.getX())return false;
		return !(isLeft(other));
	}
	
	public double distance (Point1 p) {
		return Math.hypot((p.getY()-this.getY()),(p.getX()-this.getX()));
	}

	public void move(int dx, int dy) {
		if(dx>=-(this.getX()) && dy>=-(this.getY())) {
			setX(getX()+dx);
			setY(getY()+dy);
		}
	}

}
