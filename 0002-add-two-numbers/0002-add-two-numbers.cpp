/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        // Dummy node to simplify code
        ListNode *dummy = new ListNode(0);
        ListNode *current = dummy; // Points to the current node in the result list
        int carry = 0;

        // Traverse both lists
        while (l1 != nullptr || l2 != nullptr || carry != 0) {
            int sum = carry;
            if (l1 != nullptr) {
                sum += l1->val; // Add the value from the first list
                l1 = l1->next;  // Move to the next node in l1
            }
            if (l2 != nullptr) {
                sum += l2->val; // Add the value from the second list
                l2 = l2->next;  // Move to the next node in l2
            }

            // Update carry for the next iteration
            carry = sum / 10;
            // Create a new node for the current sum's digit
            current->next = new ListNode(sum % 10);
            current = current->next; // Move to the next node in the result list
        }

        // Return the result list, skipping the dummy node
        return dummy->next;
    }
};
