package interview.preperation.kit.linkedlist;

public class SLLNode {
	private int data;
	private SLLNode next;
	public  SLLNode(int data) {
		this.data = data;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public SLLNode getNext() {
		return next;
	}
	public void setNext(SLLNode next) {
		this.next = next;
	}
	public static void print(SLLNode head) {
		System.out.print("[ ");
		SLLNode p = head;
		while(p != null) {
			System.out.print(p.getData()+" -> ");
			p = p.getNext();
		}
		System.out.println("null ]");
	}
}
