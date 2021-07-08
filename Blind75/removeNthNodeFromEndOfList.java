/**************************************************************

2 Pass Algorithm:
	1. Count the size of ListNode.
	2. Get the index of the node to be removed

	Alternatively,

	2(a) reduce the size of the ListNode while counting again
	2(b) when size == 0 you have reached the node to be removed.

	3. Remove the node

***************************************************************

1 Pass Algorithm:
	1. Create two pointers. slow and fast.
	2. Give fast pointer a head start of n which is the
	count of the node from end of the listNode.
	3. iterate till the end of listnode with a gap between
	slow and fast == n.
	4. Since the gap between slow and fast is n and fast.next == null
	slow.next is the element to be removed.

Time Complexity: O(N) where N is total nodes


*************************************************************/

class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode fast = dummy;
		ListNode slow = dummy;

		// give fast pointer a head start of n nodes.
		for (int i = 0; i < n; i++) {
			fast = fast.next;
		}

		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}

		slow.next = slow.next.next;

		return dummy.next;
	}
}
