package LinkedList;
import java.util.LinkedList;
import java.util.List;

public class MergeKSortedLists {

	// Time : O(nk log k), Space:O(1)
	public ListNode<Integer> mergeLists(List<ListNode<Integer>> lists) {
		int end = lists.size() - 1;
		while (end > 0) {
			int begin = 0;
			while (begin < end) {
				lists.set(begin, merge2Lists(lists.get(begin), lists.get(end)));
				begin++;
				end--;
			}
		}
		return lists.get(0);
	}

	public ListNode<Integer> merge2Lists(ListNode<Integer> head1,
			ListNode<Integer> head2) {

		ListNode<Integer> currentNode = new ListNode<Integer>(0, null);
		ListNode<Integer> dummyHead = currentNode; // to save the head of the
													// sorted list

		ListNode<Integer> p1 = head1;
		ListNode<Integer> p2 = head2;

		while (p1 != null && p2 != null) {

			if (p1.data <= p2.data) {

				currentNode.next = p1;
				p1 = p1.next;
			} else {

				currentNode.next = p2;
				p2 = p2.next;
			}

			currentNode = currentNode.next;
		}
		// append remaining nodes
		currentNode.next = p1 != null ? p1 : p2;

		return dummyHead.next;
	}
	
	public void printNodes(ListNode<Integer> p){
		while(p != null){
			System.out.print(p.data + "->");
			p = p.next;
		}
	}

	public static void main(String[] args) {

		ListNode<Integer> node1 = new ListNode<Integer>(8, null);
		ListNode<Integer> node2 = new ListNode<Integer>(4, node1);
		ListNode<Integer> node3 = new ListNode<Integer>(6, null);

		ListNode<Integer> node4 = new ListNode<Integer>(1, node3);
		ListNode<Integer> node5 = new ListNode<Integer>(3, null);
		ListNode<Integer> node6 = new ListNode<Integer>(2, node5);

		MergeKSortedLists msl = new MergeKSortedLists();
		List<ListNode<Integer>> lists = new LinkedList<ListNode<Integer>>();
		lists.add(node2);
		lists.add(node4);
		lists.add(node6);
		ListNode<Integer> p = msl.mergeLists(lists);

		while (p != null) {
			System.out.print(p.data + "->");
			p = p.next;
		}
	}

}
