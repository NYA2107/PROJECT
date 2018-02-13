package Node;


public class Node {
	public String Source;
	public String Destination;
	public double Value;
	public String Point;
	
	
	public Node(String Point) {
		this.Point = Point;
	}
	
	public Node(String Source, String Destination, double Value) {
		this.Source = Source;
		this.Destination = Destination;
		this.Value = Value;
	}
	
	
	
}
