/**
 * @author Girdhari
 * This class will contain details related to Edges
 */

package socialnetwork;

import java.util.List;

public class Edge {
	private Node nextNode;
	
	
	public Edge()
	{
		nextNode = new Node(0); //default value of data in Node
		
	}
	
	public Node getNextNode() {
		return nextNode;
	}



	public void setNextNode(Node adjacentNode) {
		this.nextNode = adjacentNode;
	}

	public boolean addEdge(Graph graph, Node fromNode, Node toNode)
	{
			if(fromNode == null || toNode == null)
				return false;
			int isFromAvailable = searchNode(graph, fromNode);
			int isToAvailable = searchNode(graph, toNode);
			if(isFromAvailable == -1 || isToAvailable == -1)
				return false;
			
			Edge edgeFromToTo = new Edge();
			edgeFromToTo.nextNode = toNode;
			edgeFromToTo.nextNode.setData(toNode.getData());
			fromNode.getEdgeList().add(edgeFromToTo);
			Edge edgeToToFrom = new Edge();
			edgeToToFrom.nextNode = fromNode;
			edgeToToFrom.nextNode.setData(fromNode.getData());
			toNode.getEdgeList().add(edgeToToFrom);
			return true;
	}
	
	public boolean deleteEdge(Graph graph, Node fromNode,Node toNode)
	{
		int index;
		if(fromNode == null)
			return false;
		
		
	
		index=searchAdjacentNode(fromNode.getEdgeList(), toNode);
		fromNode.getEdgeList().remove(index);
		index=searchAdjacentNode(toNode.getEdgeList(), fromNode);
		toNode.getEdgeList().remove(index);
		return true;
	}
		
		
	public  int searchNode(Graph graph, Node node) 
	{
			int index = -1;
			for(int vertex = 0 ; vertex < graph.getAdajenceyList().size() ; vertex++)
			{
				
				if(node.equals(graph.getAdajenceyList().get(vertex)))
				{
					index = vertex;
					break;
				}
			}
			return index;
	}
	public int searchAdjacentNode(List<Edge> edgeList, Node node)
	{
		int index = -1;
		for(int adjacent = 0 ; adjacent < edgeList.size() ; adjacent++)
		{
			if(node.getData() == edgeList.get(adjacent).getNextNode().getData())
			{
				index = adjacent;
				break;
			}
		}
		return index;
	}
		
			

}

