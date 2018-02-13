
public class Node {
	
	private String name;
	private int burstTime;
	private int arrivalTime;
	private int priority;
	private int completionTime;
	
	public int getCompletionTime() {
		return completionTime;
	}
	public String getName() {
		return name;
	}
	public int getBurstTime() {
		return burstTime;
	}
	public int getArrivalTime() {
		return arrivalTime;
	}
	public int getPriority() {
		return priority;
	}
	
	public Node(String name,int arrivalTime,int burstTime,int priority) {
		this.name = name;
		this.arrivalTime = arrivalTime;
		this.burstTime = burstTime;
		this.priority = priority;
	}
	
	public Node(Node temp,int completionTime) {
		this.name = temp.getName();
		this.burstTime = temp.getBurstTime();
		this.priority = temp.getPriority();
		this.arrivalTime = temp.getArrivalTime();
		this.completionTime = completionTime;
	}
	
}
