import java.util.*;

public class SJF {

	public void sjf(LinkedList<Node> p, int sizeBT, int sizeProcess) {
		int nextTime = 0;
		int i = 0;
		LinkedList<Node> queue = new LinkedList<Node>();
		LinkedList<Node> hasil = new LinkedList<Node>();
		while(nextTime <= sizeBT ) {
			while(i < sizeProcess) {
				if(nextTime >= p.get(0).AT) {
					queue.add(p.get(0));
					p.remove(0);
					sizeProcess--;
				}
				else {
					i++;
				}
			}
			i = 0;
			if(!queue.isEmpty()) {
				Collections.sort(queue, new SortBT());
				queue.get(0).P = nextTime;
				queue.get(0).WT = queue.get(0).P - queue.get(0).AT;
				queue.get(0).TAT = queue.get(0).WT + queue.get(0).BT;
				hasil.add(queue.get(0));
				nextTime = nextTime + queue.get(0).BT;
				queue.remove(0);
			}
			else {
				nextTime++;
			}
			
		}
		p.addAll(hasil);
	}
	
}
