package Hot100.linkedlist;
//编写一个程序，找到两个单链表相交的起始节点（交叉点）。
public class No160_IntersectionOfTwoLinkedList {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //暴力法
//        ListNode tempA=headA;
//        ListNode tempB=headB;
//        while (tempA!=null){
//            tempB=headB;
//            while (tempB!=null){
//                if (tempA==tempB){
//                    return tempA;
//                }
//                tempB=tempB.next;
//            }
//            tempA=tempA.next;
//        }
//        return null;

        //双指针法
        if (headA == null || headB == null) {
            return null;
        }
        ListNode tempA=headA;
        ListNode tempB=headB;
        while (tempA!=tempB){
            if (tempA==null)
                tempA=headB;
            else tempA=tempA.next;
            if (tempB==null)
                tempB=headA;
            else tempB=tempB.next;
        }
        return tempA;
    }

    public static void main(String[] args) {
        ListNode a1=new ListNode(1);
        ListNode a2=new ListNode(2);
        ListNode a3=new ListNode(3);
        ListNode a4=new ListNode(4);
        ListNode a5=new ListNode(5);
        ListNode a6=new ListNode(6);
        ListNode a7=new ListNode(7);
        ListNode a8=new ListNode(8);
        ListNode a9=new ListNode(9);
        a1.next=a3;
        a3.next=a5;
        a5.next=a7;
        a7.next=a8;
        a8.next=a9;
        a2.next=a4;
        a4.next=a6;
        a6.next=a7;

        ListNode res=getIntersectionNode(a1,a2);
        System.out.println(res);
    }
}
