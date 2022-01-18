/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null) return;
        
        ListNode lastNode = head;
        ListNode frontPtr = head;
        Stack<ListNode> orderStack = new Stack<>(); 
       
        while (lastNode != null) {
            orderStack.push(lastNode);
            lastNode = lastNode.next;
        }
        
        while (!orderStack.isEmpty() && frontPtr != null) {
            orderStack.peek().next = null;
            
            ListNode tempRef = frontPtr.next;
            ListNode backPtr = orderStack.pop();
            
            // break out of the cycle when frontPtr approaches backPtr
            if (backPtr == frontPtr.next) return;
            
            frontPtr.next = backPtr;
            backPtr.next = tempRef;
            frontPtr = backPtr.next;
        }
    }
}