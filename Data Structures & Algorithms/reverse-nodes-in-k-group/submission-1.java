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
    public ListNode reverseKGroup(ListNode head, int k) {
        List<ListNode> nodes = new ArrayList<>();

        while (head != null) {
            nodes.add(head);
            head = head.next;
        }

        List<ListNode> revers= new ArrayList<>();
        int i = 0;
        for (i = k - 1; i < nodes.size(); i+=k) {
            for (int j = i; j > i-k; j--) {
                revers.add(nodes.get(j));
            }
            if (i + k > nodes.size() - 1) {
                break;
            }
        }
        if (i != nodes.size() - 1) {
            for (int j = i + 1; j < nodes.size(); j++) {
                revers.add(nodes.get(j));
            }
        }
        // revers.forEach(node -> System.out.println(node.val));
        ListNode tmp = new ListNode();
        head = tmp;
        for (int l =0; l<revers.size(); l++) {
            tmp.next = revers.get(l);
            tmp = tmp.next;
        }
        tmp.next = null;
        return head.next;
    }

    
}
