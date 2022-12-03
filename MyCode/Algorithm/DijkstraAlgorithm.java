package Algorithm;

import java.util.Arrays;

public class DijkstraAlgorithm {

    public static void main(String[] args) {

        char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        //�ڽӾ���
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65535;// ��ʾ����������
        matrix[0]=new int[]{N,5,7,N,N,N,2};
        matrix[1]=new int[]{5,N,N,9,N,N,3};
        matrix[2]=new int[]{7,N,N,N,8,N,N};
        matrix[3]=new int[]{N,9,N,N,N,4,N};
        matrix[4]=new int[]{N,N,8,N,N,5,4};
        matrix[5]=new int[]{N,N,N,4,5,N,6};
        matrix[6]=new int[]{2,3,N,N,4,6,N};
        //���� Graph����
        Graph graph = new Graph(vertex, matrix);
        //����, ����ͼ���ڽӾ����Ƿ�ok
        graph.showGraph();
        //���ԵϽ�˹�����㷨
        graph.dsj(2);//C
        graph.showDijkstra();
    }

}

class Graph{

    private char[] vertex;
    private int[][] matrix;
    private VisitedVertex vv;

    public Graph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }

    public void showDijkstra() {
        vv.show();
    }

    public void showGraph() {
        for (int[] link : matrix) {
            System.out.println(Arrays.toString(link));
        }
    }

    public void dsj(int index) {
        vv = new VisitedVertex(vertex.length, index);
        update(index);
        for(int j = 1; j <vertex.length; j++) {
            index = vv.updateArr();
            update(index);
        }
    }

    private void update(int index){

        int len = 0;
        for(int j = 0; j < matrix[index].length; j++) {
            len = vv.getDis(index) + matrix[index][j];
            if(!vv.in(j) && len < vv.getDis(j)) {
                vv.updatePre(j, index);
                vv.updateDis(j, len);
            }
        }
    }
}

class VisitedVertex{

    public int[] already_arr;
    public int[] pre_visited;
    public int[] dis;

    public VisitedVertex(int length, int index) {
        already_arr = new int[length];
        pre_visited = new int[length];
        dis = new int[length];
        Arrays.fill(dis, 65535);
        already_arr[index] = 1;
        dis[index] = 0;
    }

    public boolean in(int index) {
        return already_arr[index] == 1;
    }

    public void updateDis(int index, int len) {
        dis[index] = len;
    }

    public void updatePre(int pre, int index) {
        pre_visited[pre] = index;
    }

    public int getDis(int index) {
        return dis[index];
    }

    public int updateArr(){

        int min = 65535, index = 0;
        for (int i = 0; i < already_arr.length; i++) {
            if (already_arr[i] == 0 && dis[i] < min){
                min = dis[i];
                index = i;
            }
        }

        already_arr[index] = 1;
        return index;
    }

    public void show(){

        System.out.println("==========================");
        //���already_arr
        for(int i : already_arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        //���pre_visited
        for(int i : pre_visited) {
            System.out.print(i + " ");
        }
        System.out.println();
        //���dis
        for(int i : dis) {
            System.out.print(i + " ");
        }
        System.out.println();
        //Ϊ�˺ÿ�������̾��룬���Ǵ���
        char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        int count = 0;
        for (int i : dis) {
            if (i != 65535) {
                System.out.print(vertex[count] + "("+i+") ");
            } else {
                System.out.println("N ");
            }
            count++;
        }
        System.out.println();
    }

}