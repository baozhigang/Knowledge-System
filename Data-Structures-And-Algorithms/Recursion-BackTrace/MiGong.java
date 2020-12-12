/*
 * @Description: 回溯解决迷宫问题
 * @Author: baozhigang
 * @Date: 2020-12-12 17:54:50
 */

public class MiGong {
    public static void main(String[] args) {
        // 创建二维数组作为迷宫
        int[][] map = new int[8][7];
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;

        // 输出地图
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        // 递归回溯给小球找路
        setWay(map, 1, 1);

        // 输出地图，小球走过的路
        System.out.println("小球走过的路");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 使用递归回溯来给小球找路
     * 1.map 表示地图
     * 2.i,j 表示从地图的哪个位置开始出发（1,1）
     * 3.如果小球能找到 map[6][5]位置，说明通路找到
     * 4.约定：当 map[i][j]为 0表示没有走过，1表示墙，2表示通路可以走，3表示该点已走过但是走不通
     * 5.走迷宫时，需要确定一个策略（方法），下->右->上->左，如果该点走不通再回溯
     *
     * @param map 地图
     * @param i   从哪个位置开始找
     * @param j
     * @return    如果找到通路返回true，否则返回false
     * */
    public static boolean setWay(int[][] map, int i, int j) {
        if(map[6][5] == 2) {
            return true;    // 通路已找到
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2;
                if (setWay(map, i+1, j)) {
                    return true;
                } else if (setWay(map, i, j+1)) {
                    return true;
                } else if (setWay(map, i-1, j)) {
                    return true;
                } else if (setWay(map, i, j-1)) {
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}