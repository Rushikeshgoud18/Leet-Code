public class Solution {
    public ListNode swapPairs(ListNode head) {
        // Create a dummy node to simplify handling the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // `current` is the pointer that we use to traverse the list
        ListNode current = dummy;
        
        // Traverse the list in pairs
        while (current.next != null && current.next.next != null) {
            // Identify the two nodes to swap
            ListNode first = current.next;
            ListNode second = current.next.next;
            
            // Perform the swap
            first.next = second.next;
            second.next = first;
            current.next = second;
            
            // Move `current` to the next pair
            current = first;
        }
        
        return dummy.next;  // Return the head of the modified list
    }
}
