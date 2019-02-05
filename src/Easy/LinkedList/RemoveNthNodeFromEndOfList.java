class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode headNode = new ListNode(1000);
        headNode.next = head;
        
        ListNode fastNode = headNode;
        ListNode slowNode = headNode;
                
        while(n > 0) {
            fastNode = fastNode.next;
            n--;
        }
        
        while(fastNode.next != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        
        slowNode.next = slowNode.next.next;
        return headNode.next;
    }
}