public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Create a dummy node to simplify the logic
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prevGroupEnd = dummy; // Pointer to the end of the previous group
        
        while (head != null) {
            ListNode groupStart = head;
            ListNode groupEnd = head;
            
            // Check if there are k nodes left to reverse
            for (int i = 1; i < k && groupEnd != null; i++) {
                groupEnd = groupEnd.next;
            }
            
            // If there are less than k nodes left, no reversal, just return
            if (groupEnd == null) break;
            
            // Save the node after the end of the group
            ListNode nextGroupStart = groupEnd.next;
            
            // Reverse the group
            ListNode prev = null;
            ListNode current = groupStart;
            while (current != nextGroupStart) {
                ListNode nextNode = current.next;
                current.next = prev;
                prev = current;
                current = nextNode;
            }
            
            // Connect the reversed group with the previous part
            prevGroupEnd.next = prev;
            groupStart.next = nextGroupStart;
            
            // Move prevGroupEnd to the end of the reversed group
            prevGroupEnd = groupStart;
            
            // Move head to the start of the next group
            head = nextGroupStart;
        }
        
        return dummy.next;
    }
}
