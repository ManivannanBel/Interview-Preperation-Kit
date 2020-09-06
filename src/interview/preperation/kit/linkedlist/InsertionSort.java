package interview.preperation.kit.linkedlist;

public class InsertionSort {
	public static void main(String[] args) {
		int[] arr = {5,7,2,8,4,1,3};
		SinglyLinkedList list = new SinglyLinkedList(arr);
		list.print();
		SLLNode resultNode = insertionSort(list.getHead());
		SLLNode.print(resultNode);
	}
	
	public static SLLNode insertionSort(SLLNode head) {
		SLLNode outerNode = head, innerNode;
		
		while(outerNode != null && outerNode.getNext() != null) {
			innerNode = outerNode.getNext();
			if(outerNode.getData() > innerNode.getData()) {
				SLLNode currentNode = innerNode;
				outerNode.setNext(innerNode.getNext());
				
				SLLNode compNode = head, prevNode = null;
				while(currentNode.getData() > compNode.getData()) {
					prevNode = compNode;
					compNode = compNode.getNext();
				}
				if(prevNode == null) {
					currentNode.setNext(head);
					head = currentNode;
				}else {
					currentNode.setNext(prevNode.getNext());
					prevNode.setNext(currentNode);
				}
			}else {
				outerNode = outerNode.getNext();
			}
		}
		
		return head;
	}
}
