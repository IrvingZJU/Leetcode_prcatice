package Hot100.linkedlist;
//判断一个单链表是否为回文链表，时间O(n)，空间O(1)
public class No234_PalindromeList {
    //参考做法一：先用快慢指针找出链表中点，然后反转链表的后半段，再将一个节点置于中点一个节点置于开头，然后两个指针同时后移，判断val是否相等
    //但这样做改变了链表原有形式，最好执行该算法时锁定其他线程或进程对链表的访问，并在算法中判断完后恢复链表原形式
    public static boolean isPalindrome(ListNode head) {
        if (head==null)
            return false;
        if (head.next==null)
            return true;
        //找中点
        ListNode slow=head;
        ListNode fast=head.next;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //若链表有奇数个节点，此时slow位于中点；若链表有偶数个节点，此时slow位于中点的左边那个节点
        //反转链表后半段
        ListNode temp_head=new ListNode(-1);
        ListNode next=null;
        fast=slow.next;
        while (fast!=null){
            next=fast.next;
            fast.next=temp_head.next;
            temp_head.next=fast;
            fast=next;
        }
        slow.next=temp_head.next;
        temp_head.next=null;
        //将fast指向slow.next，将slow指向head，并同时同速后移并判断值是否相等
        fast=slow.next;
        slow=head;
        boolean res=true;
        while (fast!=null){
            if (slow.val!=fast.val)
                res=false;
            fast=fast.next;
            slow=slow.next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode a1=new ListNode(0);
        ListNode a2=new ListNode(2);
        ListNode a3=new ListNode(6);
        ListNode a4=new ListNode(6);
        ListNode a5=new ListNode(2);
        ListNode a6=new ListNode(0);
        a1.next=a2;
        a2.next=a3;
        a3.next=a4;
        a4.next=a5;
        a5.next=a6;
        System.out.println(isPalindrome(a1));
    }
}
