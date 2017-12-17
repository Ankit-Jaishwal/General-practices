package com.ankit.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BreadthFirstSearch {
	/**
	 * We assume our graph is like below and is directed
	 * [A]----[P]----[R]
		  \    |	  |
		   \   |	  |
		    \  |   	  |
			 -[Q]----[B]
			 
		We need to use BFS to know whether Node[A] and Node[B] are connected or Not
	 */

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Graph Node B
		GraphNode graphNodeB = new GraphNode(new ArrayList<GraphNode>(), "B");
		
		// Adjacent Nodes List
		List<GraphNode> adjNodeList = null;
		adjNodeList = new ArrayList<GraphNode>();
		adjNodeList.add(graphNodeB);
		
		// graphNodeB is Adjacent to GraphNode [R] and [Q], hence creating graphNodes R and Q and adding adjNodeList to them
		GraphNode graphNodeR = new GraphNode(adjNodeList, "R");
		GraphNode graphNodeQ = new GraphNode(adjNodeList, "Q");
		
		// For Node [P]
		adjNodeList = new ArrayList<GraphNode>();
		adjNodeList.add(graphNodeQ);
		adjNodeList.add(graphNodeR);
		GraphNode graphNodeP = new GraphNode(adjNodeList, "P");
		
		// For Node [A]
		adjNodeList = new ArrayList<GraphNode>();
		adjNodeList.add(graphNodeP);
		adjNodeList.add(graphNodeQ);
		GraphNode graphNodeA = new GraphNode(adjNodeList, "A");
		
		// Here we make our graph
		List<GraphNode> nodes = new ArrayList<GraphNode>();
		nodes.add(graphNodeA);
		nodes.add(graphNodeP);
		nodes.add(graphNodeQ);
		nodes.add(graphNodeR);
		nodes.add(graphNodeB);
		Graph graph = new Graph(nodes);
		boolean isConnected = checkPath(graph, graphNodeA, graphNodeB);
		System.out.println("Node [A] and Node [B] is connected : "+isConnected);

	}

	public static boolean checkPath(Graph graph, GraphNode start,
			GraphNode end) {
		LinkedList<GraphNode> nodesQ = new LinkedList<GraphNode>();
		//Step 1 : Add the start node to the Queue and mark its State as visiting.
		start.setState(State.VISITING);
		nodesQ.add(start);
		GraphNode node = null;
		//Step 2 : Iterate the Queue till it is empty, and check if we find the end node thru the adjacent nodes
		while(!nodesQ.isEmpty()){
			node = nodesQ.removeFirst();
			System.out.println(node.toString());
			for (GraphNode adjNode : node.getAdjNodes()) {
				if (adjNode.getState().equals(State.UNVISITED)) { // Proceed further if and only if the node is not yet visited
					if (adjNode.getKey().equals(end.getKey())) {
						System.out.println(adjNode.toString());
						return true;
					} else {
						adjNode.setState(State.VISITING);
						nodesQ.add(adjNode);
					}
				}
			}
			node.setState(State.VISITED);
			System.out.println(node.toString());
		}
		
		return false;
	}
	
}

enum State {
	UNVISITED, VISITING, VISITED;
}

class Graph {
	private List<GraphNode> nodes = new ArrayList<GraphNode>();

	public Graph(List<GraphNode> nodes) {
		super();
		this.nodes = nodes;
	}
	public List<GraphNode> getNodes() {
		return nodes;
	}
	public void setNodes(List<GraphNode> nodes) {
		this.nodes = nodes;
	}
	
}


class GraphNode {
	private List<GraphNode> adjNodes = new ArrayList<GraphNode>();
	private String key;
	private State state = State.UNVISITED;
	public GraphNode(List<GraphNode> adjNodes, String key) {
		super();
		this.adjNodes = adjNodes;
		this.key = key;
	}
	public List<GraphNode> getAdjNodes() {
		return adjNodes;
	}
	public void setAdjNodes(List<GraphNode> adjNodes) {
		this.adjNodes = adjNodes;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public State getState() {
		return state;
	}
	
	public void setState(State state) {
		this.state = state;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.key+","+this.state;
	}
}
