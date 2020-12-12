/**
 * 环形链表解决约瑟夫问题
 * 问题：
 *   小孩围成一圈
 *   n=5 有5个人
 *   k=1 从第1个人开始数数
 *   m=2 数2下
 *   数到的小孩出圈
 * 解决：
 *  a）创建一个辅助指针变量，指向环形链表最后一个节点
 *  b）小孩报数前，先让first和help移动k-1次
 *  c）小孩报数时，first和help同时移动m-1次
 *  d）这时将first指向的小孩节点出圈  first = first.next   helper.next = first
 */

public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();
        System.out.println();
        circleSingleLinkedList.countBoy(1, 2, 5);
    }
}

// 环形单向链表
class CircleSingleLinkedList {
    private Boy first = null;

    public void addBoy(int num) {
        if (num < 1) {
            System.out.println("num值不正确");
            return;
        }
        Boy curBoy = null;  // 辅助指针
        for (int i = 1; i <= num; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    public void showBoy() {
        if (first == null) {
            System.out.println("没有小孩");
            return;
        }
        Boy curBoy = first;  // 指针变量
        while(true) {
            System.out.printf("小孩的编号 %d \n", curBoy.getNo());
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

    /**
     * 小孩出圈
     * @param startNo 表示从第几个小孩开始数数
     * @param countNum  表示数几下
     * @param num 表示最初有多少个小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int num) {
        if (first == null || startNo < 1 || startNo > num) {
            System.out.println("参数有误");
            return;
        }
        // 辅助指针，指向环形链表的最后一个节点
        Boy helper = first;
        while(true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        // 小孩报数前，先让first和helper移动startNo-1次(从第startNo个小孩开始数)
        for (int i = 0; i < startNo-1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        // 循环操作，直到圈中只有一个节点
        while(true) {
            if (helper == first) {
                break;
            }
            // 让first和helper同时移动countNum-1次
            for (int j = 0; j < countNum-1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            // 此时的first节点，就是要出圈的小孩的节点
            System.out.printf("小孩%d出圈\n", first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("最后的小孩编号是 " + first.getNo());
    }
}

// Boy类，表示节点
class Boy {
    private int no;
    private Boy next;
    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}

