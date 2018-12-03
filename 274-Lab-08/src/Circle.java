/**
 * @author joey pham
 * @date 25 october 2018
 * this represents a circle with attributes x, y, and radius
 *
 */
public class Circle {
	/**
	 * this represents the x value ofa  circle
	 */
	private int x;
	
	/**
	 * this represents the y value of a circle
	 */
	private int y;
	
	/**
	 * this represents the radius of a circle
	 */
	private int radius;
	
	/**
	 * constructor
	 * @param newX x coordinate to set to set
	 * @param newY y coordinate to set
	 * @param newRadius radius to set
	 */
	public Circle ( int newX, int newY, int newRadius ) {
		x = newX;
		y = newY;
		radius = newRadius;
	}
	
	/**
	 * used to compare if two circles are the same
	 * @param o object to compare to the circle
	 * @return true or false if the two circles are the same
	 */
	@Override 
	public boolean equals ( Object o ) {
		if ( o instanceof Circle ) {
			Circle c = ( Circle ) o;
			boolean checkX = ( this.x == c.x );
			boolean checkY = ( this.y == c.y );
			boolean checkRadius = ( this.radius == c.radius );
			return ( checkX && checkY && checkRadius );
		} else {
			return false;
		}		
	}
	
	/**
	 * used to print out the values and attributes of the circle
	 * @return the string with all the values
	 */
	@Override
	public String toString ( ) {
		return ( "(" + this.x + "," + this.y + ") R = " + this.radius );
	}
	
}
