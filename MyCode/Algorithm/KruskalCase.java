package Algorithm;

import java.util.Arrays;

public class KruskalCase {

    private int edgeNum; //�ߵĸ���
    private char[] vertexs; //��������
    private int[][] matrix; //�ڽӾ���
    //ʹ�� INF ��ʾ�������㲻����ͨ
    private static final int INF = Integer.MAX_VALUE;

    public KruskalCase(char[] vertexs, int[][] matrix){

//��ʼ���������ͱߵĸ���
        int vlen = vertexs.length;

        //��ʼ������, ���ƿ����ķ�ʽ
        this.vertexs = new char[vlen];
        for(int i = 0; i < vertexs.length; i++) {
            this.vertexs[i] = vertexs[i];
        }

        //��ʼ����, ʹ�õ��Ǹ��ƿ����ķ�ʽ
        this.matrix = new int[vlen][vlen];
        for(int i = 0; i < vlen; i++) {
            for(int j= 0; j < vlen; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }
        //ͳ�Ʊߵ�����
        for(int i =0; i < vlen; i++) {
            for(int j = i+1; j < vlen; j++) {
                if(this.matrix[i][j] != INF) {
                    edgeNum++;
                }
            }
        }
    }

    public void kruskal(){

        int index = 0; //��ʾ��������������
        int[] ends = new int[edgeNum]; //���ڱ���"������С������" �е�ÿ����������С�������е��յ�
        //�����������, ����������С������
        EData[] rets = new EData[edgeNum];

        EData[] edges = getEdges();
        System.out.println("ͼ�ıߵļ���=" + Arrays.toString(edges) + " ��"+ edges.length);

        sortEdges(edges);

        for (int i = 0;i < edgeNum;i++){

            int p1 = getPosition(edges[i].start);
            int p2 = getPosition(edges[i].end);


            int m = getEnd(ends, p1);
            int n = getEnd(ends, p2);

            if(m != n) {
                ends[m] = n;
                rets[index++] = edges[i];
            }
        }

        System.out.println("��С������Ϊ");
        for(int i = 0; i < index; i++) {
            System.out.println(rets[i]);
        }
    }

    public void print() {
        System.out.println("�ڽӾ���Ϊ: \n");
        for(int i = 0; i < vertexs.length; i++) {
            for(int j=0; j < vertexs.length; j++) {
                System.out.printf("%12d", matrix[i][j]);
            }
            System.out.println();//����
        }
    }
    private void sortEdges(EData[] edges) {
        for(int i = 0; i < edges.length - 1; i++) {
            for(int j = 0; j < edges.length - 1 - i; j++) {
                if(edges[j].weight > edges[j+1].weight) {//����
                    EData tmp = edges[j];
                    edges[j] = edges[j+1];
                    edges[j+1] = tmp;
                }
            }
        }
    }

    private int getPosition(char ch) {
        for(int i = 0; i < vertexs.length; i++) {
            if(vertexs[i] == ch) {//�ҵ�
                return i;
            }
        }
        //�Ҳ���,����-1
        return -1;
    }

    private EData[] getEdges() {
        int index = 0;
        EData[] edges = new EData[edgeNum];
        for(int i = 0; i < vertexs.length; i++) {
            for(int j=i+1; j <vertexs.length; j++) {
                if(matrix[i][j] != INF) {
                    edges[index++] = new EData(vertexs[i], vertexs[j], matrix[i][j]);
                }
            }
        }
        return edges;
    }

    private int getEnd(int[] ends, int i) { // i = 4 [0,0,0,0,5,0,0,0,0,0,0,0]
        while(ends[i] != 0) {
            i = ends[i];
        }
        return i;
    }
}

class EData {
    char start; //�ߵ�һ����
    char end; //�ߵ�����һ����
    int weight; //�ߵ�Ȩֵ
    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
    //��дtoString, �����������Ϣ
    @Override
    public String toString() {
        return "EData [<" + start + ", " + end + ">= " + weight + "]";
    }


}
