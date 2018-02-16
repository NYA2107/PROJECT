package com.datastructures.disjointset;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DisjointSet {
	
	private int[] rank, parent;
	private int size;
	
	public DisjointSet(int size) {
		rank = new int[size];
		parent = new int[size];
		this.size = size;
		makeSet();
	}

	private void makeSet() {
		for (int i = 0; i < size; i++) {
			parent[i] = i;
			rank[i] = 0;
		}
	}

	
	public int find(int x) {
		if(x < 0 || x > size - 1)
			throw new ArrayIndexOutOfBoundsException();
		int res = x;
		if (parent[x] != x) {
			res = find(parent[x]);
		}
		return res;
	}
	
	
	public List<Integer> path(int x) {
		if(x < 0 || x > size - 1)
			throw new ArrayIndexOutOfBoundsException();
		List<Integer> path = new ArrayList<>();
		path(x, path);
		return path;
	}
	
	private void path(int x, List<Integer> path) {
		path.add(x);		
		if (parent[x] != x) {
			path(parent[x], path);
		}
	}

	public void union(int x, int y) {
		if(x < 0 || y < 0 || x > size - 1 || y > size - 1) {
			throw new ArrayIndexOutOfBoundsException();
		}
		int xRoot = find(x), yRoot = find(y);
		if (xRoot == yRoot) {
			System.out.println("Numbers are same or in one set");
			return;
		}
		parent[yRoot] = xRoot;
		rank[xRoot] = rank[yRoot] + 1;

	}
	
	public int[] getRank() {
		return this.rank;
	}
	
	public int[] getParent() {
		int[] parent = new int[size];
		for(int i = 0; i < size; i++)
			parent[i] = this.parent[i] == i ? -1 : this.parent[i];
		return parent;
	}
	
	public int[] getRoot() {
		List<Integer> roots = new LinkedList<>();
		for(int i = 0; i < size; i++) {
			if(this.parent[i] == i) {
				roots.add(i);
			}
		}
		return roots.stream().mapToInt(Integer::intValue).toArray();
	}
	
	public int size() {
		return this.size;
	}
}

