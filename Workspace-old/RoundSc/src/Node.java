
public class Node {

		private String name;
		private int beginningBurstTime;
		private int burstTime;
		private int arrivalTime;
		private int completionTime;
		private boolean done;
		
		public String getName() {
			return name;
		}

		public int getBurstTime() {
			return burstTime;
		}

		public int getArrivalTime() {
			return arrivalTime;
		}
		public int getCompletionTime() {
			return completionTime;
		}
		public boolean getDone() {
			return done;
		}
		public int getBeginningBurstTime() {
			return beginningBurstTime;
		}

		public Node(String name,int arrivalTime,int burstTime) {
			this.name = name;
			this.burstTime = burstTime;
			this.arrivalTime = arrivalTime;
			this.beginningBurstTime = burstTime;
		}
		
		public Node(Node temp,int newBurstTime) {
			this.name = temp.getName();
			this.burstTime = newBurstTime;
			this.arrivalTime = temp.getArrivalTime();
			this.beginningBurstTime = temp.getBeginningBurstTime();
		}
		public Node(Node temp,int completionTime,boolean complete) {
			this.name = temp.getName();
			this.arrivalTime = temp.getArrivalTime();
			this.completionTime = completionTime;
			this.done = complete;
			this.beginningBurstTime = temp.getBeginningBurstTime();
		}
	}


