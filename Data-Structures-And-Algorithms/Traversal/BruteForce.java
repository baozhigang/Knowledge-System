/**
 * 时间复杂度最坏O(n*m) 
 * 应用广泛原因有二：
 * 1）实际开发中效率要比最坏情况高很多   
 * 2）算法简单，简单是首选 
 */

public static int BruteForce(String str1, String str2) {
    char[] s1 = str1.toCharArray();
    char[] s2 = str2.toCharArray();

    int s1len = s1.length;
    int s2len = s2.length;
    int i = 0;
    int j = 0;
    while(i < s1len && j < s2len) {
        if (s1[i] == s2[j]) {
            i++;
            j++;
        } else {
            i = i - (j-1);  // i-j即回到上一次的初始位置 +1后移一位
            j = 0;
        }
    }

    if (j == s2.length) {
        return i-j;
    } else {
        return -1;
    }
}
