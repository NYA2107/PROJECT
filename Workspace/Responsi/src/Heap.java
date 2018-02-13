
public class Heap {

	public int length;
	public Node[] array;
	public Node[] sorted;
	int current = 0;
	Heap(int a) {
		length = a;
		array = new Node[length+1];
		sorted = new Node[length+1];
	}
	
	
public void insert(String nama, int usia, int hasilTest) {
		
		Node temp = new Node(nama, usia, hasilTest);
		current += 1;
		array [current] = temp;
		int count = current;
		while (count != 1) {
			if(array[count].hasilTest < array[parrent(count)].hasilTest) {
				break;
			}
			else if(array[count].hasilTest >= array[parrent(count)].hasilTest){
				array[0] = array[count];
				array[count] = array[parrent(count)];
				array[parrent(count)] = array[0];
			}
			count = parrent(count);
		}
		
	}
	
	public void mindel() {
		int i = 1;
		for(Node temp : array) {
		sorted[i].nama =  array[1].nama;
		array[1] = array[current];
		array[current] = null;
		current = current-  1;
		i++;
		heapify(1);
		}
		for(i=1; i<=3;i++) {
			System.out.println(sorted[i].hasilTest);
		}
	}

	private void heapify(int index) {
		while(index <= current/2) {
			if(index*2 == current) {
				if(array[index].hasilTest < array[leftChild(index)].hasilTest ) {
					array[0] = array[index];
					array[index] = array[leftChild(index)];
					array[leftChild(index)] = array[0];
					index = leftChild(index);
				}
				else {
					break;
				}
			}
			else{
				if(array[leftChild(index)].hasilTest < array[leftChild(index)+1].hasilTest  ) {
					if( array[leftChild(index)+1].hasilTest > array[index].hasilTest) {
						array[0] = array[index];
						array[index] = array[leftChild(index)+1];
						array[leftChild(index)+1] = array[0];
						index = leftChild(index) + 1;
					}
					else {
						break;
					}
					
				}
				else if(array[leftChild(index)].hasilTest > array[leftChild(index)+1].hasilTest) {
					if( array[leftChild(index)].hasilTest > array[index].hasilTest) {
						array[0] = array[index];
						array[index] = array[leftChild(index)];
						array[leftChild(index)] = array[0];
						index = leftChild(index);
					}
					else {
						break;
					}
				}
			}
		}
	}
	

	
	private int parrent(int current) {
		return current/2;
	}
	
	private int leftChild(int current) {
		return current*2; 
	}




}
