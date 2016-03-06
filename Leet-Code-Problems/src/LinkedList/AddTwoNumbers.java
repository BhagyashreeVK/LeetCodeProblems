package LinkedList;

public class AddTwoNumbers {

	public ListNode<Integer> addNumbers(ListNode<Integer> num1, ListNode<Integer> num2){
		
		ListNode<Integer> current = new ListNode<Integer>(0,null);
		ListNode<Integer> dummyHead = current;
		ListNode<Integer> p1 = num1;
		ListNode<Integer> p2 = num2;
	
		int carry = 0;
		
		while( p1 != null || p2 != null){
			
			int val1 = p1 != null ? p1.data : 0;
			int val2 = p2 != null ? p2.data : 0;
			
			int sum = carry + val1 + val2;
			
			carry = sum /10;
			int digit = sum%10;
			
			current.next = new ListNode<Integer>(digit, null);
			current = current.next;
			
			if(p1 != null) 
				p1 = p1.next;
			
			if(p2 != null) 
				p2 = p2.next;
		}
		
		if(carry > 0){
			current.next = new ListNode<Integer>(carry,null);
		}
	
		return dummyHead.next;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
