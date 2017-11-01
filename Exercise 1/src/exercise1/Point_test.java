package exercise1;

public class Point_test {

	public static void main(String[] args) {
		Point1 p1 = new Point1(4,4);
		Point1 p2 = new Point1(9,4);
		//Point1 p3 = new Point1(2,4);
		Point1 o1 = new Point1(1,2);
		Point1 o2 = new Point1(5,2);
		Segment s = new Segment(p1, p2);
		Segment other = new Segment(o1,o2);
		
		//s.moveVertical(8);
		//s.changeSize(-1);
		//s.changeSize(-1);
		//s.changeSize(-1);
		
		//s.pointOnSegment(p1);
		System.out.println(s.toString());
		System.out.println(other.toString());
		System.out.println(s.overlap(other));
		
		//System.out.println(s.isRight(other));
		
		
		
		
		//System.out.println(p1.equals(p2));
		//p1.move(-4, -1);
		//System.out.println(p1.toString());
		

	}

}
