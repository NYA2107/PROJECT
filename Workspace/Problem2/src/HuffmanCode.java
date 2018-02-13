
import java.util.*;

public class HuffmanCode {
	
	private static final int ASCII_SIZE = 256;
	StringBuffer prefix = new StringBuffer();
	
	private static class HuffmanLeaf extends HuffmanTree {
		public final char value;
		public HuffmanLeaf(int freq, char val) {
			super(freq);
			value = val;
		}
	}

	private static class HuffmanNode extends HuffmanTree {
		public final HuffmanTree left, right;

		public HuffmanNode(HuffmanTree l, HuffmanTree r) {
			super(l.frequency + r.frequency);
			left = l;
			right = r;
		}
	}
	
	public HuffmanTree buildTree(String text) {
		PriorityQueue<HuffmanTree> trees = new PriorityQueue<HuffmanTree>();
		
		int[] charFreqs = new int[ASCII_SIZE];
		for (char c : text.toCharArray())
			charFreqs[c]++;
		
		for (int i = 0; i < charFreqs.length; i++)
			if (charFreqs[i] > 0)
				trees.offer(new HuffmanLeaf(charFreqs[i], (char) i));

		assert trees.size() > 0;
		
		while (trees.size() > 1) {
			HuffmanTree a = trees.poll();
			HuffmanTree b = trees.poll();
			trees.offer(new HuffmanNode(a, b));
		}
		return trees.poll();
	}
	
	
	public Map<Character, String> mappingCodes(HuffmanTree tree) {
		if(tree != null) {
			return mappingCodes(tree, new HashMap<>());
		} else {
			return null;
		}
	}
	
	private Map<Character, String> mappingCodes(HuffmanTree tree, Map<Character, String> codeMap) {
		assert tree != null;
		if (tree instanceof HuffmanLeaf) {
			HuffmanLeaf leaf = (HuffmanLeaf) tree;
			codeMap.put(leaf.value, prefix.toString());
		} else if (tree instanceof HuffmanNode) {
			HuffmanNode node = (HuffmanNode) tree;
			prefix.append('0');
			mappingCodes(node.left, codeMap);
			prefix.deleteCharAt(prefix.length() - 1);

			prefix.append('1');
			mappingCodes(node.right, codeMap);
			prefix.deleteCharAt(prefix.length() - 1);
		}
		return codeMap;
	}
	
	public String printTable(HuffmanTree tree) {
		if(tree != null) {
			StringBuilder builder = new StringBuilder();
			builder.append(
					"===========================\n"
				   +"|       Code  Table       |\n"
				   +"|-------------------------|\n"
				   +"| Key | Freq |    Code    |\n");
			printTable(tree, builder);
			builder.append("===========================\n");
			return builder.toString();
		} else {
			assert tree == null;
			return "Empty Tree";
		}
		
	}
	
	public String printTable(HuffmanTree tree, StringBuilder builder) {
		assert tree != null;
		if (tree instanceof HuffmanLeaf) {
			HuffmanLeaf leaf = (HuffmanLeaf) tree;
			String valueToWrite =  Character.toString(leaf.value);
			if(valueToWrite.equals("\n"))valueToWrite = "\\n";
			else if(valueToWrite.equals(" "))valueToWrite = "\' \'";
			builder.append(String.format(
					 "|-----|------|------------|\n"
					+"| %-3s | %4d | %-10s |\n", valueToWrite, leaf.frequency, prefix.toString()));
		} else if (tree instanceof HuffmanNode) {
			HuffmanNode node = (HuffmanNode) tree;
			prefix.append('0');
			printTable(node.left, builder);
			prefix.deleteCharAt(prefix.length() - 1);

			prefix.append('1');
			printTable(node.right, builder);
			prefix.deleteCharAt(prefix.length() - 1);
		}
		return builder.toString();
	}
	
}