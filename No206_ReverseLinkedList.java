package Hot100.linkedlist;

import java.util.*;

//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
public class No206_ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        //做法一：用栈
//        Stack<ListNode> stack=new Stack<>();
//        ListNode dummy=new ListNode(0); //dummy node
//        if (head==null)
//            return null;
//        dummy.next=head;
//        ListNode temp=head;
//        while (temp!=null){
//            stack.push(temp);
//            temp=temp.next;
//        }
//        temp=dummy;
//        while (!stack.empty()){
//            ListNode cur=stack.pop();
//            temp.next=cur;
//            temp=cur;
//        }
//        temp.next=null; //反转后的最后一个节点（原头节点）必须使next为null，否则它的next指向倒数第二个节点，存在循环
//        return dummy.next;

        //做法二：队列
//        Queue<ListNode> queue=new LinkedList<>();
//        ListNode dummy=new ListNode(0);
//        if (head==null)
//            return null;
//        ListNode temp=head;
//        while (temp!=null){
//            queue.offer(temp);
//            temp=temp.next;
//        }
//        head.next=null;
//        while (!queue.isEmpty()){
//            temp= queue.poll();
//            temp.next=dummy.next;
//            dummy.next=temp;
//        }
//        return dummy.next;

        //做法三：不需引入栈或队列，只需一个哑节点，迭代即可，同做法二出列元素的加入链表方式。
        ListNode dummy=new ListNode(0);
        if (head==null)
            return null;
        ListNode temp=head;
        ListNode next=null;
        while (temp!=null){
            next=temp.next;
            temp.next=dummy.next;
            dummy.next=temp;
            temp=next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode a1=new ListNode(1);
        ListNode a2=new ListNode(2);
        ListNode a3=new ListNode(3);
        ListNode a4=new ListNode(4);
        ListNode a5=new ListNode(5);
        a1.next=a2;
        a2.next=a3;
        a3.next=a4;
        a4.next=a5;
        ListNode cur=reverseList(a1);
        //遍历打印
        while (cur!=null){
            System.out.print(cur+" ");
            cur=cur.next;
        }
    }
}
