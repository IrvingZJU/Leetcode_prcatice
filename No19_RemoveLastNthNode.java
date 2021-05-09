package Hot100.linkedlist;
//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。进阶:使用一趟扫描实现.
public class No19_RemoveLastNthNode {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //我的解法一，两次遍历，第一次统计节点个数，第二次移动count-n到待删除节点的前一个节点，最后执行删除操作即可
//        ListNode temp=head;
//        int count=0;
//        while (temp!=null){
//            count++;//统计有多少个节点，统计完temp指向最后一个节点
//            temp=temp.next;
//        }
//        if (count==1)
//            return null;
//        else if (n>count) //异常情况，用异常处理更佳
//            throw new RuntimeException("n is illegal(too large)");
//        else if (count==n){
//            return head.next;
//        } else {
//            temp = head;//将temp移到表头，然后从头遍历count-n-1次，temp就移到待删除节点的前一个节点
//            for (int i = 0; i < count - n - 1; i++) {
//                temp = temp.next;
//            }
//            temp.next = temp.next.next;//执行删除操作
//            return head; }

        //我的解法二，双指针法，先在第一个节点和正数第n个节点分别安排一个指针，然后两个指针同时往后移动，当后面那个指针指向最后一个节点，
        // 即temp.next==null时，前面那个指针此时指向待删除节点的前一个节点，最后执行删除操作
        ListNode cur=head;
        ListNode temp=head;
        if (head.next==null) //只有一个节点的情况
            return null;
        for (int i=0;i<n-1;i++){
            temp=temp.next;
        }
        if (temp.next==null) //n==总节点数的情况
            return head.next;
        temp=temp.next;
        while (temp.next!=null){
            cur=cur.next;
            temp=temp.next;
        }
        cur.next=cur.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode a1=new ListNode(1);
//        ListNode a2=new ListNode(2);
//        ListNode a3=new ListNode(3);
//        ListNode a4=new ListNode(4);
//        ListNode a5=new ListNode(5);
//        a1.next=a2;
//        a2.next=a3;
//        a3.next=a4;
//        a4.next=a5;
        ListNode cur=removeNthFromEnd(a1,1);
        //遍历打印
        while (cur!=null){
            System.out.print(cur+" ");
            cur=cur.next;
        }
    }
}
