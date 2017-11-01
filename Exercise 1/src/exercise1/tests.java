package exercise1;

public class tests {

	public static void main(String[] args) {
		Point2 p2 = new Point2(2, 4);
		
		//Point2 p3 = new Point2(1,3);
		//p3.move(5,6);
		
		System.out.println(p2.toString());
		//System.out.println("radius: " + p2._radius);
		//System.out.println("alpha: " + p2._alpha);
		
		
		p2.setX(-1);
		System.out.println(p2.toString());
		
		//System.out.println(p3.distance(p2));
		
		

	}

}
