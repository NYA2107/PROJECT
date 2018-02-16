import java.util.*;
import java.util.Comparator;

public class Priority {
	
	public static void StartScheduling(LinkedList<Node>process) {
		LinkedList<Node>answer = new LinkedList<Node>();
		int currTime = 0;
		process.sort(new PriorityComparator());
		while(!process.isEmpty()) {
			Node temp = process.poll();
			answer.add(new Node(temp,currTime+temp.getBurstTime()));
			currTime += temp.getBurstTime();
		}
		
		Print.printTable(answer);
		Print.printGantChart(answer);
	}
	
}

class PriorityComparator implements Comparator<Node>{

	@Override
	public int compare(Node o1, Node o2) {
		if(o1.getArrivalTime() < o2.getArrivalTime()) {
			return -1;
		}else if(o1.getArrivalTime() == o2.getArrivalTime() && o1.getPriority() > o2.getPriority()) {
			return -1;
		}else {
			return 1;
		}
	}
}
