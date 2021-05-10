package Hot100.linkedlist;
//合并两个有序链表
public class No21_MergeTwoSortedLists {
    //解法一：链表1保持不动，将链表2的节点依次按序加入到链表1中
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(0);
        ListNode temp1=head;
        temp1.next=l1;
        ListNode temp2=l2;
        ListNode next=null;
        while (temp2!=null){
            next=temp2.next;
            while (true) {
                if (temp1.next == null || temp2.val < temp1.next.val) {
                    temp2.next=temp1.next;
                    temp1.next=temp2;
                    break;
                }
                temp1=temp1.next;
            }
            temp2=next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode a1=new ListNode(1);
        ListNode a2=new ListNode(2);
        ListNode a3=new ListNode(4);
        ListNode b1=new ListNode(1);
        ListNode b2=new ListNode(3);
        ListNode b3=new ListNode(4);
        a1.next=a2;
        a2.next=a3;
        b1.next=b2;
        b2.next=b3;
        ListNode l=mergeTwoLists(a1,b1);
        //遍历打印
        ListNode cur=l;
        while (cur!=null){
            System.out.print(cur+" ");
            cur=cur.next;
        }
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}