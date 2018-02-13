package com.algorithms.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;
import java.io.File;

public class Maze {
	private char[][] maze;
	private char[][] _maze;
	private int startrow, startcol;
	private ArrayList<String> buffer;
	private Stack<Integer> path;
	private Stack<String> direction;
	private static Scanner file;
	
	public Maze(String fileName) {
		path = new Stack<>();
		direction = new Stack<>();
		initializeMaze(fileName);
	}
	
	public char[][] getMaze() {
		return maze;
	}
	
	public int[] getPath() {
		Collections.reverse(path);
		return path.stream().mapToInt(Integer::intValue).toArray();
	}
	
	public String getDirection() {
		Collections.reverse(direction);
		return direction.toString();
	}
	
	private void initializeMaze(String fileName) {
		startrow = startcol = -1;
		buffer = new ArrayList<String>();
		int numcols = 0;
		try {
			file = new Scanner(new File(fileName));
			while (file.hasNext()) {
				String nextLine = file.nextLine();
				buffer.add(nextLine);
				if (nextLine.length() > numcols)
					numcols = nextLine.length();
			}
		} catch (Exception e) {
			System.out.println(fileName + " can't be loaded!");
		} finally {
			file.close();
		}
		int numrows = buffer.size();
		maze = new char[numrows][numcols];
		for (int r = 0; r < numrows; r++) {
			String row = buffer.get(r);
			for (int c = 0; c < numcols; c++) {
				if (row.length() >= c)
					maze[r][c] = row.charAt(c);
				else
					maze[r][c] = '0';

				if (maze[r][c] == 'S') {
					startrow = r;
					startcol = c;
				}
			}
		}
	}

	public void printMaze() {
		for (char[] row : maze) {
			for (char col : row)
				System.out.print(col);
			System.out.println();
		}
		System.out.println();

	}
	
	public void printSolution() {
		for (char[] row : _maze) {
			for (char c : row)
				System.out.print(c);
			System.out.println();
		}
		System.out.println(
				  "(Keterangan)\n"
				+ "X: Jalan yg diambil\n"
				+ "A: Breadcrumb");

	}
	
	private void goBack() {
		if(!path.isEmpty()) {
			direction.pop();
			path.pop();
			path.pop();
		}
	}
	
	private void addTrack(String dir, Integer row, Integer col) {
		direction.push(dir);
		path.push(row);
		path.push(col);
	}
	
	private void setupSolution() {
		_maze = new char[maze.length][]; 
		for(int i = 0; i < maze.length; i++) {
			_maze[i] = maze[i].clone();
		}
	}
	
	public boolean solve() {
		setupSolution();
		path.clear();
		boolean isSolved = solve(startrow, startcol);
		direction.push("START");
		return isSolved;
	}
	
	private boolean solve(int row, int col) {
		/*check for boundaries*/
		if(row < 0 || col < 0 || row >= _maze.length || col >= _maze[0].length) {
			goBack();
			return false;
		}
		/*Base Case - Did I reach the finish*/
		if(_maze[row][col] == 'F') {
			addTrack("FINISH", row, col);
			return true;
		}
		/*Check if i'm at a valid point*/
		if(_maze[row][col] != '1' && _maze[row][col] != 'S') {
			/*I've hit the wall, back track*/
			goBack();
			return false;
		}
		/*I must be on a path, may be the right path*/
		_maze[row][col] = 'A';
		/*Check Below*/
		if(solve(row + 1, col)) {
			addTrack("DOWN", row, col);
			_maze[row][col] = 'X';
			return true;
		}
		/*Check Right*/
		if(solve(row, col + 1)) {
			addTrack("RIGHT", row, col);
			_maze[row][col] = 'X';
			return true;
		}
		/*Check Above*/
		if(solve(row - 1, col)) {
			addTrack("UP", row, col);
			_maze[row][col] = 'X';
			return true;
		}
		/*Check Left*/
		if(solve(row, col - 1)) {
			addTrack("LEFT", row, col);
			_maze[row][col] = 'X';
			return true;
		}
		return false;
	}
}