

public class BruteForce {
	
	public static void sorting(Node[] data) {
		for(int i = 0 ; i < data.length ; i++) {
			int max = i;
			for(int j = (i+1) ; j <= data.length-1 ; j++) {
				if(data[j].getScore() > data[max].getScore()) {
					max = j;
				}
			}
			Node temp = data[max];
			data[max] = data[i];
			data[i] = temp;
		}
	}
	
	public static Node findMin(Node[] data) {
		Node temp = data[0];
		for(int i = 1 ; i < data.length ; i++) {
			if(temp.getScore() > data[i].getScore()) {
				temp = data[i];
			}
		}
		return temp;
	}
	
	public static Node findMax(Node[] data) {
		Node temp = data[0];
		for(int i = 1 ; i < data.length ; i++) {
			if(temp.getScore() < data[i].getScore()) {
				temp = data[i];
			}
		}
		return temp;
	}
	
	
}
