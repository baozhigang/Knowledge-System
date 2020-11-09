import java.util.Arrays;

/**
 * 普利姆算法
 * 思路：尽可能选择少的路线，并且每条路线最小，保证总里程数最少
 * 最小生成树：
 * 修路的问题本质是最小生成树的问题，N个顶点，N-1条边，包含全部顶点
 * 步骤：
 * 1.循环访问过的节点，和没访问过的节点，找到一条最小权重的边
 * 2.循环N-1次，找到N-1条边
 */
public class PrimAlgorithm {
    public static void main(String[] args) {
        // 图创建是否成功
        char[] data = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int verxs = data.length;
        int[][] weight = new int[][] {
                {100000,5,7,100000,100000,100000,2},
                {5,100000,100000,9,100000,100000,3},
                {7,100000,100000,100000,8,100000,100000},
                {100000,9,100000,100000,100000,4,100000},
                {100000,100000,8,100000,100000,5,4},
                {100000,100000,100000,4,5,100000,6},
                {2,3,100000,100000,4,6,100000}
        };
        // 创建图对象
        MGraph graph = new MGraph(verxs);
        // 创建最小生成树
        MinTree minTree = new MinTree();
        minTree.createGraph(graph, verxs, data, weight);
        // 展示
        minTree.showGraph(graph);
        // prim 算法
        minTree.prim(graph, 1);
    }
}
// 创建最小的生成树
class MinTree {
    // 创建图的邻接矩阵
    public void createGraph(MGraph graph, int verxs, char[] data, int[][] weight) {
        int i, j;
        for (i = 0;  i < verxs; i++) {
            graph.data[i] = data[i];  // 顶点
            for (j = 0; j < verxs; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }
    // 展示
    public void showGraph(MGraph graph) {
        for (int[] link : graph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }
    /**
     * prim算法，得到最小生成树
     *
     * @param graph 图
     * @param v 当前顶点的下标
     */
    public void prim(MGraph graph, int v) {
        int visited[] = new int[graph.verxs];
        visited[v] = 1;
        // 初始化找到的边的两个顶点的下标
        int h1 = -1;
        int h2 = -1;
        int minWeight = 100000;
        // 循环verxs-1次，找到verxs条边
        for (int k = 1; k < graph.verxs; k++) {
            // 找到一条最小边
            for (int i = 0; i < graph.verxs; i++) { // 已访问过的节点
                for (int j = 0; j < graph.verxs; j++) { // 未访问过的节点
                    if (visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight) {
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            // 找到一条最小边
            System.out.println("边<" + graph.data[h1] + "," + graph.data[h2] + ">权值：" + graph.weight[h1][h2]);
            visited[h2] = 1;
            minWeight = 100000;
        }
    }
}
// 构造图
class MGraph {
    int verxs; //图的节点
    char[] data; // 存放节点数据
    int[][] weight; //存放边，邻接矩阵

    public MGraph(int verxs) {
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }
}
