package Algorithm;

import java.util.Arrays;

public class PrimAlgorithm {

}

class MinTree{

    public void createGraph(MGraph graph, int verxs, char[] data, int[][] weight){
        int i,j;
        for (i = 0;i < verxs;i++){
            graph.data[i] = data[i];

            for (j = 0;j < verxs;j++){
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    public void showGraph(MGraph graph) {
        for(int[] link: graph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }

    public void prim(MGraph graph, int v){

        int visited[] = new int[graph.verxs];
        visited[v] = 1;
        int h1 = -1;
        int h2 = -1;
        int minWeight = 10000;

        for(int k = 1; k < graph.verxs; k++) {

            for(int i = 0; i < graph.verxs; i++) {
                for(int j = 0; j< graph.verxs;j++) {
                    if(visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight) {
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }

            System.out.println("边<" + graph.data[h1] + "," + graph.data[h2] + "> 权值:" + minWeight);
            visited[h2] = 1;
            minWeight = 10000;
        }

    }

}

class MGraph {
    int verxs; //表示图的节点个数
    char[] data;//存放结点数据
    int[][] weight; //存放边，就是我们的邻接矩阵

    public MGraph(int verxs) {
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }
}