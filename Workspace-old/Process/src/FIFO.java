import java.util.*;

public class FIFO {

	public void fifo(List<Node> p, int BTsize) {
		int curr = 0;
		int i = 0;
		while(curr < BTsize ) {
			p.get(i).P = curr;
			p.get(i).WT = p.get(i).P;
			p.get(i).TAT = p.get(i).WT + p.get(i).BT ;
			curr += p.get(i).BT;
			i++;
		}
	}

}
