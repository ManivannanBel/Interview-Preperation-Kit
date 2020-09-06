package interview.preperation.kit.linkedlist;

public class SinglyLinkedList {
	private SLLNode head, end;
	
	public SLLNode getHead() {
		return head;
	}

	public void setHead(SLLNode head) {
		this.head = head;
	}

	public SLLNode getEnd() {
		return end;
	}

	public void setEnd(SLLNode end) {
		this.end = end;
	}

	public SinglyLinkedList(int[] arr) {
		for(int a : arr) {
			insertLast(a);
		}
	}
	
	public void insertLast(int data) {
		if(head == null) {
			head = new SLLNode(data);
			end = head;
		}else {
			end.setNext(new SLLNode(data));
			end = end.getNext();
		}
	}
	
	public void insertFirst(int data) {
		if(head == null) {
			head = new SLLNode(data);
			end = head;
		}else {
			SLLNode newNode = new SLLNode(data);
			newNode.setNext(head);
			head = newNode;
		}
	}
	
	public void print() {
		System.out.print("[ ");
		SLLNode p = head;
		while(p != null) {
			System.out.print(p.getData()+" -> ");
			p = p.getNext();
		}
		System.out.println("null ]");
	}
}
