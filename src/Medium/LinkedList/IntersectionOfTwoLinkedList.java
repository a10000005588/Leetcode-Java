//  160  Intersection of Two Linked Lists

// my solution... 
// reference : https://leetcode.com/explore/interview/card/top-interview-questions-medium/107/linked-list/785/discuss/49785/Java-solution-without-knowing-the-difference-in-len!
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        
        ListNode a = headA;
        ListNode b = headB;
        
        boolean x = false;
        boolean y = false;
        while(a != b) {
            a = a.next; 
            b = b.next; 
            if(((a == null) && x) || (b == null) && y) break;

            if(a == null) {
                a = headB;
                x = true;
            }
          
            if(b == null){
                b = headA;
                y = true;
            }
            
        }
        
        return a;
    }
}

// other

public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //boundary check
    if(headA == null || headB == null) return null;
    
    ListNode a = headA;
    ListNode b = headB;
    
    //if a & b have different len, then we will stop the loop after second iteration
    while( a != b){
    	//for the end of first iteration, we just reset the pointer to the head of another linkedlist
        a = a == null? headB : a.next;
        b = b == null? headA : b.next;    
    }
    
    return a;
}