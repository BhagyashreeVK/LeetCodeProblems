package LinkedList;

public class SwapNodes {

	public ListNode<Integer> swapNodes(ListNode<Integer> head){
		
		if(head == null || head.next == null){
			return head;
		}
		
		ListNode<Integer> p = head;
		ListNode<Integer> dummyHead = new ListNode<Integer>(0,p); //save head to return first node
		ListNode<Integer> previous = dummyHead;
		
		while(p != null && p.next != null){
			ListNode<Integer> q = p.next, r = p.next.next;
			previous.next = q;
			q.next = p;
			p.next = r;
			previous = p;
			p = r;
		}
		return dummyHead.next;
	}
	
	
	public void printNodes(ListNode<Integer> p){
		while(p != null){
			System.out.print(p.data + "->");
			p = p.next;
		}
	}
	public static void main(String[] args) {
		ListNode<Integer> node0 = new ListNode<Integer>(5,null);
		ListNode<Integer> node1 = new ListNode<Integer>(4,node0);
		ListNode<Integer> node2 = new ListNode<Integer>(3,node1);
		ListNode<Integer> node3 = new ListNode<Integer>(2,node2);
		ListNode<Integer> node4 = new ListNode<Integer>(1,node3);

		SwapNodes sn = new SwapNodes();
		sn.printNodes(node4);
		System.out.println("\n =========");
		ListNode<Integer> p = sn.swapNodes(node4);
		sn.printNodes(p);
	}

}
