import java.util.*;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // Priority queue (min-heap) to store the nodes
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> a.val - b.val  // Compare nodes based on their value
        );
        
        // Initialize the heap with the first node of each list
        for (ListNode list : lists) {
            if (list != null) {
                pq.offer(list);
            }
        }
        
        // Dummy node to simplify result construction
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        // Extract nodes from the heap and build the merged list
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();  // Get the smallest node
            current.next = node;        // Add it to the merged list
            current = current.next;     // Move to the next node
            
            // If there is a next node in the current list, add it to the heap
            if (node.next != null) {
                pq.offer(node.next);
            }
        }
        
        return dummy.next;  // Return the merged list (excluding the dummy node)
    }
}
