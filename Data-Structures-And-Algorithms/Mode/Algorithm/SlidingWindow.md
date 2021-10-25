# 滑动窗口算法

### 思想

滑动窗口是高级的双指针算法，思路是这样的：

1、我们在字符串 S 中使用双指针中的左右指针技巧，初始化 left = right = 0，把索引闭区间 [left, right] 称为一个「窗口」。

2、我们先不断地增加 right 指针扩大窗口 [left, right]，直到窗口中的字符串符合要求（包含了 T 中的所有字符）。

3、此时，我们停止增加 right，转而不断增加 left 指针缩小窗口 [left, right]，直到窗口中的字符串不再符合要求（不包含 T 中的所有字符了）。同时，每次增加 left，我们都要更新一轮结果。

4、重复第 2 和第 3 步，直到 right 到达字符串 S 的尽头。

### 代码模板

    int left = 0, right = 0;

    while (right < s.size()) {
        window.add(s[right]);
        right++;

        while (valid) {
            window.remove(s[left]);
            left++;
        }
    }
    //window数据类型多为map，具体视情况而定
    //valid条件是关键
    //while代表循环，同时也可以使用其他循环来处理

### LeetCode上经典题型

[3.无重复字符的最长子串](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/)

[76.最小覆盖子串](https://leetcode-cn.com/problems/minimum-window-substring/)

[567.字符串的排列](https://leetcode-cn.com/problems/permutation-in-string/)

[438.找到字符串中所有字母异位词](https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/)


参考文章: [点这里](https://github.com/labuladong/fucking-algorithm/blob/master/%E7%AE%97%E6%B3%95%E6%80%9D%E7%BB%B4%E7%B3%BB%E5%88%97/%E6%BB%91%E5%8A%A8%E7%AA%97%E5%8F%A3%E6%8A%80%E5%B7%A7.md)