class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to simplify handling of edge cases
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        // Traverse both lists and merge them
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next; // Move the pointer in list1
            } else {
                current.next = list2;
                list2 = list2.next; // Move the pointer in list2
            }
            current = current.next; // Move the current pointer in the merged list
        }
        
        // If one of the lists is not exhausted, append the remainder of the other list
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }
        
        // Return the next node after the dummy, which is the head of the merged list
        return dummy.next;
    }
}
