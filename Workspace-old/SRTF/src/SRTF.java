import java.util.LinkedList;

public class SRTF {
	public static void StartScheduling(LinkedList<Node>process) {
		LinkedList<Node>queue = new LinkedList<Node>();
		LinkedList<Node>answer = new LinkedList<Node>();
		
		int currTime = 0;
		while(!process.isEmpty() || !queue.isEmpty()) {
			
			while(!process.isEmpty()) {
				if(process.getFirst().getArrivalTime() == currTime) {
					queue.add(process.poll());
				}else {
					break;
				}
			}
			
			if(!queue.isEmpty()) {
				int minIndex = findMin(queue);
				Node temp = queue.get(minIndex);
				queue.remove(minIndex);
				if(temp.getBurstTime()-1 == 0) {
					answer.add(new Node(temp,currTime+1,true));
				}else {
					queue.add(new Node(temp,temp.getBurstTime()-1));
					answer.add(temp);
				}
			}
			currTime++;
		}
		System.out.println("~SCHEDULING TABLE~");
		Print.printTable(answer);
		System.out.println("~GANT CHART~");
		Print.printGantChart(answer);
	}
	private static int findMin(LinkedList<Node>queue) {
		Node temp = queue.getFirst();
		int result = 0;
		for(int i = 1 ; i < queue.size() ; i++) {
			if(temp.getBurstTime() > queue.get(i).getBurstTime()) {
				temp = queue.get(i);
				result = i;
			}
		}
		return result;
	}
}
