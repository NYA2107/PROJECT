import java.util.*;

public class FIFO {
	
	public void fifo(LinkedList<Node> p, int BTsize) {
		int nextTime = 0;
		//int count = 0;
		LinkedList<Node> cek = new LinkedList<Node>();
		
		while(nextTime <= BTsize) {
			//System.out.println(nextTime + " " + p.get(0).name + " AT : " + p.get(0).AT);
				if(nextTime > p.get(0).AT) {
					//oSystem.out.println(nextTime + " " + p.get(0).name + " AT : " + p.get(0).AT);
					p.get(0).P = nextTime;
					p.get(0).WT = p.get(0).P - p.get(0).AT;
					p.get(0).TAT = p.get(0).WT + p.get(0).BT;
					cek.add(p.get(0));
					nextTime = nextTime + p.get(0).BT;
					
					p.remove(0);
					
					}
				else {
					nextTime++;
				}
			
		}
		p.addAll(cek);
		
	}
}

