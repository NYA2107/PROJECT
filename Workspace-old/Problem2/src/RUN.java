
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class RUN {
	private static final String MAZE_PATH = "./res/maze.txt";
	private static final String TEXT_PATH = "./res/text.txt";
	private ArrayList<String> buffer;
	private String[][] text;
	private Scanner scan, file;
	private HuffmanCode huffman;
	private Maze maze;	
	
	public RUN() {
		scan = new Scanner(System.in);
		huffman = new HuffmanCode();
		buffer = new ArrayList<String>();
		maze = new Maze(MAZE_PATH);
		loadString(TEXT_PATH);
	}
	
	private void loadString(String fileName) {
		try {
			file = new Scanner(new File(fileName));
			while (file.hasNext()) {
				String nextLine = file.nextLine();
				buffer.add(nextLine.replaceAll("\\s+", ""));
			}
		} catch (Exception e) {
			System.out.println(fileName + " can't be loaded!");
		} finally {
			file.close();
		}
		
		text = new String[buffer.size()][];
		for(int i = 0; i < buffer.size(); i++) {
			text[i] = buffer.get(i).split(",");
		}
	}
	
	private void menu() {
		System.out.print(
				 "\n=====================\n"
			     + "|     PROBLEM 02    |\n"
			     + "|-------------------|\n"
			     + "| 1. Print Maze     |\n"
			     + "| 2. Solve Maze     |\n"
			     + "| 3. Exit           |\n"
			     + "=====================\n"
			     + "Pilih: ");
	}
	
	public void run() {
		System.out.print("=== Problem 2 ===");
		do {
			menu();
			switch(scan.nextInt()) {
			case 1:
				printMaze();
				break;
			case 2:
				solveMaze();
				break;
			case 3:
				//scan.close();
				return;
			default:
				System.out.println("Invalid Input");
			}
				
		} while(true);
	}
	
	private void printMaze() {
		System.out.println("=== Print Maze ===");
		char[][] map = maze.getMaze();
		
		StringBuilder line = new StringBuilder();
		StringBuilder border = new StringBuilder();
		for(int j = 0; j < text.length; j++) {
			line.append("|-----------------");
			border.append("------------------");
		}
		line.append("|\n");
		border.append("-");
		System.out.println(border);
		for(int i = 0; i < text.length; i++) {
			for(int j = 0; j < text.length; j++) {
				if(map[i][j] == 'S') {
					System.out.printf("| %-16s", (text[i][j] + " [START] "));
				} else if (map[i][j] == 'F') {
					System.out.printf("| %-16s", (text[i][j] + " [FINISH] "));
				} else if (map[i][j] == '0') {
					System.out.printf("||||||||||||||||||");
				} else {
					System.out.printf("| %-15s ", text[i][j]);
				}
			}
			if(i != text.length - 1) System.out.print("|\n" + line);
			else System.out.print("|\n");
		}
		System.out.println(border);
	}
	
	private void solveMaze() {
		System.out.println("=== Solve Maze ===");
		if(maze.solve()) {
			System.out.println("[ Solusi Perjalanan ]");
			System.out.println(maze.getDirection());
			System.out.println("[ Matrix Perjalanan ]");
			maze.printSolution();
			System.out.println("[ Kalimat Yang Dibentuk ]");
			String word = buildWord(maze.getPath());
			System.out.println(word);
			System.out.println("[ Code ]");
			System.out.println(generateCode(word));			
		} else {
			System.out.println("Tidak ada solusi untuk map ini");
		}
	}
	
	private String buildWord(int[] path) {
		StringBuilder builder = new StringBuilder();
		
		for(int i = 0; i < path.length; i += 2) {
			builder.append(text[path[i + 1]][path[i]] +" ");
		}
		return builder.toString();
	}
	
	public String generateCode(String str) {
		StringBuilder builder = new StringBuilder();
		HuffmanTree tree = huffman.buildTree(str.replaceAll("\\s", ""));
		Map<Character, String> map = huffman.mappingCodes(tree);
		for(char c : str.toCharArray()) {
			String code = map.get(c);
			if(code != null)
				builder.append(code +" ");
			
		}
		return builder.toString();
	}
	
}
