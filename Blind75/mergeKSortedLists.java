/*********************************************************

The basic idea behind the solution is to utilize priority queue's ability to sort values.

Naive Approach

	1. Add all node values to the PQ.
	2. Build a ListNode out of PQ values.

Time Complexity: O(N*logN)
Space Complexity: O(N)

where N is the total number of nodes in the ListNode[] lists

************************************************************/

// class Solution {
//     public ListNode mergeKLists (ListNode[] lists) {
// 		PriorityQueue<Integer> pq = new PriorityQueue<>();
// 		ListNode dummy = new ListNode(0);
// 		ListNode nodePtr = dummy;
//
// 		//build a PQ out of ListNode values
// 		for (ListNode listA : lists) {
// 			ListNode ptr = listA;
// 			while (ptr != null) {
// 				pq.add(ptr.val);
// 				listA = listA.next;
// 				ptr = listA;
// 			}
// 		}
//
// 		//build a ListNode from PQ
//         while (pq.size() != 0) {
//             dummy.next = new ListNode(pq.remove());
//             dummy = dummy.next;
//         }
//
// 		return nodePtr.next;
// 	}
// }

/************************************************************
Optimized Approach

In the optimized solution, we take advantage of the fact that each ListNode in ListNode[] arr is sorted as follows:

Only pass the head of each list to the PQ.
While removing, add the next value from the node with removed item to PQ.
Time Complexity: O(log(m) * N)
Space Complexity: O(N)

where N is the total number of nodes in the ListNode[] lists and
m is the length of ListNode[] lists

Quick Example WalkThrough

For the example[[3,4,5],[1,3,4],[2,6]] we only add 3, followed by 1, followed by 2 to the PQ at the start.

PQ by its nature turns the input into 1->2->3. After removing 1, add the next element from ListNode (1->3->4) to the PQ. Which is 3 in this case.

In this approach, PQ can keep sorting itself without making O(log(N)) comparisons.

**************************************************************/

class Solution {
    public ListNode mergeKLists (ListNode[] lists) {
        Comparator<ListNode> cmp = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode listA, ListNode listB) {
                return listA.val - listB.val;
            }
        };

		PriorityQueue<ListNode> pq = new PriorityQueue<>(cmp);
		ListNode dummy = new ListNode(0);
		ListNode nodePtr = dummy;

		// build a PQ of ListNode data type to get values sorted
		for (ListNode listA : lists) {
		    if (listA != null) {
                pq.add(listA);
            }
		}

        while (pq.size() != 0) {
            ListNode listA = pq.remove();
            dummy.next = listA;
            dummy = dummy.next;

            if (listA.next != null) {
                pq.add(listA.next);
            }
        }

		return nodePtr.next;
	}
}
