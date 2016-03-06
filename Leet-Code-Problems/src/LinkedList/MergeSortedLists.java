package LinkedList;

public class MergeSortedLists {

	public ListNode<Integer> mergeLists(ListNode<Integer> node1, ListNode<Integer> node2){
		
		ListNode<Integer> currentNode = new ListNode<Integer>(0,null);
		ListNode<Integer> dummyHead = currentNode; // to save the first Node
		ListNode<Integer> p1 = node1;
		ListNode<Integer> p2 = node2;
		
		while(p1 != null && p2 != null){
			
			if(p1.data <= p2.data){
				currentNode.next = p1;
				p1= p1.next;
			} else {
				currentNode.next = p2;
				p2 = p2.next;
			}
			currentNode = currentNode.next;
		}
		
		//append remaining nodes
		currentNode.next = p1 != null ? p1 : p2;
		
		return dummyHead.next;
	}
	
	public static void main(String[] args) {

		ListNode<Integer> node1 = new ListNode<Integer>(8,null);
		ListNode<Integer> node2 = new ListNode<Integer>(4,node1);
		ListNode<Integer> node3 = new ListNode<Integer>(1,node2);
		
		ListNode<Integer> node4 = new ListNode<Integer>(6,null);
		ListNode<Integer> node5 = new ListNode<Integer>(3,node4);
		ListNode<Integer> node6 = new ListNode<Integer>(2,node5);
		
		MergeSortedLists msl = new MergeSortedLists();
		ListNode<Integer> p = msl.mergeLists(node3, node6);
		
		while(p != null){
			System.out.print(p.data + "->");
			p = p.next;
		}
	}
}
