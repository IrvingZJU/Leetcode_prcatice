package Hot100.linkedlist;
//141.给定链表的头节点，判定链表是否有环 142.给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
public class No141_142_CycleList {
    //快慢指针，快指针能赶上慢指针，就存在环。拓展：如何求环中的节点数呢？
    //从相遇点开始，再让快慢指针同时移动，再次相遇的点还是那个点。这个阶段只要count就行了。
    public static boolean hasCycle(ListNode head) {
        if (head==null || head.next==null)
            return false;
        ListNode slow=head;
        ListNode fast=head.next;
        while (fast!=null && fast.next!=null){
            if (fast==slow){
                return true;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        return false; //若循环根据判断条件结束，链表必无环
    }

    //根据上一题的思路，从相遇点开始，再让快慢指针走一圈，不过要从一开始统计slow移动的次数
    public static ListNode detectCycle(ListNode head) {
        if (head==null)
            return null;
        ListNode slow=head;
        ListNode fast=head;
        boolean flag=false;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (fast==slow){
                flag=true;
                break;
            }
        }
        if (flag){
            //此时快慢指针在环中的相遇点，然后让fast指针指向head，然后两指针同时以速度1开始移动，再次相遇时，两指针就位于环的入口。
            fast=head;
            while (fast!=slow){
                fast=fast.next;
                slow=slow.next;
            }
            return slow;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode a1=new ListNode(4);
        ListNode a2=new ListNode(2);
        ListNode a3=new ListNode(1);
        ListNode a4=new ListNode(3);
        ListNode a5=new ListNode(0);
        a1.next=a2;
        a2.next=a3;
        a3.next=a4;
        a4.next=a5;
        a5.next=a2;
        //141
        System.out.println(hasCycle(a1));
        //142
        ListNode cur=detectCycle(a1);
        System.out.println(cur);
    }
}
