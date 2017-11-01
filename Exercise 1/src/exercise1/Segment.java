package exercise1;

public class Segment {
	
	private Point1 _poLeft;
	private Point1 _poRight;
	
	public Segment(Point1 left, Point1 right) {		
		this._poLeft = new Point1(left.getX(),left.getY());
		this._poRight = new Point1(right.getX(), left.getY());
	}
	
	public Segment(int leftX, int leftY, int rightX, int rightY) {
		this._poLeft = new Point1(leftX,leftY);
		this._poRight = new Point1(rightX,leftY);
	}
	
	public Segment(Segment other) {
		this._poLeft=other.getPoLeft();
		this._poRight=other.getPoRight();
	}
	
	public Point1 getPoLeft() {
		return this._poLeft;
	}
	public Point1 getPoRight() {
		return this._poRight;
	}
	public int getLength() {
		return this._poRight.getX() - this._poLeft.getX();
	}

	public String toString() {
		return this._poLeft.toString()+"---"+this._poRight.toString();
	}
	
	public boolean equals( Segment other) {
		if(this.getPoLeft().equals(other.getPoLeft()) && this.getPoRight().equals(other.getPoRight()))
			return true;
		return false;
	}

	public boolean isAbove(Segment other) {
		if(this.getPoLeft().isAbove(other.getPoLeft()))
			return true;
		return false;
	}

	public boolean isUnder(Segment other) {
		if(this.getPoLeft().getY()==other.getPoLeft().getY())
			return false;
		return !isAbove(other);
	}

	public boolean isLeft(Segment other) {
		if(this.getPoRight().getX()<other.getPoLeft().getX())
			return true;
		return false;
	}

	public boolean isRight(Segment other) {
		if(this.getPoLeft().getX()>other.getPoRight().getX())
			return true;
		return false;
	}

	public void moveHorizontal(int delta) {
		this.getPoLeft().move(delta, 0);
		this.getPoRight().move(delta, 0);
	}

	public void moveVertical(int delta) {
		this.getPoLeft().move(0, delta);
		this.getPoRight().move(0, delta);		
	}
	
	public void changeSize(int delta) {
		if(delta >= -(getPoRight().getX() - getPoLeft().getX())) {
			this.getPoRight().move(delta, 0);
		}
	}
	
	public boolean pointOnSegment(Point1 p) {
		if (p.getY()==this.getPoLeft().getY())
			if(p.getX()>= this.getPoLeft().getX() && p.getX()<=this.getPoRight().getX())
				return true;
		return false;
	}
	
	public boolean isBigger(Segment other) {
		if(this.getLength()>other.getLength())
			return true;
		return false;
	}
	
	public int overlap(Segment other) {
		//no overlap
		if(this.isLeft(other) || this.isRight(other)) return 0; // no overlap
		
		
		if(this.getPoLeft().getX()>=other.getPoLeft().getX() && this.getPoRight().getX()<=other.getPoRight().getX()) // this segment is all bigger
			return this.getLength();
		
		if(this.getPoLeft().getX() < other.getPoLeft().getX() && this.getPoRight().getX() > other.getPoRight().getX()) // this segment is all sammaler
			return other.getLength();
		
		if(this.getPoLeft().getX() > other.getPoLeft().getX() && this.getPoRight().getX() > other.getPoRight().getX()) // overlaping on the right
			return other.getPoRight().getX() - this.getPoLeft().getX();
		
		return this.getPoRight().getX() - other.getPoLeft().getX(); // overlaping on the left
	}
	
	public double trapezePerimeter (Segment other) {
		return this.getLength()+other.getLength()+this.getPoLeft().distance(other.getPoLeft())+this.getPoRight().distance(other.getPoRight());	
	}
}
	