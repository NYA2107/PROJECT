import java.util.LinkedList;

public class Round {
	public static void StartScheduling(LinkedList<Node>process,int quantumTime) {
		LinkedList<Node>queue = new LinkedList<Node>();
		LinkedList<Node>answer = new LinkedList<Node>();
		
		int currTime = 0;
		Node temporary = null;
		while(!process.isEmpty() || !queue.isEmpty() || temporary != null) {
			while(!process.isEmpty()) {
				if(process.getFirst().getArrivalTime() <= currTime) {
					queue.add(process.poll());
				}else {
					break;
				}
			}
			if(temporary != null) {
				queue.add(temporary);
			}
			int nextTime = 0;
			if(!queue.isEmpty()) {
				Node temp = queue.poll();
				if(temp.getBurstTime() <= quantumTime) {
					answer.add(new Node(temp,currTime+temp.getBurstTime(),true));
					temporary = null;
					nextTime = temp.getBurstTime();
				}else {
					answer.add(new Node(temp,temp.getBurstTime()-quantumTime));
					temporary = new Node(temp,temp.getBurstTime()-quantumTime);
					nextTime = quantumTime;
				}
			}
			currTime += nextTime;
		}
		System.out.println("~SCHEDULING TABLE~");
		Print.printTable(answer);
		System.out.println("~GANT CHART~");
		Print.printGantChart(answer);
	}
}
