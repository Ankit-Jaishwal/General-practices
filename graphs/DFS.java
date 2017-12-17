package com.ankit.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.ankit.graphs.GraphVertex.Inner;

public class DFS {

	/**
	 * @param args
	 */
	static public void main(String[] args) {
		// TODO Auto-generated method stub
		BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();
		Inner name = new GraphVertex(0).new Inner();

		DFS dfs = new DFS();
		GraphVertex sv = dfs.buildGraph();
//		dfs.dfsTraversalIterative(sv);
		
		dfs.dfsTraversalRecursive(sv);

	}

	void dfsTraversalIterative(GraphVertex sv) {

		Stack<GraphVertex> stack = new Stack<GraphVertex>();
		sv.isVisited = true;
		stack.push(sv);

		while (!stack.empty()) {
			GraphVertex topVertex = stack.pop();
			topVertex.isVisited = true;
			System.out.println(topVertex.key);
			// Put all unvisited adj node of the current vertex sv
			for (GraphVertex gv : topVertex.adjList) {
				if (!gv.isVisited) {
					stack.push(gv);
				}
			}
		}

	}
	
	void dfsTraversalRecursive(GraphVertex sv) {
		sv.isVisited = true;
		System.out.println(sv.key);
		// Put all unvisited adj node of the current vertex sv
		for (GraphVertex gv : sv.adjList) {
			if (!gv.isVisited) {
				dfsTraversalRecursive(gv);
			}
		}
	}

	GraphVertex buildGraph() {

		// Create some vertex
		GraphVertex v1 = new GraphVertex(5);
		GraphVertex v2 = new GraphVertex(2);
		GraphVertex v3 = new GraphVertex(4);
		GraphVertex v4 = new GraphVertex(7);

		// Create edge or adjacency list
		v1.addEdge(v2);
		v1.addEdge(v4);

		v2.addEdge(v4);

		v3.addEdge(v1);

		v4.addEdge(v3);

		return v1;
	}
}

class GraphVertex {
	int key;
	List<GraphVertex> adjList = new ArrayList<GraphVertex>();
	boolean isVisited;

	GraphVertex(int key) {
		this.key = key;
	}

	void addEdge(GraphVertex v) {
		adjList.add(v);
	}

	class Inner {
		int x;
	}
}
