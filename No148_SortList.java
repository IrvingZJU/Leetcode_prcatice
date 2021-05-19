package Hot100.linkedlist;
//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
public class No148_SortList {
    public static ListNode sortList(ListNode head) {
        //做法一：选择排序，未搞定
//        if (head==null || head.next==null){
//            return null;
//        }
//        ListNode dummy=new ListNode(-1);
//        dummy.next=head;
//        ListNode pre=head; //第一个指针
//        while (pre.next!=null){
//            ListNode temp=pre.next; //第二个指针
//            ListNode min=pre;
//            ListNode next=pre.next;
//            while (temp!=null){
//                if (temp.val< min.val){
//                    min=temp;
//                }
//                temp=temp.next;
//            }
//
//            pre=next;
//        }

        //做法二：冒泡排序，未完成真排序，只交换值得伪排序完成了
//        if (head==null || head.next==null){
//            return head;
//        }
//        int count_n=0;
//        ListNode count=head;
//        while (count!=null){
//            count_n++;
//            count=count.next;
//        }
//        ListNode dummy=new ListNode(-1);
//        dummy.next=head;
//        for (int i=0;i<count_n-1;i++){
//            ListNode temp= dummy.next;
//            for (int j=0;j<count_n-1-i;j++){
//                if (temp.val>temp.next.val){
////                    dummy.next=temp.next;
////                    temp.next=temp.next.next;
////                    dummy.next.next=temp;
//                    int exc=temp.next.val;
//                    temp.next.val=temp.val;
//                    temp.val=exc;
//                }
//                temp=temp.next;
//            }
//        }
//        return dummy.next;

        //参考做法一，归并排序（最适合链表的排序）-递归法
//        if (head == null || head.next == null)
//            return head;
//        ListNode slow=head,fast=head.next; //用快慢指针找出链表的中点，若链表有奇数个节点，则slow最后指向中点；若偶数节点，slow最后指向中点前一个节点。
//        while (fast!=null && fast.next!=null){ //判断条件为fast.next.next!=null的话会报错，因为如果fast在最后一个节点，那么fast.next已经是null,空节点无next
//            slow=slow.next; //快指针是慢指针速度的两倍
//            fast=fast.next.next;
//        }
//        ListNode temp=slow.next; //因为我们要将链表一分为二，前一段为head到slow，后一段为temp到尾
//        slow.next=null; //一分为二
//        ListNode left = sortList(head);
//        ListNode right = sortList(temp);
//        //合并操作
//        ListNode h = new ListNode(0);
//        ListNode res = h;
//        while (left != null && right != null) {
//            if (left.val < right.val) {
//                h.next = left;
//                left = left.next;
//            } else {
//                h.next = right;
//                right = right.next;
//            }
//            h = h.next;
//        }
//        if (left != null) h.next = left;
//        else h.next = right;
//        return res.next;

        //参考做法二：归并排序-迭代法，自底向上
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        dummyHead.next = head;
        // 先统计长度f
        ListNode p = dummyHead.next;
        int length = 0;
        while(p != null){
            ++length;
            p = p.next;
        }
        // 循环开始切割和合并
        for(int size = 1; size < length; size <<= 1){
            ListNode cur = dummyHead.next;
            ListNode tail = dummyHead;
            while(cur != null){
                ListNode left = cur;
                ListNode right = cut(cur, size); // 链表切掉size 剩下的返还给right
                cur = cut(right, size); // 链表切掉size 剩下的返还给cur
                tail.next = merge(left, right);
                while(tail.next != null){
                    tail = tail.next; // 保持最尾端
                }
            }
        }
        return dummyHead.next;
    }

    /**
     * 将链表L切掉前n个节点 并返回后半部分的链表头
     * @param head
     * @param n
     * @return
     */
    public static ListNode cut(ListNode head, int n){
        if(n <= 0) return head;
        ListNode p = head;
        // 往前走n-1步
        while(--n > 0 && p != null){
            p = p.next;
        }
        if(p == null) return null;
        ListNode next = p.next;
        p.next = null;
        return next;
    }

    /**
     * 合并list1和list2
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode merge(ListNode list1, ListNode list2){
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE), p = dummyHead;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                p.next = list1;
                list1 = list1.next;
            } else{
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }
        if(list1 == null){
            p.next = list2;
        } else{
            p.next = list1;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode a1=new ListNode(4);
        ListNode a2=new ListNode(2);
        ListNode a3=new ListNode(1);
        ListNode a4=new ListNode(3);
//        ListNode a5=new ListNode(0);
        a1.next=a2;
        a2.next=a3;
        a3.next=a4;
//        a4.next=a5;
        ListNode cur=sortList(a1);
        //遍历打印
        while (cur!=null){
            System.out.print(cur+" ");
            cur=cur.next;
        }
    }
}
