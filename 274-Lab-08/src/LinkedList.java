/**
 * @author joey pham
 * @date 25 october 2018
 * this represents a LinkedList that will contain all circles
 */
public class LinkedList {
	public static class Node {
		/**
		 * this represetns a circle
		 */
		private Circle data;
		
		/**
		 * this represents teh next node in the list
		 */
		private Node next;
		
		/**
		 * constrcuctor
		 * @param c circle to set it to
		 */
		public Node ( Circle c ) {
			data = c;
			next = null;
		}
		
		/**
		 * constructor
		 * @param c circle to set it to
		 * @param n the next node
		 */
		public Node ( Circle c, Node n ) {
			data = c;
			next = n;
		}
	}
	
	/**
	 * the first node in the linked list
	 */
	private Node first;
	
	/**
	 * the last node in the linked list
	 */
	private Node last;
	
	/**
	 * constructor
	 */
	public LinkedList ( ) {
		first = null;
		last = null;
	}
	
	/**
	 * determines whether the list is emtpy or not
	 * @return true or false if the list is empty
	 */
	public boolean isEmpty ( ) {
		return ( first == null );
	}
	
	/**
	 * size of the list
	 * @return the number size of the list
	 */
	public int size ( ) {
		int count = 0;
		Node n=  first;
		while ( n != null ) {
			count = count + 1;
			n = n.next;
		}
		return count;
	}
	
	/**
	 * get the circle at the asked index
	 * @param index the index the user is searching at
	 * @return circle at the gvien index
	 */
	public Circle get ( int index ) {
		if ( index < 0 || index >= size ( ) ) {
			System.out.print ( "Index out of bounds." );
			return new Circle ( 0, 0, 0 );
		} else { 
			Node n = first;
			for ( int i = 1; i <= index; i++ ) {
				n = n.next;
			}
			return n.data;
		}
	}
	
	/**
	 * set the circle at the given index
	 * @param index index to look at 
	 * @param c circle to set
	 */
	public void set ( int index, Circle c ) {
		if ( index < 0 || index >= size ( ) ) {
			System.out.print ( "Index out of bounds." );
		} else { 
			Node n = first;
			for ( int i = 1; i <= index; i++ ) {
				n = n.next;
			}
			n.data = c;
		}
	}
	
	/**
	 * add a circle to the end of the list
	 * @param c circle to add
	 */
	public void add ( Circle c ) { 
		if ( isEmpty ( ) ) {
			first = new Node ( c );
			last = first;
		} else {
			Node n = new Node ( c );
			last.next = n;
			last = n;
		}
	}
	
	/**
	 * add a circle at the given index
	 * @param index index to look at
	 * @param c circle to add
	 */
	public void add (int index, Circle c ) {
		if ( index < 0 || index > size ( ) ) {
			System.out.println ( "Index out of bounds." );
		} else {
			if ( index == 0 ) {
				first = new Node ( c, first );
				if ( last == null ) {
					last = first;
				}
			} else {
				Node n = first;
				for ( int i = 1; i < index; i++ ) {
					n = n.next;
				}
				n.next = new Node ( c, n.next );
				if ( n.next.next == null ) {
					last = n.next;
				}
			}
		}
	}
	
	/**
	 * remove the circle at the given index
	 * @param index index to remopve the circle at
	 * @return circle that was removed
	 */
	public Circle remove ( int index ) {
		Circle rem = new Circle ( 0, 0, 0 );
		if ( index < 0 || index >= size ( ) ) {
			System.out.println ( "Index out of bounds." );
		} else {
			if ( index == 0 ) {
				rem = first.data;
				first = first.next;
				if ( first == null ) {
					last = null;
				}
			} else {
				Node n = first;
				for ( int i = 1; i < index; i++ ) {
					n = n.next;
				}
				rem = n.next.data;
				n.next = n.next.next;
				if ( n.next == null ) {
					last = n;
				}
			}
		}
		return rem;
	}
	
	/**
	 * remove the first instance of the given circle
	 * @param c circle to remove
	 * @return the removed circle
	 */
	public Circle remove ( Circle c ) {
		Circle rem = new Circle ( 0, 0, 0 );
		if ( !isEmpty ( ) ) {
			if ( c.equals ( first.data ) ) {
				rem = first.data;
				first = first.next;
				if (first == null ) {
					last = null;
				}
			} else {
				Node n = first;
				while ( n.next != null && ! ( n.next.data.equals ( c ) ) ) {
					n = n.next;
				}
				if ( n.next == null ) {
					System.out.println ( "Does not exist." );
				} else { 
					rem = n.next.data;
					n.next = n.next.next;
					if ( n.next == null ) {
						last = n;
					}
				}
			}
		}
		return rem;
	}
	
}
