public class Hanoitower {
    public static void main(String[] args) {
        hanoiTower(5, 'A', 'B', 'C');
    }

    public static void hanoiTower(int num, char a, char b, char c) {
        // 如果只有一个盘
        if (num == 1) {
            System.out.println("第1个盘从 " + a + "->" + c);
        } else {
            // 如果有n>=2情况，我们总是可以看做2个盘，最下面是一个盘，其余的是一个盘
            // 1.先把上面所有的盘A->B，借助C
            hanoiTower(num-1, a, c, b);
            // 2.最下面的盘A->C
            System.out.println("第" + num + "个盘从 " + a + "->" + c);
            // 3.把B塔所有的盘从B->C，借助A
            hanoiTower(num-1, b, a, c);
        }
    }
}
