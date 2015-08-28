/**
 * @author Girdhari
 * Program to implement Doubly link list
 * This class will perform all the operation related to Doubly Link List
 */
package question4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DoublyLinkedListOperation {
	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
			System.in));

	/* Start of createList function */
	public DoublyNode createList() {
		int data;
		String choice = null;
		DoublyNode current = null;
		DoublyNode start = null;
		DoublyNode newNode = null;
		
		do {
			System.out.print("Enter value of node");
			data = readData();
			newNode = new DoublyNode(data);
			if (isEmpty(start)) {
				start = newNode;
				current = start;
			} else {
				current.setNextNode(newNode);
				newNode.setPreviousNode(current);
				current = newNode;
			}
			System.out.print("Do you want to add more nodes:(Y/N) ");
			try {
				choice = bufferedReader.readLine();
			} catch (IOException io) {
				System.out.println("Error occured please enter input again");
			}

		} while (choice.equalsIgnoreCase("y"));

		return start;
	}
	/* End of createList function */

	/* Start of readData function */
	public static int readData() {
		int data = 0;
		boolean isCorrect = false;
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(System.in));
		do {
			try {
				data = Integer.parseInt(bufferedReader.readLine());
			} catch (NumberFormatException nf) {
				System.out.println("Please enter no like 1 2 ..");
				continue;
			} catch (IOException io) {
				System.out.println("Error Occured please enter again");
				continue;
			}
			isCorrect = true;

		} while (!isCorrect);
		return data;
	}
	/* End of readData function */

	public static boolean isEmpty(DoublyNode node) {
		return node == null;
	}
	
	/* Start of sortList function */
	public void sortList(DoublyNode start) {
			DoublyNode previous, current, temp;
			previous = start;
			current = null;
			temp = start;
			while( previous.getNextNode() != null) {
				temp = start;
				while( temp.getNextNode() != previous) {
					if(temp.getData() > temp.getNextNode().getData()) {
						temp.setData(temp.getData() + temp.getNextNode().getData());
						temp.getNextNode().setData(temp.getData() - temp.getNextNode().getData());
						temp.setData(temp.getData() - temp.getNextNode().getData());
					}
					temp = temp.getNextNode();
				}
				current = temp;
				previous = previous.getNextNode();
			}
		}
	/* End of sortList function */
		
	/* Start of displayList function */
	void displayList(DoublyNode start) {
		if (isEmpty(start)) {
			System.out.println("List is empty");
			return;
		}
		while (start != null) {
			System.out.print(start.getData() + " ");
			start = start.getNextNode();
		}
		System.out.println("\nNo of nodes is " + DoublyNode.getNoOfNodes());
	}
	/* End of displayList function */
	
	/* Start of insertAtPosition function */
	public DoublyNode insertAtPosition(DoublyNode startNode, int position) {
		int counter = 2;
		int data;
		if (position <= 0 && position > DoublyNode.getNoOfNodes() + 1
				|| isEmpty(startNode))
			return null;
		System.out.println("Enter data to be insert");
		data = readData();
		DoublyNode newNode = new DoublyNode(data);
		DoublyNode head = startNode;
		if (position == 1) {
			newNode.setNextNode(startNode);
			startNode.setPreviousNode(newNode);
			startNode = newNode;
			return startNode;
		}
		while (counter != position) {
			head = head.getNextNode();
			counter++;
		}
		newNode.setPreviousNode(head);
		newNode.setNextNode(head.getNextNode());
		if (!DoublyLinkedListOperation.isEmpty(head.getNextNode())) // if no is to insert
															// in between in the
															// list
			head.getNextNode().setPreviousNode(newNode);
		head.setNextNode(newNode);// if the no is at last position
		return startNode;
	}
	/* End of insertAtPosition function */
	/* Start of deleteNode function */
	public DoublyNode deleteNode(DoublyNode startNode) {
		if (DoublyLinkedListOperation.isEmpty(startNode))
			return null;
		System.out.println("Enter data to be deleted");
		int data = readData();
		if (startNode.getData() == data) {
			startNode = startNode.getNextNode();
			DoublyNode.setNoOfNodes(DoublyNode.getNoOfNodes() - 1);
			return startNode;
		}
		DoublyNode head = startNode;
		while (head != null && head.getData() != data) {
			head = head.getNextNode();
		}
		if (DoublyLinkedListOperation.isEmpty(head)) {
			System.out.println("data does not exist");

		} else {
			head.getPreviousNode().setNextNode(head.getNextNode());
			if (!DoublyLinkedListOperation.isEmpty(head.getNextNode()))
				head.getNextNode().setPreviousNode(head.getPreviousNode());
			DoublyNode.setNoOfNodes(DoublyNode.getNoOfNodes() - 1);
			return startNode;

		}
		return null;
	}
	/* End of deleteNode function */
	
	/* Start of deleteNodeByPosition function */
	public DoublyNode deleteNodeByPosition(DoublyNode startNode) {
		int counter = 1;
		if (DoublyLinkedListOperation.isEmpty(startNode))
			return null;

		System.out.println("Enter Position ");
		int index = readData();
		if (index <= 0 || index > DoublyNode.getNoOfNodes())
			return null;

		if (index == 1) {
			startNode = startNode.getNextNode();
			DoublyNode.setNoOfNodes(DoublyNode.getNoOfNodes() - 1);
			return startNode;
		}
		DoublyNode head = startNode;
		while (index != counter++ && head != null) {
			head = head.getNextNode();
		}
		if (DoublyLinkedListOperation.isEmpty(head)) {
			System.out.println("Data does not exist");

		} else {
			head.getPreviousNode().setNextNode(head.getNextNode());
			if (!DoublyLinkedListOperation.isEmpty(head.getNextNode()))
				head.getNextNode().setPreviousNode(head.getPreviousNode());
			DoublyNode.setNoOfNodes(DoublyNode.getNoOfNodes() - 1);
			return startNode;
		}
		return null;
	}
	/* End of deleteNodeByPosition function */

	/*Start of reverseList function */
	public DoublyNode reverseList(DoublyNode start) {
		if (start == null) {
			System.out.println("Empty List");
			return null;
		}
		DoublyNode current = start;
		DoublyNode temp = null;
		while (current != null) {
			temp = current.getPreviousNode();
			current.setPreviousNode(current.getNextNode());
			current.setNextNode(temp);
			current = current.getPreviousNode();
		}
		System.out.println("List is Reversed");
		return temp.getPreviousNode();

	}
	/* End of reverseList function */
}
