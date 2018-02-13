

public class DivideAndConquer {

	public static Node findMin(Node[] data) {
		return divideMin(data,0,data.length-1);
	}
	private static Node divideMin(Node[] data,int left,int right) {
		if(left == right) {
			return data[left];
		}
		int middle = (left+right)/2;
		Node min1 = divideMin(data,left,middle);
		Node min2 = divideMin(data,middle+1,right);
		return conquerMin(min1,min2);
	}
	private static Node conquerMin(Node temp1,Node temp2) {
		return temp1.getScore() < temp2.getScore() ? temp1 : temp2;
	}
	
	
	public static Node findMax(Node[] data) {
		return divideMax(data,0,data.length-1);
	}
	private static Node divideMax(Node[] data,int left,int right) {
		if(left == right) {
			return data[left];
		}
		int middle = (left+right)/2;
		Node max1 = divideMax(data,left,middle);
		Node max2 = divideMax(data,middle+1,right);
		return conquerMax(max1,max2);
	}
	private static Node conquerMax(Node temp1,Node temp2) {
		return temp1.getScore() < temp2.getScore() ? temp2 : temp1;
	}
	
	
	public static void sorting(Node[] data) {
		sort(data,0,data.length-1);
	}
	
	private static void sort(Node[] data, int left, int right) {
		if(left < right) {
			
			int middle = (left+right)/2;
			
			sort(data,left,middle);
			sort(data,middle+1,right);
			
			merge(data,left,middle,right);
		}
	}
	
	private static void merge(Node[] data,int left, int middle, int right) {
		
		int s1 = middle-left+1;
		int s2 = right-middle;
		
		Node[] data1 = new Node[s1];
		Node[] data2 = new Node[s2];
		
		for(int i = 0 ; i < s1 ; ++i) {
			data1[i] = data[left+i];
		}
		for(int j = 0 ; j < s2 ; ++j) {
			data2[j] = data[middle+1+j];
		}
		
		int i = 0,j=0;
		int k = left;
		
		while(i < s1 && j < s2) {
			if(data1[i].getScore() >= data2[j].getScore()) {
				data[k] = data1[i];
				i++;
			}else {
				data[k] = data2[j];
				j++;
			}
			k++;
		}
		
		while(i < s1) {
			data[k] = data1[i];
			i++;
			k++;
		}
		while(j < s2) {
			data[k] = data2[j];
			j++;
			k++;
		}	
	}
}
