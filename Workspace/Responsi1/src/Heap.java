
import java.util.*;

public class Heap {

	 public void sort(List<Node> list){
	        int n = list.size();
	        for (int i = n / 2 - 1; i >= 0; i--)
	            heapify(list, n, i);
	 
	   
	        for (int i=n-1; i>=0; i--) {
	            Collections.swap(list, 0, i);
	            heapify(list, i, 0);
	        }
	        //PRINT
	        System.out.println("===================SORTED=====================");
			System.out.println("+--------------------------------------------+");
			System.out.println("|         Nama       |   Usia   | Hasil Test |");
			System.out.println("+--------------------------------------------+");
	        for(int i = 0 ; i<=list.size()-1 ; i++) {
				System.out.printf("|%-20s|%-10s|%-12s|\n",list.get(i).nama,list.get(i).usia,list.get(i).hasilTest);
			}
	        System.out.println("+--------------------------------------------+");
	        System.out.println("==============================================");
	    }
	
	
	public static void heapify(List<Node> list, int n, int i){
        int smallest = i;  
        int l = 2*i + 1;  // left = 2*i + 1
        int r = 2*i + 2;  // right = 2*i + 2
        
       
        if (l < n && list.get(l).hasilTest < list.get(smallest).hasilTest) {
            smallest = l;
        }
        
        if (r < n && list.get(r).hasilTest < list.get(smallest).hasilTest) {
            smallest = r;
        }
        
        if (smallest != i)
        {
            Collections.swap(list, i, smallest);
 
            heapify(list, n, smallest);
        }
    }
	
}
