
public class SplayTree {
	
	private Node root;
	
	
	/************************
	 * Splay Tree Insertion *
	 ************************/
	public void insert(Integer id, String name) {
		if(root == null) {
			root = new Node(id,name);
			return;
		}
		
		root = splay(root,id);
		
		int cmp = id.compareTo(root.id);
		
		if(cmp < 0) {
			Node temp = new Node(id,name);
			temp.left = root.left;
			temp.right = root;
			root.left = null;
			root = temp;
		}
		else if(cmp > 0) {
			Node temp = new Node(id, name);
			temp.right = root.right;
			temp.left = root;
			root.right = null;
			root = temp;
		}
		else {
			root.id = id;
		}
	}
	

	
	/***********************
	 * Splay Tree Function *
	 ***********************/
	private Node splay(Node curr,Integer id) {
		if(curr == null) {
			return null;
		}
		
		int cmp1 = id.compareTo(curr.id);
		
		if(cmp1 < 0) {
			if(curr.left == null) {
				return curr;
			}
			
			int cmp2 = id.compareTo(curr.left.id);
			
			if(cmp2 < 0 ) {
				curr.left.left = splay(curr.left.left , id);
				curr = rotateRight(curr); 
			}
			 
			else if(cmp2 > 0) {
				curr.left.right = splay(curr.left.right , id);
				if(curr.left.right != null) {
					curr.left = rotateLeft(curr.left);
				}
			}
			
			if(curr.left == null) {
				return curr;
			}
			else {
				return rotateRight(curr);
			}
		}
		else if(cmp1 > 0) {
			if(curr.right == null) {
				return curr;
			}
			
			int cmp2 = id.compareTo(curr.right.id);
			
			if(cmp2 < 0) {
				curr.right.left = splay(curr.right.left,id);
				if(curr.right.left != null) {
					curr.right = rotateRight(curr.right);
				}
			}
			else if(cmp2 > 0) {
				curr.right.right = splay(curr.right.right, id);
				curr = rotateLeft(curr);
			}
			
			if(curr.right == null) {
				return curr;
			}
			else {
				return rotateLeft(curr);
			}
		}
		else {
			return curr;
		}
	}

	
	/***********************
	 * Splay Tree Rotation *
	 ***********************/
	private Node rotateRight(Node temp) {
		Node temp1 = temp.left;
		temp.left = temp1.right;
		temp1.right = temp;
		return temp1;
	}
	private Node rotateLeft(Node temp) {
		Node temp1 = temp.right;
		temp.right = temp1.left;
		temp1.left = temp;
		return temp1;
	}

	
	/********************
	 * Splay Tree Acces *
	 ********************/
	public void accesData(Integer id) {
		if(found(root,id)) {
			root = splay(root,id);
			System.out.println("Data dengan id " + id + 
					           " berhasil diakses");
		}
		else {
			System.out.println("Data tidak ditemukan");
		}
	}
	private boolean found(Node curr, Integer id) {
		while(curr != null) {
			int cmp = id.compareTo(curr.id);
			if(cmp == 0) {
				return true;
			}
			else if(cmp > 0) {
				curr = curr.right;
			}
			else {
				curr = curr.left;
			}
		}
		return false;
	}
	
	
	/********************
	 * Splay Tree Print *
	 ********************/
	public void print() {
		preOrder(root);
	}
	private void preOrder(Node curr) {
		if(curr == null) {
			return;
		}
		System.out.println(curr.id + "  " + curr.name);
		preOrder(curr.left);
		preOrder(curr.right);
	}

	/***********************
	 * Splay Tree Deletion *
	 ***********************/
	public void delete(Integer id) {
		if(found(root,id)) {
			remove(id);
			System.out.println("Data dengan id " + id + 
					           " berhasil dihapus");
		}
		else {
			System.out.println("Data tidak ditemukan !");
		}
	}
	private void remove(Integer id) {
		
		root = splay(root,id);
		if(root.left == null) {
			root = root.right;
		}
		else {
			Node temp = root.right;
			root = root.left;
			splay(root,id);
			root.right = temp;
		}
		
	}
}
