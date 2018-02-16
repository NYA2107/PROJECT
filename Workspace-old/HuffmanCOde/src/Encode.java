

public class Encode {
	public static String encode(String source,Tree tree) {
		String result = "";
		for(int i = 0 ; i < source.length() ; i++) {
			Character ch = source.charAt(i);
			String temp = findCode(ch,tree);
			result+=temp + " ";
		}
		return result;
	}
	
	private static String findCode(Character source,Tree tree) {
		Node curr = tree.getRoot();
		while(!curr.isLeaf()) {
			if(curr.getLeft().getData().contains(source.toString())) {
				curr = curr.getLeft();
			}else if (curr.getRight().getData().contains(source.toString())) {
				curr = curr.getRight();
			}else {
				break;
			}
		}
		return curr.getData().equals(source.toString())  ? curr.getCode() : "(Char not in the tree)";
	}
	
	
}
