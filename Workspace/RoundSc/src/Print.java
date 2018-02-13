import java.util.LinkedList;

public class Print {
	
	public static void printTable(LinkedList<Node>answer) {
		int sumOfWaitingTime = 0;
		int sumOfTurnArroundTime = 0;
		int counter = 0;
		System.out.println("||======||==============||============||===================||==============||");
		System.out.println("|| Name || Arrival Time || Burst Time || Turn Arround Time || Waiting Time ||");
		System.out.println("||======||==============||============||===================||==============||");
		for(Node temp : answer) {
			if(!temp.getDone()) {
				continue;
			}else {
				System.out.printf("||%6s||%14s||%12s||%19s||%14s||\n",temp.getName(),temp.getArrivalTime(),temp.getBeginningBurstTime(),temp.getCompletionTime()-temp.getArrivalTime(),temp.getCompletionTime()-temp.getArrivalTime()-temp.getBeginningBurstTime());
				sumOfWaitingTime += (temp.getCompletionTime()-temp.getArrivalTime()-temp.getBeginningBurstTime());
				sumOfTurnArroundTime += (temp.getCompletionTime()-temp.getArrivalTime());
				counter +=1;
			}
		}
		System.out.println("||======||==============||============||===================||==============||");
		System.out.println("Average Turn Arround Time : " + (float)sumOfTurnArroundTime/counter);
		System.out.println("Average   Waiting   Time  : " + (float)sumOfWaitingTime/counter);
		System.out.println();
	}
	public static void printGantChart(LinkedList<Node>answer) {
		
		for(int i = 0 ; i < answer.size() ; i++) {
			if(i == 0) {
				System.out.print("|---");
			}else {
				if(answer.get(i).getName().equals(answer.get(i-1).getName())) {
					System.out.print("---");
				}else {
					System.out.print("|---");
				}
			}
		}
		System.out.println("|");
		
		System.out.print("|");
		for(int i = 0 ; i < answer.size()-1 ; i++) {
			if(answer.get(i).getName().equals(answer.get(i+1).getName())) {
				System.out.printf("%-3s",answer.get(i).getName());
			}else {
				System.out.printf("%-3s|",answer.get(i).getName());
			}
		}
		System.out.printf("%-3s|\n",answer.get(answer.size()-1).getName());
		
		for(int i = 0 ; i < answer.size() ; i++) {
			if(i == 0) {
				System.out.print("|---");
			}else {
				if(answer.get(i).getName().equals(answer.get(i-1).getName())) {
					System.out.print("---");
				}else {
					System.out.print("|---");
				}
			}
		}
		System.out.println("|"); 		
	}
}
