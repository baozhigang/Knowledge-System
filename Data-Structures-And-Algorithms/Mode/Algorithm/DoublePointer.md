# 双指针算法

双指针算法技巧可以再分为两类，一类是「快慢指针」，一类是「左右指针」。前者解决主要解决链表中的问题，比如典型的判定链表中是否包含环；后者主要解决数组（或者字符串）中的问题，比如二分查找。

### (一)快慢指针思想

快慢指针一般都初始化指向链表的头结点 head，前进时快指针 fast 在前，慢指针 slow 在后，巧妙解决一些链表中的问题。

### 代码模板

    ListNode fast, slow;
    fast = slow = head;
    while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;

        if (fast == slow)
    }
    //适用场景
    //1.判定链表中是否含有环
    //2.已知链表中含有环，返回这个环的起始位置
    //3.寻找链表的中点
    //4.寻找链表的倒数第 k 个元素


### LeetCode上经典题型

自己找吧 ☺



### (二)左右指针思想

左右指针在数组中实际是指两个索引值，一般初始化为 left = 0, right = nums.length - 1

### 代码模板

    int left = 0, right = nums.length - 1;
    while (left < right) {
        if () {

        }
    }
    //适用场景
    //1.二分查找
    //2.两数之和
    //3.反转数组
    //4.滑动窗口算法(高境界的双指针)


### LeetCode上经典题型

自己找吧 ☺

参考文章: [点这里](https://github.com/labuladong/fucking-algorithm/blob/master/%E7%AE%97%E6%B3%95%E6%80%9D%E7%BB%B4%E7%B3%BB%E5%88%97/%E5%8F%8C%E6%8C%87%E9%92%88%E6%8A%80%E5%B7%A7.md)