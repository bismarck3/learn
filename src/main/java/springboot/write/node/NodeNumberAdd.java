/**
 * @projectName springbootTest
 * @package springboot.write
 * @className springboot.write.NodeNumerAdd
 * @copyright Copyright 2021 Thuisoft, Inc. All rights reserved.
 */
package springboot.write.node;
/**
 * NodeNumerAdd
 *
 * @description 1 3 5 ,  2 4 6 -> 3 79
 * @author wangjing 链表相加
 * @date 2021/4/15 20:37
 * @version v1.0.0
 */
public class NodeNumberAdd {

    public LinkedNode nodeAdd (LinkedNode l1, LinkedNode l2) {
        LinkedNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int l1Adl2 = n1 + n2;
            if (head == null) {
                head = tail = new LinkedNode(l1Adl2 % 10);
            } else {
                tail.next = new LinkedNode(l1Adl2 % 10);
                tail = tail.next;
            }
            carry = l1Adl2 / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new LinkedNode(carry);
        }
        return head;
    }

    public static void main(String[] args) {
        LinkedNode l11 = new LinkedNode(1);
        LinkedNode l12 = new LinkedNode(2);
        LinkedNode l13 = new LinkedNode(3);
        l11.next = l12;
        l12.next = l13;
        // l2
        LinkedNode l21 = new LinkedNode(1);
        LinkedNode l22 = new LinkedNode(2);
        LinkedNode l23 = new LinkedNode(3);
        l21.next = l22;
        l22.next = l23;

        new NodeNumberAdd().nodeAdd(l11, l21);
    }



    static class LinkedNode {

        private Integer val;

        private LinkedNode next;

        public LinkedNode() {
        }

        public LinkedNode(Integer val) {
            this.val = val;
        }
    }

}



