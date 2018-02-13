
public class Heap {
	
	public int length;
	public Node[] array;
	int current = 0;
	
	Heap(int a) {
		length = a;
		array = new Node[length+1];
	}
	
	public void insert(int priority, String name, int usia) {
		
		Node temp = new Node();
		current += 1;
		temp.priority = priority;
		temp.name = name;
		array [current] = temp;
		int count = current;
		while (count != 1) {
			if(array[count].priority < array[parrent(count)].priority) {
				break;
			}
			else if(array[count].priority >= array[parrent(count)].priority){
				array[0] = array[count];
				array[count] = array[parrent(count)];
				array[parrent(count)] = array[0];
			}
			count = parrent(count);
		}
		
	}
	
	
	private String mindel(){
		String temp =  array[1].name;
		array[1] = array[current];
		array[current] = null;
		current = current-  1;
		heapify(1);
		return temp;
	}
	
	private void heapify(int index) {
		while(index <= current/2) {
			if(index*2 == current) {
				if(array[index].priority < array[leftChild(index)].priority ) {
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
				if(array[leftChild(index)].priority < array[leftChild(index)+1].priority  ) {
					if( array[leftChild(index)+1].priority > array[index].priority) {
						array[0] = array[index];
						array[index] = array[leftChild(index)+1];
						array[leftChild(index)+1] = array[0];
						index = leftChild(index) + 1;
					}
					else {
						break;
					}
					
				}
				else if(array[leftChild(index)].priority > array[leftChild(index)+1].priority) {
					if( array[leftChild(index)].priority > array[index].priority) {
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
	
	public void print() {
		String a[] = {"Manager", "Sekertaris", "Bendahara", "Kepala Bagian Administrasi", "Kepala Bagian Pemasaran", "Kepala Bagian Gudang"};
		int count;
		System.out.println();
		System.out.println("+---------------------------------------------------+");
		System.out.println("|       JABATAN            |       NAMA             |");
		System.out.println("+---------------------------------------------------+");
		for(count = 1 ; count <= 6 ; count++) {
			System.out.printf("|%26s|%-24s|\n",a[count-1],mindel());
			
		}
		System.out.println("+---------------------------------------------------+");
		
	}
	
	private int parrent(int current) {
		return current/2;
	}
	
	private int leftChild(int current) {
		return current*2; 
	}
}
