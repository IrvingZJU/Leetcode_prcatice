package Hot100.linkedlist;
//给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
//请你将两个数相加，并以相同形式返回一个表示和的链表。你可以假设除了数字 0 之外，这两个数都不会以 0开头。
public class No2_AddTwoNum {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(-1),pre=dummy;
        //将l1链表复制给dummy链表
        while (l1!=null){
            pre.next=new ListNode(l1.val);
            pre=pre.next;
            l1=l1.next;
        }
        pre=dummy;
        //将l2各节点的值加到dummy链表各节点中
        while (l2!=null){
            if (pre.next!=null) {
                pre.next.val = pre.next.val + l2.val;
            }else {
                pre.next=new ListNode(l2.val);
            }
            pre=pre.next;
            l2=l2.next;
        }
        //遍历dummy链表，若有val>9的节点就将后一节点+1，同时自身-10
        pre=dummy.next;
        while (pre!=null){
            if (pre.val>9 && pre.next!=null){
                pre.next.val++;
                pre.val-=10;
            }
            if (pre.val>9 && pre.next==null){
                pre.next=new ListNode(1);
                pre.val-=10;
            }
            pre=pre.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode a1=new ListNode(9);
        ListNode a2=new ListNode(9);
        ListNode a3=new ListNode(9);
        ListNode a4=new ListNode(9);
        ListNode a5=new ListNode(9);
        ListNode a6=new ListNode(9);
        a1.next=a2;
        a3.next=a4;
        a4.next=a5;
        a5.next=a6;
        ListNode res=addTwoNumbers(a1,a3);
        while (res!=null){
            System.out.println(res);
            res=res.next;
        }
    }
}
